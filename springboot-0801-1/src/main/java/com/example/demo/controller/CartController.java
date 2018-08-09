package com.example.demo.controller;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("index")
	public String index(Model model) {
		model.addAttribute("carts", cartService.selectAll(1));
		double totalPrice = this.cartService.selectTotalPrice(1);
		model.addAttribute("totalPrice", totalPrice);
		return "cart/cart-index";
	}
	
	@GetMapping(value="delete/{id}")
	@ResponseBody
	public String delete(@PathVariable int id) {
		this.cartService.delete(id);
		double totalPrice = this.cartService.selectTotalPrice(1);
//		return NumberFormat.getCurrencyInstance().format(totalPrice);
		return NumberFormat.getInstance().format(totalPrice)+"";
//		return totalPrice;
	}
	
	@GetMapping(value="update/{id}")
	@ResponseBody
	public Object updateQuantity(@PathVariable int id,int quantity) {
		double subPrice = this.cartService.updateQuantity(id, quantity);
		double totalPrice = this.cartService.selectTotalPrice(1);
//		return NumberFormat.getCurrencyInstance().format(totalPrice);
		String price1 =  NumberFormat.getInstance().format(totalPrice)+"";
		String price2 =  NumberFormat.getInstance().format(subPrice)+"";
		Map<String,String> map = new HashMap<String,String>();
		map.put("totalPrice", price1);
		map.put("subPrice", price2);
		return map;
//		return totalPrice;
	}
	
	@GetMapping(value="updateChecked/{id}")
	@ResponseBody
	public Object updateChecked(@PathVariable int id,int checked) {
		this.cartService.checked(id, checked);
		double totalPrice = this.cartService.selectTotalPrice(1);
		String price1 =  NumberFormat.getInstance().format(totalPrice)+"";
		Map<String,String> map = new HashMap<String,String>();
		map.put("totalPrice", price1);
		return map;
	}
	
	@GetMapping(value="deleteAll")
	@ResponseBody
	public String delete(int[] id) {
		//System.out.println(id);
		for(int item :  id) {
			this.cartService.delete(item);
		}
		double totalPrice = this.cartService.selectTotalPrice(1);
//		return NumberFormat.getCurrencyInstance().format(totalPrice);
		return NumberFormat.getInstance().format(totalPrice)+"";
//		return totalPrice;
	} 
}
