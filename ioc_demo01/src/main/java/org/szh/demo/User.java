package org.szh.demo;

public class User {
    private String name;
    private String address;
    private Integer age123;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age123;
    }

    public void setAge(Integer age) {
        this.age123 = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age123 +
                '}';
    }
}
