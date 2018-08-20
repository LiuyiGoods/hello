package com.yd.shop.web.controller.product;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yd.comm.redis.RedisUtil;
import com.yd.model.TProduct;
import com.yd.shop.service.impl.ProductService;
import com.yd.shop.vo.Result;


@Controller
@RequestMapping("/prodmanage")
public class ProductController {
	
	@Resource
	ProductService productService;
	
	@Resource
	RedisUtil redis;
	
	
	@RequiresPermissions("goods:manage")
	@RequestMapping("/listUI")
	public String listUI(HttpServletRequest request) {
		return "product/listUI";
		//WEB-INF/jsp/product/listUI.jsp
	}
	
	@RequiresPermissions("goods:list")
	@RequestMapping("list")
	@ResponseBody
	public Result list(int offset, int limit,TProduct vo) {
		//RedisUtil redis = new RedisUtil();
		
		TProduct v = new TProduct();
		v.setProId(1);
		v.setProName("chanpin");
		redis.set("product", v);
		TProduct a = (TProduct) redis.get("product");
		System.out.println("aaaaaaaaaaaaaaaaaaaa:"+a.getProName());
		
		PageInfo<TProduct> pageInfo = this.productService.getListByPage(offset / limit + 1, limit,vo);
		return Result.succeed(pageInfo);
	}
	
	
/*//===================================保存/修改/删除方法=======================================	
	
	@RequestMapping("saveUI")
	public String saveUI(Integer id,HttpServletRequest request) {
		if (id != null) {
			User user = this.userService.getById(id);
			if (user != null) {
				request.setAttribute("user", user);
			}
		}
		return "user/saveUI";
	}
	
	
	@RequiresPermissions(value={"user:add","user:update"})
	@RequestMapping("save")
	public String add(User user) {
		if (user.getId() != null) {
			this.userService.update(user);
		} else {
			user.setCreateTime(new Date());
			user.setUpdateTime(user.getCreateTime());
			user.setPassword(MD5.getMd5BySalt(user.getPassword(), user.getUserName()));
			this.userService.save(user);
		}
		return "redirect:/user/listUI";
	}
	
	@RequiresPermissions("user:delete")
	@RequestMapping("delete/{ids}")
	@ResponseBody
	public Result delete(@PathVariable("ids") String ids) {
		
		String[] idsStr = ids.split(",");
		if (idsStr.length == 1) {
			this.userService.deleteById(Integer.parseInt(idsStr[0]));
		} else {
			this.userService.deleteBatchByIds(idsStr);
		}
		return Result.succeed();
	}
	*/
}
