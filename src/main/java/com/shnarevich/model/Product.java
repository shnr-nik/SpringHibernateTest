package com.shnarevich.model;

import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue()
    private Long id;

    @Getter @Setter private Integer code;
    @Getter @Setter private String name;
    @Getter @Setter private Double price;
    @Getter @Setter private Date date;

//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
}
