package com.khai.voroshylov.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    private Long id;
    private String name;
    private String country;
    private String city;
    private Date lastOrderDate;
    private String email;
    private String phone;
    private Integer orderCount;
}
