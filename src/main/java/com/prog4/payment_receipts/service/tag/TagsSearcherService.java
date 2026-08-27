package com.prog4.payment_receipts.service.tag;

import com.prog4.payment_receipts.dto.tag.TagResponseDto;
import com.prog4.payment_receipts.model.user.User;
import com.prog4.payment_receipts.repository.tag.JpaTagRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class TagsSearcherService {

    private final JpaTagRepository tagRepository;

    public TagsSearcherService(JpaTagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagResponseDto> findAllForCurrentUser() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //sortes es para comparar y que vengan por orden alfabetico puede hacerse desde jpa tamb
        return tagRepository.findAll().stream()
                .filter(tag -> tag.getUser().getId().equals(currentUser.getId()))
                .sorted(Comparator.comparing(tag -> tag.getName().toLowerCase()))
                .map(TagResponseDto::fromEntity)
                .toList();
    }

}