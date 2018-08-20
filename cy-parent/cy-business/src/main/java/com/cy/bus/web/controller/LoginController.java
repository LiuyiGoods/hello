package com.cy.bus.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.bus.service.PermissionService;
import com.cy.bus.service.UserService;
import com.cy.bus.vo.Result;
import com.cy.model.User;


@Controller
public class LoginController {

	/*@Autowired
	private UserService userService;
	
	@Autowired
	private PermissionService permissionService;*/
	
	@RequestMapping("/loginn")
	@ResponseBody
	public Result login(String userName,String password) {
		
		UsernamePasswordToken token = new UsernamePasswordToken(userName.trim(), password.trim());
		Subject subject = SecurityUtils.getSubject();
		
		try {
			subject.login(token);
			token.setRememberMe(true);//记住我
		}catch (UnknownAccountException e) {
			return Result.fail(403, "用户名不存在");
			
		}catch(IncorrectCredentialsException e) {
			return Result.fail(403, "密码不正确");
			
		}
		
		return Result.succeed("resources/index.html");
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public Result logout(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return Result.succeed("/index.jsp");
	}
	
	@RequestMapping("manageUI")
	public String manageUI(HttpServletRequest request) {
		
		//主体
		Subject subject = SecurityUtils.getSubject();
		
		User user = (User) subject.getPrincipal();
        
		request.setAttribute("loginUser", user);
		
		return "manageUI";
	}
}
