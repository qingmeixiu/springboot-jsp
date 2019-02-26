//package com.sinaif.hoover.controller;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.sinaif.hoover.AppWebApplication;
//
//
////@RunWith(SpringRunner.class)
////@SpringBootTest(classes = AppWebApplication.class)
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = AppWebApplication.class)
//@WebAppConfiguration
//public class TestController {
//	
//	private volatile int id = 0;
//	
//	@Autowired
//	private RedisTemplate redisTemplate;
//	
//	@Test
//	public void redisTest() {
//		ValueOperations valOpt = redisTemplate.opsForValue();
//		String obj = (String) valOpt.get("number");
//		valOpt.set("number", "22123");
//		System.out.println("redis demo success" + (String) valOpt.get("number"));
//	}
//	
//	
//	public static  void startThread(){
//			
//			new Thread(){
//				public void run(){
//	//				for (int i = 0; i < 10; i++) {
//						
//						id = id + 1;
//	//				}
//					System.out.println(id);
//				}
//			}.start();
//		}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	/**
//	@Test
//	public void redisTest2() {
//		ValueOperations valOpt = redisTemplate.opsForValue();
////		
////	String obj =(String) valOpt.get("number");
////		valOpt.set("number", "22123");
//		System.out.println("redis demo success"+(String) valOpt.get("number"));
//	}
//	
//	@Before
//	public void beforeMethod() {
//		System.out.println("junit demo success  --> beforeMethod !");
//	}
//	
//	@After
//	public void afterMethod() {
//		System.out.println("junit demo success  --> afterMethod !");
//	}
//	
//	@BeforeClass
//	public static void beforeClassMethod() {
//		System.out.println("junit demo success  --> beforeClassMethod !");
//	}
//	
//	@AfterClass
//	public static void afterClassMethod() {
//		System.out.println("junit demo success  --> afterClassMethod !");
//	}
//	
//	**/ 
//	
//
//}
