package com.ffox.ssh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffox.ssh.po.ProductsCustom;
import com.ffox.ssh.po.ProductsQueryVo;
import com.ffox.ssh.service.ProductsService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductsService productsService;

	@RequestMapping(value="/")
	public String index(ProductsQueryVo productsQueryVo, HttpServletRequest request) throws Exception {
		
		List<ProductsCustom> productsList = productsService.getProductsList(productsQueryVo);
		
		request.setAttribute("products", productsList);
		
		return "home";
	}
	
}
