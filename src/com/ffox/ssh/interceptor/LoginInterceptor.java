package com.ffox.ssh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		
        //获取Session  
        HttpSession session = request.getSession();  
        Integer idUser = (Integer)session.getAttribute("idUser");  
          
        if(idUser != null){  
            return true;  
        }  
        //不符合条件的，跳转到登录界面  		
		response.sendRedirect("/shanhu1/login?next=".concat(request.getServletPath()));
		
		return false;

	}

	@Override
	public void afterCompletion(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object object,
			Exception arg3) throws Exception {
		
		HttpSession session = httpRequest.getSession();  
		
		httpRequest.setAttribute("name", session.getAttribute("name"));
		httpRequest.setAttribute("idUser", session.getAttribute("idUser"));

	}

	@Override
	public void postHandle(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object object,
			ModelAndView modelAndView) throws Exception {

	}
}
