package com.demo.ssm.service.impl;

import com.demo.ssm.mapper.UserMapper;
import com.demo.ssm.pojo.User;
import com.demo.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserById(Long id) {
		return userMapper.selectUserById(id);

	}

}
