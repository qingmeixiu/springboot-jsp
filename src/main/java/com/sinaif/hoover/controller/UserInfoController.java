package com.sinaif.hoover.controller;

import com.sinaif.hoover.model.UserInfoBean;
import com.sinaif.hoover.service.UserInfoService;
import com.sinaif.hoover.utils.IdGenerator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
public class UserInfoController {
	
	@Autowired
	private UserInfoService userinfo;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping("/index")
    public String greeting() {
		System.out.println("---------greeting----------");
        return "/ftl/index";
    }
	@RequestMapping({"/login","/"})
	public String index() {
		System.out.println("---------index----------");
//		ModelAndView view = new ModelAndView();
//				view.setViewName("index");
		return "/ftl/index";
	}
	
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public String getUserInfo() {
		UserInfoBean u = userinfo.query(1);
		return "Hello -----World!"+u.getUname();
	}

	@RequestMapping("/insert")
	@ResponseBody
	public String save() {
		UserInfoBean u =  new UserInfoBean();
		u.setCreateTime(new Date());
		u.setUname("名字代号："+IdGenerator.getId());
		u.setId((int)(Math.random()*1000));
		System.out.println();
		boolean b = userinfo.insert(u);
		return b+"";
	}

	 
	

}
