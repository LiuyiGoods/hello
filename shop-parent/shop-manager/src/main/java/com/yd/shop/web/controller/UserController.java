package com.yd.shop.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.yd.comm.util.MD5;
import com.yd.model.User;
import com.yd.shop.service.RoleService;
import com.yd.shop.service.UserService;
import com.yd.shop.vo.Result;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequiresPermissions("user:listUI")
	@RequestMapping("/listUI")
	public String listUI(HttpServletRequest request) {
		return "user/listUI";
	}
	
	@RequiresPermissions("user:listUI")
	@RequestMapping("/list")
	@ResponseBody
	public Result list(int offset, int limit,String search) {
		
		PageInfo<User> pageInfo = this.userService.getListByPage(offset / limit + 1, limit, search);
		return Result.succeed(pageInfo);
	}
	
	
//===================================保存/修改/删除方法=======================================	
	
	@RequestMapping("/saveUI")
	public ModelAndView saveUI(Integer id) {
		ModelAndView md = new ModelAndView();
		if (id != null) {
			User user = this.userService.getById(id);
			if (user != null) {
				//request.setAttribute("user", user);
				md.addObject("user",user);
			}
		}
		md.setViewName("user/saveUI");
		return md;//"user/saveUI";
	}
	
	
	@RequiresPermissions(value={"user:add","user:update"})
	@RequestMapping("/save")
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
	
	@RequiresPermissions("user:setRole")
	@RequestMapping("setRole")
	@ResponseBody
	public Result setRole(int userId,String roleIds) {
		
		this.userService.saveUserRole(userId,roleIds);
		
		return Result.succeed();
	}
	
}
