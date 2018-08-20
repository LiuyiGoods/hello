package com.yd.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yd.dao.TProductMapper;
import com.yd.model.TProduct;


@Service
public class ProductService{

	@Autowired
	TProductMapper tProductMapper;
	
	public PageInfo<TProduct> getListByPage(int currentNum, int pageSize,TProduct record) {
		PageHelper.startPage(currentNum, pageSize);
		List<TProduct> list = tProductMapper.queryAll(record);
		PageInfo<TProduct> pageinfo = new PageInfo<TProduct>(list);
		return pageinfo;
	}

}
