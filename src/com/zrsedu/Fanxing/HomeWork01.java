package com.zrsedu.Fanxing;

import java.util.ArrayList;
import java.util.Comparator;

public class HomeWork01 {
    public static void main(String[] args) {
        Employee jack = new Employee("jack", 1234, new MyDate(1978, 12, 1));
        Employee tom = new Employee("tom", 12334, new MyDate(1968, 9, 1));
        Employee smith = new Employee("smith", 12324, new MyDate(2008, 5, 1));
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(jack);
        arrayList.add(tom);
        arrayList.add(smith);
        arrayList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 instanceof Employee && o2 instanceof Employee)){
                    return 0;
                }
                int i = o1.getName().compareTo(o2.getName());
                if (i != 0){
                    return i;
                }
                int i2 = o1.getBirthday().getYear() - o2.getBirthday().getYear();
                if (i2 != 0){
                    return i2;
                }
                int mouth = o1.getBirthday().getMouth() - o2.getBirthday().getMouth();
                if (mouth != 0){
                    return  mouth;
                }
                return o1.getBirthday().getDay() - o2.getBirthday().getDay();
            }
        });

        System.out.println("================排序后==================");
        System.out.println(arrayList);
    }
}

class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate{
    private int year;
    private int mouth;
    private int day;

    public MyDate(int year, int mouth, int day) {
        this.year = year;
        this.mouth = mouth;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", mouth=" + mouth +
                ", day=" + day +
                '}';
    }
}
