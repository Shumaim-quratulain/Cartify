package org.ecommerce.sbecom.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Long cartItemId;
    private Integer quantity;
    private Double productPrice;
    private Double discount;
    private ProductDTO productDTO;
    private CartDTO cart;

}
