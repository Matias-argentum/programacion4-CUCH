package com.prog4.payment_receipts.controller.tag;

import com.prog4.payment_receipts.dto.tag.TagResponseDto;
import com.prog4.payment_receipts.service.tag.TagFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
public class TagGetController {

    private final TagFinderService tagFinderService;

    public TagGetController(TagFinderService tagFinderService) {
        this.tagFinderService = tagFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(tagFinderService.findById(id));
    }

}