package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.pojo.Cart;

public interface CartMapper {
	@Select("select * from Cart where userId=#{userId}")
	List<Cart> selectAll(@Param("userId") int userId);
	
	@Delete("delete from Cart where id=#{id}")
	int delete(@Param("id") int id);
	
	@Select("select * from Cart where id=#{id}")
	Cart selectOne(@Param("id") int id);
	
	@Select("select sum(quantity*goodsPrice) from Cart where userId=#{userId} and checked=1")
	Double selectTotalPrice(@Param("userId") int userId);
	
	@Update("update Cart set quantity=#{quantity},checked=#{checked} where id=#{id}")
	int update(Cart cart);
}
