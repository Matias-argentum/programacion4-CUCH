package com.prog4.payment_receipts.service.category;

import com.prog4.payment_receipts.dto.category.CategoryResponseDto;
import com.prog4.payment_receipts.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesSearcherService {
    private final JpaCategoryRepository categoryRepository;

    public CategoriesSearcherService(JpaCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponseDto> findAll(){

        return categoryRepository.findAll().stream()
                .map(category -> CategoryResponseDto.fromEntity(category))
                .toList();
            }
}
