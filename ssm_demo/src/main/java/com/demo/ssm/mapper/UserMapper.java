package com.demo.ssm.mapper;

import com.demo.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	
	public User selectUserById(@Param("id")Long id);

}
