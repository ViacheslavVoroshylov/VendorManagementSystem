package com.khai.voroshylov.dto;

import com.khai.voroshylov.model.ProductCategory;
import lombok.Getter;
import lombok.Setter;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Max;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

@Getter
@Setter
public class ProductDto{

    private Long id;

    private ProductCategory category;

    @NotNull(message = "The name field is required")
    @NotBlank(message = "The name field should not be empty or contain only spaces")
    @Length(min = 2, max = 255, message = "The name field should be more than 2 characters and less than 255 characters")
    private String name;

    @NotNull(message = "The count field is required")
    @Min(value = 0, message = "The count field minimum value is 0")
    @Max(value = Integer.MAX_VALUE, message = "The count field maximum value is 2147483647")
    private Integer count;

    @NotNull(message = "The price field is required")
    @Min(value = 0, message = "The price field minimum value is 0")
    @Max(value = Double.MAX_VALUE, message = "The price field above the maximum allowed value.")
    private Double price;

    @NotNull(message = "The supplier field is required")
    @NotBlank(message = "The supplier field must not be empty or contain only spaces")
    @Length(min = 2, max = 100, message = "The supplier field should be more than 2 characters and less than 100 characters")
    private String supplier;

    @Override
    public String toString() {

        return "CustomerDto{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                ", price=" + price +
                ", supplier='" + supplier + '\'' +
                '}';
    }

}
