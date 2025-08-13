package com.zrsedu.Fanxing;

import org.junit.jupiter.api.Test;

import java.util.*;

public class HomeWork02 {
    public static void main(String[] args) {

    }
    @Test
    public void test(){
        DAO<User> dao = new DAO<>();
        dao.save("001",new User("001",13,"jcak"));
        dao.save("002",new User("002",12,"tom"));
        dao.save("003",new User("003",15,"smith"));
        List<User> list = dao.list();
        for (User user :list) {
            System.out.println(user);
        }
        //其他方法自行测试。。。。。。。

    }
}

class DAO<T> {
    //创建一个HashMap集合
    //其中 value 存放 User类对象
    private Map<String, T> map = new HashMap<>();

    /**
     * 将 key 为 id 和 value 为entity 的值存入 map集合中
     * @param id
     * @param entity
     */
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    /**
     * 取出 key 为 id的value值
     * @param id
     * @return
     */
    public T get(String id) {
        return map.get(id);
    }

    /**
     * 将 key 为 id 的value修改为 entity
     * @param id
     * @param entity
     */
    public void update(String id, T entity) {
        map.put(id, entity);
    }

    /**
     * 遍历得到 map 集合中的所有元素并保存到 list中
     * @return
     */
    public List<T> list() {
        List<T> list = new ArrayList();
        Set<String> set = map.keySet();
        for (String key : set) {
            list.add(map.get(key));
        }
        return list;
    }

    /**
     * 删除 key 为 id 的value值
     * @param id
     */
    public void delete(String id){
        map.remove(id);
    }

}


class User {
    private String id;
    private int age;
    private String name;

    public User(String id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}