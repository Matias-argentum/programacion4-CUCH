package com.prog4.payment_receipts.controller.tag;

import com.prog4.payment_receipts.service.tag.TagDeleterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
public class TagDeleteController {

    private final TagDeleterService tagDeleterService;

    public TagDeleteController(TagDeleterService tagDeleterService) {
        this.tagDeleterService = tagDeleterService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tagDeleterService.delete(id);
        return ResponseEntity.noContent().build();
    }

}