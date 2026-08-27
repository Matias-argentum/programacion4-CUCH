package com.prog4.payment_receipts.service.tag;

import com.prog4.payment_receipts.dto.tag.TagRequestDto;
import com.prog4.payment_receipts.dto.tag.TagResponseDto;
import com.prog4.payment_receipts.model.tag.Tag;
import com.prog4.payment_receipts.repository.tag.JpaTagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagUpdaterService {

    private final JpaTagRepository tagRepository;
    private final TagFinderService tagFinderService;

    public TagUpdaterService(JpaTagRepository tagRepository, TagFinderService tagFinderService) {
        this.tagRepository = tagRepository;
        this.tagFinderService = tagFinderService;
    }

    public TagResponseDto update(Long id, TagRequestDto request) {
        Tag tag = tagFinderService.findEntityByIdForCurrentUser(id);
        tag.setName(request.name());
        return TagResponseDto.fromEntity(tagRepository.save(tag));
    }

}