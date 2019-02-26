package com.sinaif.hoover.mapper;

import com.sinaif.hoover.model.UserInfoBean;

public interface UserInfoBeanMapper {
	
	UserInfoBean selectByPrimaryKey(Integer id);

	int  insert(UserInfoBean userInfoBean);

}
