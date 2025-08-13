package com.zrsedu.Fanxing;

import java.util.ArrayList;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) {
        /**
         * 1. 当进行: ArrayList<Dog> 这样的操作时，表示存放到 arrayList
         *    中的是 Dog类型 或是其 子类型
         * 2. 当放入其他类型的数据时，编译器会字直接报错
         * 3. 在遍历时 可以直接使用 Dog类型，而不是object类型，不用向下转型
         */
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("小黄",12));
        arrayList.add(new Dog("小蓝",12));
        arrayList.add(new Dog("小黑",12));

        //如果此时程序员不小心添加了猫类
//        arrayList.add(new Cat("造材",12));
//
        for (Dog obj :arrayList) {
            //向下转型
//            Dog obj1 = (Dog) obj;
            System.out.println(obj.getName() + "--" + obj.getAge());
        }


    }
}
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Cat{
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Person<E>{
    //E 表示 e 的数据类型，该数据类型是在定义Person对象的时候指定传入的泛型，即在编译期间，就确定 E为什么类型
    E e;
    public Person(E e){
        this.e = e;
    }

    public E function(){
        return e;
    }
}