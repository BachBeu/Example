package com.bach.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(max =50)
    private String name;

    private Date dateOfPurchase;
    private double price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Phone() {
    }

    public Phone(String name, Date dateOfPurchase, double price, String description, Category category) {
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    @Override
    public String toString(){
        return String.format("Phone[id=%d, name='%s', dateOfPurchase='%s', price='%s', description='%s'",id, name, dateOfPurchase, price, description);
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

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

/*    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }*/
}
