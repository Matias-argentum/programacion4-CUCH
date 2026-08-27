package com.prog4.payment_receipts.service.tag;

import com.prog4.payment_receipts.dto.tag.TagResponseDto;
import com.prog4.payment_receipts.exception.tag.TagNotFoundException;
import com.prog4.payment_receipts.model.tag.Tag;
import com.prog4.payment_receipts.model.user.User;
import com.prog4.payment_receipts.repository.tag.JpaTagRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TagFinderService {

    private final JpaTagRepository tagRepository;

    public TagFinderService(JpaTagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag findEntityByIdForCurrentUser(Long id) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new TagNotFoundException(id));

        if (!tag.getUser().getId().equals(currentUser.getId())) {
            throw new TagNotFoundException(id);
        }

        return tag;
    }

    public TagResponseDto findById(Long id) {
        return TagResponseDto.fromEntity(findEntityByIdForCurrentUser(id));
    }

}