package com.khai.voroshylov.web.domain;

import lombok.Getter;
import lombok.Setter;
import net.sf.oval.constraint.DateRange;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Max;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Past;

import java.util.Date;

@Getter
@Setter
public class CustomerDto {

    private Long id;

    @NotNull(message = "The name field is required")
    @NotBlank(message = "The name field should not be empty or contain only spaces")
    @Length(min = 1, max = 255, message = "The name field should be more than 1 character and less than 255 characters")
    private String name;

    @NotNull(message = "The country field is required")
    @NotBlank(message = "The country field should not be empty or contain only spaces")
    @Length(min = 3, max = 58, message = "The country field should be more than 3 characters and less than 58 characters")
    private String country;

    @NotNull(message = "The city field is required")
    @NotBlank(message = "The city field should not be empty or contain only spaces")
    @Length(min = 1, max = 168, message = "The city field should be more than 1 character and less than 168 characters")
    private String city;

    @NotNull(message = "The lastOrderDate field is required")
    @Past (message = "lastOrderDate must not be past")
    @DateRange(format = "yyyy-MM-dd", min = "2001-01-01", message = "Wrong date range.")
    private Date lastOrderDate;

    @NotNull(message = "The email field is required")
    @NotBlank(message = "The email field should not be empty or contain only spaces")
    @Length(min = 6, max = 50, message = "The email field should be more than 6 characters and less than 50 characters")
    private String email;

    @NotNull(message = "The phone field is required")
    @NotBlank(message = "The phone field should not be empty or contain only spaces")
    @Length(min = 3, max = 17, message = "The phone field should be more than 3 characters and less than 17 characters")
    private String phone;

    @NotNull(message = "The order count field is required")
    @Min(value = 0, message = "The order count field minimum value is 0")
    @Max(value = Integer.MAX_VALUE, message = "The order count field maximum value is 2147483647")
    private Integer orderCount;

    @Override
    public String toString() {

        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", lastOrderDate=" + lastOrderDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", orderCount=" + orderCount +
                '}';
    }
}
