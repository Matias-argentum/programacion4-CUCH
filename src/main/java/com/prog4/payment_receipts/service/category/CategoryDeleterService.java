package com.prog4.payment_receipts.service.category;

import com.prog4.payment_receipts.exception.CategoryNotFoundException;
import com.prog4.payment_receipts.model.category.Category;
import com.prog4.payment_receipts.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryDeleterService {
    private final JpaCategoryRepository categoryRepository;

    public CategoryDeleterService(JpaCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void delete(Long id){
        Category foundCategory = categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException(id));

        categoryRepository.delete(foundCategory);
    }
}
