package com.prog4.payment_receipts.repository.paymentReceipt;

import com.prog4.payment_receipts.model.paymentReceipt.PaymentReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaPaymentReceiptRepository extends JpaRepository<PaymentReceipt, Long> {

    // modifying le avisa a jpa que no estamos ahciendo un SELECT y las opciones son para actualizar lo que haya en cache
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "DELETE FROM receipts_tags WHERE tag_id = :tagId", nativeQuery = true)
    void unlinkTagsFromReceipts(@Param("tagId") Long tagId);
}
