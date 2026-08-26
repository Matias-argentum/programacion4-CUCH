package com.prog4.payment_receipts.controller.category;

import com.prog4.payment_receipts.dto.category.CategoryRequestDto;
import com.prog4.payment_receipts.dto.category.CategoryResponseDto;
import com.prog4.payment_receipts.service.category.CategoryUpdaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryPutController {

    private final CategoryUpdaterService categoryUpdaterService;

    public CategoryPutController(CategoryUpdaterService categoryUpdaterService) {
        this.categoryUpdaterService = categoryUpdaterService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> update(@PathVariable Long id, @RequestBody CategoryRequestDto request){
        return ResponseEntity.ok(categoryUpdaterService.update(id, request));
    }
}
