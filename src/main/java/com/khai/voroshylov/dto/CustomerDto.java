package com.khai.voroshylov.dto;

import lombok.Getter;
import lombok.Setter;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import java.util.Date;

@Getter
@Setter
@NotNull
@NotEmpty
public class CustomerDto {

    private Long id;

    @Length(max = 255)
    private String name;

    @Length(max = 58)
    private String country;

    @Length(max = 168)
    private String city;

    private Date lastOrderDate;

    @Length(max = 50)
    private String email;

    @Length(max = 17)
    private String phone;

    private Integer orderCount;

}
