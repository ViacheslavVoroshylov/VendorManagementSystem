package com.khai.voroshylov.dto;

import com.khai.voroshylov.model.ProductCategory;
import lombok.Getter;
import lombok.Setter;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

@Getter
@Setter
@NotNull
@NotEmpty
public class ProductDto{

    private Long id;

    private ProductCategory category;

    @Length(max = 255)
    private String name;

    private Integer count;

    private Double price;

    @Length(max = 100)
    private String supplier;

}
