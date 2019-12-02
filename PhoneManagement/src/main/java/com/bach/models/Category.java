package com.bach.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany(targetEntity = Category.class)
    private List<Phone> phone;

    public Category(){

    }

    public Category(String name, String description, List<Phone> phone) {
        this.name = name;
        this.description = description;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

}
