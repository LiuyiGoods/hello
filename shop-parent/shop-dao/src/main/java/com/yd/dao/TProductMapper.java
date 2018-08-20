package com.yd.dao;

import java.util.List;

import com.yd.model.TProduct;

public interface TProductMapper {
	
    int deleteByPrimaryKey(Integer proId);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    TProduct selectByPrimaryKey(Integer proId);
    
    List<TProduct> queryAll(TProduct record);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);
}