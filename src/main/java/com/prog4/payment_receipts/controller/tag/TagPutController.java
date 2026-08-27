package com.prog4.payment_receipts.controller.tag;

import com.prog4.payment_receipts.dto.tag.TagRequestDto;
import com.prog4.payment_receipts.dto.tag.TagResponseDto;
import com.prog4.payment_receipts.service.tag.TagUpdaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
public class TagPutController {

    private final TagUpdaterService tagUpdaterService;

    public TagPutController(TagUpdaterService tagUpdaterService) {
        this.tagUpdaterService = tagUpdaterService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagResponseDto> update(@PathVariable Long id, @RequestBody TagRequestDto request) {
        return ResponseEntity.ok(tagUpdaterService.update(id, request));
    }

}