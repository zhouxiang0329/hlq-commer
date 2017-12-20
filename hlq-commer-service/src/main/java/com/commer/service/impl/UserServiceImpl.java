package com.commer.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.commer.app.UserService.UserService;
import com.commer.mapper.UserMapper;
import com.commer.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Resource  
    private UserMapper userMapper;
	@Override
	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User checkAdministratorsUser(String account, String password) {

		return userMapper.checkAdministratorsUser(account, password);
	}


}
