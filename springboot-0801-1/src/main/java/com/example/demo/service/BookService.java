package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.pojo.Book;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
	public List<Book> selectAll(){
		return this.bookMapper.selectAll();
	}
}
