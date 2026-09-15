package com.prog4.payment_receipts.service.tag;

import com.prog4.payment_receipts.repository.paymentReceipt.JpaPaymentReceiptRepository;
import com.prog4.payment_receipts.repository.tag.JpaTagRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TagDeleterService {

    private final JpaTagRepository tagRepository;
    private final TagFinderService tagFinderService;
    private final JpaPaymentReceiptRepository paymentReceiptRepository;

    public TagDeleterService(JpaTagRepository tagRepository, TagFinderService tagFinderService, JpaPaymentReceiptRepository paymentReceiptRepository) {
        this.tagRepository = tagRepository;
        this.tagFinderService = tagFinderService;
        this.paymentReceiptRepository = paymentReceiptRepository;
    }

    // como el metodo que desvincula tiene flush necesitamos tener esta anotacion transactional
    @Transactional
    public void delete(Long id) {
        tagFinderService.findEntityByIdForCurrentUser(id);
        //este emtodo borra todos los registros de la tabla intermedia para el id de tag a borrar
        paymentReceiptRepository.unlinkTagsFromReceipts(id);
        tagRepository.deleteById(id);
    }

}