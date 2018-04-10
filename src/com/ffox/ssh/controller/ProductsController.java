package com.ffox.ssh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffox.ssh.po.ProductsCustom;
import com.ffox.ssh.service.ProductsService;

@Controller
@RequestMapping(value="/product")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;

	@RequestMapping(value="/{id}")
	public String index(HttpServletRequest request, @PathVariable("id") Integer id) throws Exception {
		 
		ProductsCustom productsCustom = productsService.findProductById(id);		
		
		request.setAttribute("product", productsCustom);
		
		return "products/product";
	}
}
