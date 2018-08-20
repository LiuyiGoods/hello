package com.cy.manage.service;

import java.util.List;

import com.cy.model.Role;
import com.github.pagehelper.PageInfo;

public interface RoleService extends BaseService<Role>{

	PageInfo<Role> getListByPage(int currentNum, int pageSize, String name);

	void saveRolePermission(int roleId, String permissionIds);

	List<Role> getRoleListByUserId(int userId);

	void deleteBatchByIds(String[] idsStr);

}
