package com.prog4.payment_receipts.service.tag;

import com.prog4.payment_receipts.repository.tag.JpaTagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagDeleterService {

    private final JpaTagRepository tagRepository;
    private final TagFinderService tagFinderService;

    public TagDeleterService(JpaTagRepository tagRepository, TagFinderService tagFinderService) {
        this.tagRepository = tagRepository;
        this.tagFinderService = tagFinderService;
    }

    public void delete(Long id) {
        tagFinderService.findEntityByIdForCurrentUser(id);
        tagRepository.deleteById(id);
    }

}