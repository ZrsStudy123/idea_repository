package com.zrsedu.Fanxing;

import java.util.*;

public class Exercise01 {
    public static void main(String[] args) {
        //使用泛型，确保放入HashSet内的是 Student 类型
        Set<Student> arrayList = new HashSet<Student>();
        //使用泛型，确保放入HashMap内 Key的是 String类型, Value的是 Student 类型
        HashMap<String, Student> hashMap = new HashMap<String, Student>();
        Student s1 = new Student("jack", 12);
        Student s2 = new Student("tom", 13);
        Student s3 = new Student("smith", 15);
        //将三个对象存于HashSet
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        //将三个对象存于HashMap
        hashMap.put("jack",s1);
        hashMap.put("tom",s2);
        hashMap.put("smith",s3);

        //遍历HashSet
        //增强for循环
        System.out.println("=============增强for循环遍历================");
        for (Student student :arrayList) {
            System.out.println(student);
        }
        //迭代器
        System.out.println("==============迭代器遍历====================");
        Iterator<Student> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Student next =  iterator.next();
            System.out.println(next);
        }

        //遍历HashMap
        //使用KeySet()
        System.out.println("================KeySet遍历==================");
        Set<String> keySet = hashMap.keySet();  //存放了数据的Key值 (类型为String)
        for (String key :keySet) {
            System.out.println(hashMap.get(key));
        }
        //使用entrySet()遍历
        System.out.println("===============entrySet遍历==================");
        //存放了HashSet的 Key 和 Value(封装为Map.Entry类型)
        Set<Map.Entry<String, Student>> entrySet = hashMap.entrySet();
        for (Map.Entry entry :entrySet) {
            System.out.println(entry.getValue());
        }


    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}