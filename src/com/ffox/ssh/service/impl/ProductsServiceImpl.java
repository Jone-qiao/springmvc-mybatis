package com.ffox.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ffox.ssh.mapper.ProductsMapperCustom;
import com.ffox.ssh.po.ProductsCustom;
import com.ffox.ssh.po.ProductsQueryVo;
import com.ffox.ssh.service.ProductsService;

public class ProductsServiceImpl implements ProductsService{

	@Autowired
	private ProductsMapperCustom productsMapperCustom;

	@Override
	public List<ProductsCustom> getProductsList(ProductsQueryVo productsQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return productsMapperCustom.getProductsList(productsQueryVo);
	}

	@Override
	public ProductsCustom findProductById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return productsMapperCustom.findProductById(id);
	}
	
	
	
}
