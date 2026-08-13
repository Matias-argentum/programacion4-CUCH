package com.prog4.payment_receipts.repository.category;

import com.prog4.payment_receipts.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<Category, Long> {
}
