package com.prog4.payment_receipts.controller.category;

import com.prog4.payment_receipts.dto.category.CategoryResponseDto;
import com.prog4.payment_receipts.service.category.CategoryFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryGetController {
    private final CategoryFinderService categoryFinderService;

    public CategoryGetController(CategoryFinderService categoryFinderService) {
        this.categoryFinderService = categoryFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getById(@PathVariable Long id){
        return  ResponseEntity.ok(categoryFinderService.findById(id));
    }
}
