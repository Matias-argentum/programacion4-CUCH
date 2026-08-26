package com.prog4.payment_receipts.controller.category;

import com.prog4.payment_receipts.dto.category.CategoryResponseDto;
import com.prog4.payment_receipts.service.category.CategoriesSearcherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesGetController {

    private final CategoriesSearcherService categoriesSearcherService;

    public CategoriesGetController(CategoriesSearcherService categoriesSearcherService) {
        this.categoriesSearcherService = categoriesSearcherService;
    }

    // miren que este get es para todos, no solo pa el admin
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAll(){
        return ResponseEntity.ok(categoriesSearcherService.findAll());
    }
}
