package com.zrsedu.Fanxing;



public class zidinyiFanxing {
    public static void main(String[] args) {
        Car car = new Car();
        //在调用方法时，传入参数，编译器就会确定 泛型类型
        // T-->String  R--> Integer
        car.fly("jack",100);
    }
}



class Car{

    /**
     * 1. <T, R>就是泛型
     * 2. 是提供给 fly()方法使用的
     */

    public <T, R> void fly(T t, R r){
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}