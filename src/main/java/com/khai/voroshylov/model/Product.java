package com.khai.voroshylov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {

    private Long id;
    private ProductCategory category;
    private String name;
    private Integer count;
    private Double price;
    private String supplier;

}
