package com.sinaif.hoover.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinaif.hoover.mapper.UserInfoBeanMapper;
import com.sinaif.hoover.model.UserInfoBean;
import com.sinaif.hoover.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoBeanMapper userMapper;
	
	@Override
	public UserInfoBean query(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	public UserInfoServiceImpl() {
		super();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public boolean insert(UserInfoBean userInfoBean) {
		return userMapper.insert(userInfoBean) > 0;
	}

}
