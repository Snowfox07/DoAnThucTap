package com.example.doanthuctap.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDTO {
    private int id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String description;
    @Min(value = 0, message = "Price cannot smaller than 0")
    @Max(value = 1000000000, message = "Price cannot bigger than 1,000,000,000")
    private long salePrice;
    @Min(value = 0, message = "Quantity cannot smaller than 0")
    @Max(value = 999999, message = "Quantity cannot bigger than 999,999")
    private int quantity;
    private String image;
    private String createdAt;
    private String updatedAt;
    private boolean isDelete;
    private CategoryDTO category;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salePrice=" + salePrice +
                ", quantity=" + quantity +
                '}';
    }
}
