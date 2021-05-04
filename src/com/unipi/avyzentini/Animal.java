package com.unipi.avyzentini;

import java.io.Serializable;

public class Animal implements Serializable {
    private String id;
    private String name;
    private String anim_class;
    private String weight;
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnim_class() {
        return anim_class;
    }

    public void setAnim_class(String anim_class) {
        this.anim_class = anim_class;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Animal(String id, String name, String anim_class, String weight, String age){
        this.id=id;
        this.age=age;
        this.name=name;
        this.anim_class=anim_class;
        this.weight=weight;
        this.age=age;

    }
}
