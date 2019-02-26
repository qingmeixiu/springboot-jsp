//package com.sinaif.hoover.test;
//
//public class TestFinal {
//	
//	public void testBaseType(final int i){
//		int n = i;
//		i = 9;
//		System.out.println("i = "+i);
//		System.out.println("n = "+n);
//	}
//	
//	public void testReferenceType(final Student stu){
//		
//		stu.setName("hoover");
//		stu.setAge(25);
//		System.out.println(stu.toString());
//		Student stu1 = new Student();
//		stu = stu1 ;
//		
//	}
//	public void testReferenceType1(Student stu){
//		
//		stu.setName("hoover");
//		stu.setAge(25);
//		System.out.println(stu.toString());
//		Student stu1 = new Student();
//		stu = stu1 ;
//		
//	}
//
//	
//	class Student{
//		private String name;
//		private Integer age;
//		
//		public String getName() {
//			return name;
//		}
//		public void setName(String name) {
//			this.name = name;
//		}
//		public Integer getAge() {
//			return age;
//		}
//		public void setAge(Integer age) {
//			this.age = age;
//		}
//		@Override
//		public String toString() {
//			return "Student [name=" + name + ", age=" + age + "]";
//		}
//		
//		
//	}
//}
