package com.example.demo.service;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CartMapper;
import com.example.demo.pojo.Cart;

@Service
public class CartService {
	@Autowired
	CartMapper cartMapper;
	
	public List<Cart> selectAll(int userId){
		return this.cartMapper.selectAll(userId);
	}
	
	public int delete(int id) {
		return this.cartMapper.delete(id);
				
	}
	
	public Cart selectOne(int id) {
		return this.cartMapper.selectOne(id);
	}
	
	public double selectTotalPrice(int userId) {
		Double totalPrice = this.cartMapper.selectTotalPrice(userId);
		return totalPrice==null ? 0 :totalPrice;
	}
	
	public int checked(int id,int checked) {
		Cart cart = this.selectOne(id);
		cart.setChecked(checked);
		
		return this.cartMapper.update(cart);
	}
	/**
	 * 修改后返回该商品的小计
	 * @param id
	 * @param quantity
	 * @return
	 */
	public double updateQuantity(int id,int quantity) {
		Cart cart = this.selectOne(id);
		cart.setQuantity(quantity);
		
		this.cartMapper.update(cart);
		
		return cart.getQuantity()*cart.getGoodsPrice();
	}
}
