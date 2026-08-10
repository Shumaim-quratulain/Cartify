package org.ecommerce.sbecom.repositories;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.ecommerce.sbecom.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {



    Category findByCategoryName(@NotBlank @Size(min=5, message = "category atleast contain 5 characters") String categoryname);
}
