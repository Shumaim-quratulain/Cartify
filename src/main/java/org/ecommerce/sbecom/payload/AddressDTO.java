package org.ecommerce.sbecom.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long addressId;

    @NotBlank(message = "Street name must not be blank")
    private String street;

    @NotBlank(message = "Building name must not be blank")
    private String buildingName;

    @NotBlank(message = "City name must not be blank")
    private String city;

    @NotBlank(message = "State name must not be blank")
    private String state;

    @NotBlank(message = "Country name must not be blank")
    @Size(min = 4, message = "Country name must contain at least 4 characters")
    private String country;

    @NotBlank(message = "Pincode must not be blank")
    private String pincode;
}