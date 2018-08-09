package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping
	public String index(Model model,HttpSession session) {
		session.setAttribute("se", "session坎坎坷坷");
		model.addAttribute("books", this.bookService.selectAll());
		return "index";
	}
}
