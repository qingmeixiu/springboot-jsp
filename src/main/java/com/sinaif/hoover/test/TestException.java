//package com.sinaif.hoover.test;
//
//import java.io.FileNotFoundException;
//
//import kotlin.internal.Exact;
//import scala.util.control.Exception;
//
//public class TestException extends RuntimeException{
//	
//private static final long serialVersionUID = -3012142591549659513L;
//	
//	private String error;
//	private String message;
//	
//	public TestException(String error,String errorx){
//		this.error = error;
//		this.message = errorx;
//	}
//
//	public String getError() {
//		return error;
//	}
//
//	public void setError(String error) {
//		this.error = error;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	
//	
//	
//	
//	//--------------------------
//	
//	
//	
//	
//	public static void method() throws Exception{
//		
//		int i = 10/0;
//		
//		System.out.println("method:");
//	}
//	
//	public static void method1()  {
//		
//		try {
//			int i = 10/0;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			throw new NullPointerException();
//		}
//		System.out.println("method1:");
//	}
//	public static void method7()  {
//		
//		try {
//			int i = 10/0;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			throw new FileNotFoundException();
//		}
//		System.out.println("method1:");
//	}
//	
//	public static void method2() throws Exception{
//		try {
//			
//			int i = 10/0;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		 System.out.println("method2:");
//	}
//	public static void method3() throws Exception{
////		try {
////			
////			int i = 10/0;
////		} catch (Exception e) {
////			// TODO: handle exception
////		}
//		throw new FileNotFoundException("------");
////		 System.out.println("method3:");
//	}
//	public static void method6(){
////		try {
////			
////			int i = 10/0;
////		} catch (Exception e) {
////			// TODO: handle exception
////		}
////		throw new FileNotFoundException("------");
////		 System.out.println("method3:");
//		method1();
//	}
//	
//	public static void method4() {
//		method6();
////		throw new TestException("111","222");
//	}
//	
//	public static void method5() throws Exception{
//		throw new TestException("111","222");
//	}
//	
//	
//	
//	public static void main(String[] args) {
//		
////		try {
////			method5();
////		} catch (java.lang.Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		method4();
////		try {
////			method();
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		method1();
////		
////		try {
////			method2();
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		
//		try {
//			method6();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			if(e instanceof FileNotFoundException){
//				throw new ArithmeticException();
//			}
//			e.printStackTrace();
//		}
//	}
//	
//	
//
//}
