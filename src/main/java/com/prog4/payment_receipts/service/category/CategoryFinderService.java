package com.prog4.payment_receipts.service.category;

import com.prog4.payment_receipts.dto.category.CategoryResponseDto;
import com.prog4.payment_receipts.exception.CategoryNotFoundException;
import com.prog4.payment_receipts.model.category.Category;
import com.prog4.payment_receipts.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryFinderService {

    private final JpaCategoryRepository categoryRepository;

    public CategoryFinderService(JpaCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDto findById(Long id){
        Category foundCategory = categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException(id));

        return CategoryResponseDto.fromEntity(foundCategory);

    }
}
