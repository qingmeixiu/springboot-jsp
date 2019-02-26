package com.sinaif.hoover.Proxy;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * reflect  反射，意思大概是：反射，是计算机程序的一种在运行时检查，反省(自省)并且修改自身行为、结构的能力。

 我们再浅显一点的理解就是：我们在运行时，对于任意一个人类可以知道这个类有什么方法属性，并且对于任意一个对象，我们可以在运行时调用它的一个方法，这就是反射。反射机制为我们提供了一下功能：

 1.判断类所具有的成员变量、方法。

 2.构造一个类的对象。

 3.判断一个对象的属于什么类

 4.调用一个对象的方法。
 */
public class Foo {
    private String name;
    private Integer age;
    private Date birthdary;


    public void printLog(){
        System.out.println("--------foo print----------");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdary() {
        return birthdary;
    }

    public void setBirthdary(Date birthdary) {
        this.birthdary = birthdary;
    }

    public static void main(String[] args) {
        /**
         * getName()：获得类的完整名字。
         getFields()：获得类的public类型的属性。
         getDeclaredFields()：获得类的所有属性。
         getMethods()：获得类的public类型的方法。
         getDeclaredMethods()：获得类的所有方法。
         getMethod(String name, Class[] parameterTypes)：获得类的特定方法，name参数指定方法的名字，parameterTypes 参数指定方法的参数类型。
         getConstructors()：获得类的public类型的构造方法。
         getConstructor(Class[] parameterTypes)：获得类的特定构造方法，parameterTypes 参数指定构造方法的参数类型。
         newInstance()：通过类的不带参数的构造方法创建这个类的一个对象。
         */
        Foo foo = new Foo();
        try {
            Object obj = Class.forName( "com.sinaif.hoover.Proxy.Foo" ).newInstance();
            // 获取对象方法
            Method[] methodArr = obj.getClass().getMethods();
            for (int i = 0; i < methodArr.length; i++) {

                System.out.println( methodArr[i].getName() );
            }

            Field[] fields = obj.getClass().getDeclaredFields();

            //实例化对象调用 Method
            foo.printLog();

            //反射调用Method
            Method method = obj.getClass().getDeclaredMethod( "printLog");
            method.invoke(obj);


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
