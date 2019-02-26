package com.sinaif.hoover.service;

import com.sinaif.hoover.model.UserInfoBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoService {
	public UserInfoBean query(Integer id);

	public boolean insert(UserInfoBean userInfoBean);

}
