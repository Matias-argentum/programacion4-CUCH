package com.prog4.payment_receipts.service.tag;

import com.prog4.payment_receipts.dto.tag.TagRequestDto;
import com.prog4.payment_receipts.dto.tag.TagResponseDto;
import com.prog4.payment_receipts.model.tag.Tag;
import com.prog4.payment_receipts.model.user.User;
import com.prog4.payment_receipts.repository.tag.JpaTagRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TagCreatorService {

    private final JpaTagRepository tagRepository;

    public TagCreatorService(JpaTagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagResponseDto create(TagRequestDto request) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Tag tag = new Tag();
        tag.setName(request.name());
        tag.setUser(currentUser);
        System.out.println("en service creador");

        return TagResponseDto.fromEntity(tagRepository.save(tag));
    }

}