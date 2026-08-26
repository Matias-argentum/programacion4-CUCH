package com.prog4.payment_receipts.controller.category;

import com.prog4.payment_receipts.dto.category.CategoryRequestDto;
import com.prog4.payment_receipts.dto.category.CategoryResponseDto;
import com.prog4.payment_receipts.service.category.CategoryDeleterService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryDeleteController {
    private final CategoryDeleterService categoryDeleterService;

    public CategoryDeleteController(CategoryDeleterService categoryDeleterService) {
        this.categoryDeleterService = categoryDeleterService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id){
        categoryDeleterService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
