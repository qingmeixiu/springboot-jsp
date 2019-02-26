package com.sinaif.hoover.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sinaif.hoover.AppWebApplication;

/**方式一 （boot 1.4 之后）
 * 
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppWebApplication.class)

/**方式二 （boot 1.4 之前）
 * 
 */

//junit 还提供了  @DataJpaTest，@JsonTest，@JdbcTest  (SpringBootTest 是此Demo)等测试用例   有兴趣的可以研究
//一个测试类单元测试的执行顺序为：
//
//@BeforeClass –> @Before –> @Test –> @After –> @AfterClass
//
//每一个测试方法的调用顺序为：
//
//@Before –> @Test –> @After

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppWebApplication.class)
@WebAppConfiguration
public class Test1Controller {
	
	
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	public void redisTest() {
		ValueOperations valOpt = redisTemplate.opsForValue();
		System.out.println("redis demo success"+(String) valOpt.get("number"));
	}
	
	@Test  //测试方法，在这里可以测试期望异常和超时时间
	public void redisTest2() {
		ValueOperations valOpt = redisTemplate.opsForValue();
		System.out.println("redis demo success"+(String) valOpt.get("number"));
	}
	
	@Before //初始化方法 每次执行 test 都会执行 before 和 after 
	public void beforeMethod() {
		System.out.println("junit demo success  --> beforeMethod !");
	}
	
	@After  //释放资源
	public void afterMethod() {
		System.out.println("junit demo success  --> afterMethod !");
	}
	
	@BeforeClass  //针对所有测试，只执行一次，且必须为static void
	public static void beforeClassMethod() {
		System.out.println("junit demo success  --> beforeClassMethod !");
	}
	
	@AfterClass  //针对所有测试，只执行一次，且必须为static void
	public static void afterClassMethod() {
		System.out.println("junit demo success  --> afterClassMethod !");
	}
	
	@Ignore //忽略的测试方法
	public static void ignoreMethod() {
		System.out.println("junit demo success  --> ignoreMethod !");
	}
	
	 
	

}
