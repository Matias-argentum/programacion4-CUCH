package com.prog4.payment_receipts.controller.tag;

import com.prog4.payment_receipts.dto.tag.TagResponseDto;
import com.prog4.payment_receipts.service.tag.TagsSearcherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagsGetController {

    private final TagsSearcherService tagsSearcherService;

    public TagsGetController(TagsSearcherService tagsSearcherService) {
        this.tagsSearcherService = tagsSearcherService;
    }

    @GetMapping
    public ResponseEntity<List<TagResponseDto>> getAll() {
        return ResponseEntity.ok(tagsSearcherService.findAllForCurrentUser());
    }

}