package com.sinaif.hoover.test;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class TestThread {
	public static  int id = 0;
	
	private static ExecutorService executor = Executors.newFixedThreadPool(50);
	private static Executor executor1 = Executors.newFixedThreadPool(50);
	private static AbstractExecutorService executor3 = (AbstractExecutorService) Executors.newFixedThreadPool(50);
	private static ThreadPoolExecutor executor2 = (ThreadPoolExecutor) Executors.newFixedThreadPool(50);
	
	public static  void startThread(){
		
		new Thread(){
			public void run(){
//				for (int i = 0; i < 10; i++) {
					
					id = id + 1;
//				}
				System.out.println(id);
			}
		}.start();
	}
//	public static void main(String[] args) {
//		executor.execute(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("executor");
//				
//			}
//		});
//		
//		executor1.execute(new Thread(){
//			public void run() {
//				System.out.println("executor1");
//				
//			}
//		});
//		executor2.execute(new Thread(){
//			public void run() {
//				System.out.println("executor2");
//				
//			}
//		});
//		executor3.execute(new Thread(){
//			public void run() {
//				System.out.println("executor3");
//				
//			}
//		});
//		
////		for (int i = 0; i < 10000; i++) {
////			startThread();
////		}
//				
//			
////		System.out.println("最终："+id);
//	}

}
