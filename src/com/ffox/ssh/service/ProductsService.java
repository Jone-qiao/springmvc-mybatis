package com.ffox.ssh.service;

import java.util.List;

import com.ffox.ssh.po.ProductsCustom;
import com.ffox.ssh.po.ProductsQueryVo;

public interface ProductsService {

	public List<ProductsCustom> getProductsList(ProductsQueryVo productsQueryVo) throws Exception;
	
	public ProductsCustom findProductById(Integer id) throws Exception;
	
}
