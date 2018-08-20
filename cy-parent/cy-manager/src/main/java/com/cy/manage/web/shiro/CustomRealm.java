package com.cy.manage.web.shiro;

import java.util.List;
import java.util.Map;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.cy.comm.util.MySimpleByteSource;
import com.cy.manage.service.PermissionService;
import com.cy.manage.service.UserService;
import com.cy.model.Permission;
import com.cy.model.User;
import com.github.pagehelper.util.StringUtil;


public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private PermissionService permissionService;

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户名
		String userName = (String) token.getPrincipal();
		// 通过用户名获取用户对象
		User user = this.userService.findUserByUserName(userName);

		if (user == null) {
			return null;
		}

		// 通过 userId 获取该用户拥有的所有权限，返回值根据自己要求设置，并非固定值。
		Map<String,List<Permission>> permissionMap = this.permissionService.getPermissionMapByUserId(user.getId());

		// （目录+菜单，分层级）
		user.setMenuList(permissionMap.get("menuList"));
		// （目录+菜单+按钮）
		user.setPermissionList(permissionMap.get("permissionList"));
		  //盐值  
		//MySimpleByteSource credentialsSalt = MySimpleByteSource(user.getSalt());  
		//ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user, user.getPassword(),new MySimpleByteSource(user.getUserName()),this.getName());  
		//SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),user.getSalt(),this.getName());

		return info;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // （目录+菜单+按钮）
        List<Permission> permissionList = user.getPermissionList();

        for (Permission permission : permissionList) {
        	if (StringUtil.isNotEmpty(permission.getCode())) {
        		info.addStringPermission(permission.getCode());
        	}
        }

		return info;
	}
	  /** 
     * 清除所有用户授权信息缓存. 
     */  
    public void clearCachedAuthorizationInfo(String principal) {  
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());  
        clearCachedAuthorizationInfo(principals);  
    }  
  
    /** 
     * 清除所有用户授权信息缓存. 
     */  
    public void clearAllCachedAuthorizationInfo() {  
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();  
        if (cache != null) {  
            for (Object key : cache.keys()) {  
                cache.remove(key);  
            }  
        }  
    }  
    /** 
     *  
    * @Title: clearAuthz  
    * @Description: TODO 清楚缓存的授权信息   
    * @return void    返回类型 
     */  
    public void clearAuthz(){  
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());  
    }  
}
