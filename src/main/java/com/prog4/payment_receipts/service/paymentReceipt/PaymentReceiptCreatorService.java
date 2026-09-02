package com.prog4.payment_receipts.service.paymentReceipt;

import com.prog4.payment_receipts.exception.category.CategoryNotFoundException;
import com.prog4.payment_receipts.model.category.Category;
import com.prog4.payment_receipts.model.paymentReceipt.PaymentReceipt;
import com.prog4.payment_receipts.model.tag.Tag;
import com.prog4.payment_receipts.model.user.User;
import com.prog4.payment_receipts.repository.category.JpaCategoryRepository;
import com.prog4.payment_receipts.repository.paymentReceipt.JpaPaymentReceiptRepository;
import com.prog4.payment_receipts.repository.tag.JpaTagRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentReceiptCreatorService {

    private final PaymentReceiptFileService fileService;
    private final JpaPaymentReceiptRepository receiptRepository;
    private final JpaCategoryRepository categoryRepository;
    private final JpaTagRepository tagRepository;

    public PaymentReceiptCreatorService(
            PaymentReceiptFileService fileService,
            JpaPaymentReceiptRepository receiptRepository,
            JpaCategoryRepository categoryRepository,
            JpaTagRepository tagRepository) {
        this.fileService = fileService;
        this.receiptRepository = receiptRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }

    public PaymentReceipt create(
            MultipartFile file,
            BigDecimal amount,
            LocalDate date,
            String description,
            Long categoryId,
            List<Long> tagIds) throws Exception {

        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // subimos a minio
        String nombreObjeto = fileService.upload(file);

        // gaurdamos la entidad
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        List<Tag> tags = tagIds == null ? List.of() : tagRepository.findAllById(tagIds);

        PaymentReceipt receipt = new PaymentReceipt();
        receipt.setAmount(amount);
        receipt.setDate(date);
        receipt.setDescription(description);
        receipt.setImageLink(nombreObjeto);
        receipt.setCategory(category);
        receipt.setTags(tags);
        receipt.setUser(currentUser);

        return receiptRepository.save(receipt);
    }
}