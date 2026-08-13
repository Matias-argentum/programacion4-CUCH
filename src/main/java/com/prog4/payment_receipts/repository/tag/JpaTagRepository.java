package com.prog4.payment_receipts.repository.tag;

import com.prog4.payment_receipts.model.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTagRepository extends JpaRepository<Tag, Long> {
}
