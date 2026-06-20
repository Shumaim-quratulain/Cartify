package org.ecommerce.sbecom.service;

import org.ecommerce.sbecom.model.Category;
import org.ecommerce.sbecom.payload.CategoryDTO;
import org.ecommerce.sbecom.payload.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryID);

    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);
}
