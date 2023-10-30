package Pracownia.Projekt.Spring.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostAuthorDTO {
    @Size(min = 2, message = "first name should have at least 2 characters")
    @NotBlank
    private String firstName;

    @Size(min = 2, message = "last name should have at least 2 characters")
    @NotBlank
    private String lastName;
}
