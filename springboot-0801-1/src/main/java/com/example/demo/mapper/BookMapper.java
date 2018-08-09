package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.Book;

public interface BookMapper {
	@Select("select bookId,title,price from book")
	public List<Book> selectAll();
}
