package com.yd.shop.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yd.model.User;
import com.yd.shop.service.PermissionService;
import com.yd.shop.service.UserService;
import com.yd.shop.vo.Result;


@Controller
public class LoginController {
	

	@RequestMapping("/login")
	@ResponseBody
	public Result login(String userName,String password,HttpServletRequest request) {
		
		UsernamePasswordToken token = new UsernamePasswordToken(userName.trim(), password.trim());
		Subject subject = SecurityUtils.getSubject();
		//String sid = (String) subject.getSession().getId();
		//long time = subject.getSession().getTimeout();
		//String i = request.getSession().getId();
		//long t = request.getSession().getMaxInactiveInterval();
		ThreadContext.remove(ThreadContext.SUBJECT_KEY);
		try {
			subject.login(token);
			//token.setRememberMe(true);//记住我
		}catch (UnknownAccountException e) {
			return Result.fail(403, "用户名不存在");
			
		}catch(IncorrectCredentialsException e) {
			return Result.fail(403, "密码不正确");
			
		}
		
		return Result.succeed("manageUI");
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public Result logout(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return Result.succeed("/index.jsp");
	}
	
	@RequestMapping("/manageUI")
	public String manageUI(HttpServletRequest request) {
		//在线人数
		/*int num = sessionDAO.getActiveSessions().size();
		System.out.println(num);*/
		//主体
		Subject subject = SecurityUtils.getSubject();
		String sid = (String) subject.getSession().getId();
		
		User user = (User) subject.getPrincipal();
        
		request.setAttribute("loginUser", user);
		
		return "manageUI";
	}
}
