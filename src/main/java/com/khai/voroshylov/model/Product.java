package com.khai.voroshylov.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Product {

    private Long id;
    private ProductCategory category;
    private String name;
    private Integer count;
    private Double price;
    private String supplier;

}
