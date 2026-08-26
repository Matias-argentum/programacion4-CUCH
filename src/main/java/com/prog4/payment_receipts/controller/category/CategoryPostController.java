package com.prog4.payment_receipts.controller.category;

import com.prog4.payment_receipts.dto.category.CategoryRequestDto;
import com.prog4.payment_receipts.dto.category.CategoryResponseDto;
import com.prog4.payment_receipts.service.category.CategoryCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryPostController {
    private final CategoryCreatorService categoryCreatorService;

    public CategoryPostController(CategoryCreatorService categoryCreatorService) {
        this.categoryCreatorService = categoryCreatorService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryRequestDto request){
        CategoryResponseDto response = categoryCreatorService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
