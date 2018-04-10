package com.ffox.ssh.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ffox.ssh.helper.MD5;
import com.ffox.ssh.po.MembersCustom;
import com.ffox.ssh.service.MembersService;

@Controller
public class LoginController {
	
	@Autowired
	private MembersService membersService;
	
	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public String loginPage(@RequestParam("next") Optional<String> next, 
			HttpSession session, HttpServletRequest request) throws Exception {
		
		Integer idUser = (Integer)session.getAttribute("idUser");  
		if (idUser != null) {
			return "redirect:/";
		}
		
		request.setAttribute("next", next.orElse("/"));

		return "auth/login";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public String login(@RequestParam("next") Optional<String> next, 
			HttpSession session, HttpServletRequest request, 
			@ModelAttribute("member") MembersCustom membersCustrom) throws Exception {
		
		//定义错误信息数组
		List<String> authErrors = new ArrayList<String>();
		
		//判断用户名密码算法为空
		if ((membersCustrom.getLoginName() == null || membersCustrom.getLoginName() == "") 
				|| (membersCustrom.getPasswd() == null || membersCustrom.getPasswd() == "")) {
			authErrors.add("用户名密码不能为空");
			request.setAttribute("authErrors", authErrors);
	
			return "auth/login";
		}
		
		//根据用户名loginName 查询用户
		MembersCustom member = membersService.findMemberByLoginName(membersCustrom.getLoginName());
		//判断用户是否存在
		if (member == null) {
			authErrors.add("用户不存在");	
			request.setAttribute("authErrors", authErrors);
			
			return "auth/login";
		}
		
		//判断密码是否正确
		if(!member.getPasswd().equals(MD5.MD5str(membersCustrom.getPasswd()))) {
			authErrors.add("密码错误");	
			request.setAttribute("authErrors", authErrors);
			
			return "auth/login";
		}
		
		session.setAttribute("idUser", member.getIdUser());
		session.setAttribute("name", member.getName());
		
		return "redirect:".concat(next.orElse("/"));
	}
	
	//退出
	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}

}
