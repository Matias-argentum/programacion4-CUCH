package com.prog4.payment_receipts.controller.tag;

import com.prog4.payment_receipts.dto.tag.TagRequestDto;
import com.prog4.payment_receipts.dto.tag.TagResponseDto;
import com.prog4.payment_receipts.service.tag.TagCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
public class TagPostController {

    private final TagCreatorService tagCreatorService;

    public TagPostController(TagCreatorService tagCreatorService) {
        this.tagCreatorService = tagCreatorService;
    }

    @PostMapping
    public ResponseEntity<TagResponseDto> create(@RequestBody TagRequestDto request) {
        TagResponseDto response = tagCreatorService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}