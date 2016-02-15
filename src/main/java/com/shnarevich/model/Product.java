package com.shnarevich.model;

import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue()
    private Long id;
    private Integer code;
    private String name;
    private Double price;
    private Date date;

}
