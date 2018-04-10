package com.ffox.ssh.mapper;

import java.util.List;

import com.ffox.ssh.po.ProductsCustom;
import com.ffox.ssh.po.ProductsQueryVo;

public interface ProductsMapperCustom {

	public List<ProductsCustom> getProductsList(ProductsQueryVo productsQueryVo) throws Exception;
		
	public ProductsCustom findProductById(Integer id) throws Exception;
	
}
