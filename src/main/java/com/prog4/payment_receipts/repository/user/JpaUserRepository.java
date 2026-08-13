package com.prog4.payment_receipts.repository.user;

import com.prog4.payment_receipts.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {
}
