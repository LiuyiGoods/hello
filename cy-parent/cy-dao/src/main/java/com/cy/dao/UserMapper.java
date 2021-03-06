package com.cy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cy.model.User;

import tk.mybatis.mapper.common.Mapper;


public interface UserMapper extends Mapper<User>{

	User getUserByUserName(String userName);

	void deleteBatchByIds(@Param("ids") String[] idsStr);

	void deleteUserRoleByUserId(int userId);

	void saveUserRole(@Param("list") List<Map<String, Integer>> params);

}
