package com.prog4.payment_receipts.config;

import com.prog4.payment_receipts.model.category.Category;
import com.prog4.payment_receipts.model.paymentReceipt.PaymentReceipt;
import com.prog4.payment_receipts.model.tag.Tag;
import com.prog4.payment_receipts.model.user.Role;
import com.prog4.payment_receipts.model.user.User;
import com.prog4.payment_receipts.repository.category.JpaCategoryRepository;
import com.prog4.payment_receipts.repository.paymentReceipt.JpaPaymentReceiptRepository;
import com.prog4.payment_receipts.repository.tag.JpaTagRepository;
import com.prog4.payment_receipts.repository.user.JpaUserRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// Se ejecuta solo al arrancar la aplicacion. Si ya hay datos, no hace nada...
@Component
public class DataSeeder implements CommandLineRunner {

    private final JpaUserRepository userRepository;
    private final JpaCategoryRepository categoryRepository;
    private final JpaTagRepository tagRepository;
    private final JpaPaymentReceiptRepository paymentReceiptRepository;

    public DataSeeder(JpaUserRepository userRepository,
                      JpaCategoryRepository categoryRepository,
                      JpaTagRepository tagRepository,
                      JpaPaymentReceiptRepository paymentReceiptRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
        this.paymentReceiptRepository = paymentReceiptRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0) {
            return;
        }

        Faker faker = new Faker();

        // 1 usuario
        User user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setPassword("1234"); // por ahora no hasheamos ni nada....
        user.setRole(Role.USER);
        user.setEnabled(true);
        user = userRepository.save(user);

        // creamos una sola categoria
        Category category = new Category();
        category.setName(faker.commerce().department());
        category.setIconName("bolt");
        category = categoryRepository.save(category);

        // creamos los tags
        List<Tag> tags = List.of(
                saveTag(faker.lorem().word(), user),
                saveTag(faker.lorem().word(), user),
                saveTag(faker.lorem().word(), user)
        );

        // aca creamos los recibos
        for (int i = 0; i < 3; i++) {
            PaymentReceipt receipt = new PaymentReceipt();
            receipt.setAmount(BigDecimal.valueOf(faker.number().randomDouble(2, 1000, 50000)));
            receipt.setDate(LocalDate.now().minusDays(faker.number().numberBetween(0, 60)));
            receipt.setDescription(faker.commerce().productName());
            receipt.setImageLink(null); //pasamos null porque no tenemos imagenes
            receipt.setUser(user);
            receipt.setCategory(category);
            receipt.setTags(List.of(tags.get(i)));
            paymentReceiptRepository.save(receipt);
        }

        System.out.println("Datos de prueba cargados con Datafaker: 1 usuario, 1 categoria, 3 tags, 3 payment receipts.");
    }

    private Tag saveTag(String name, User user) {
        Tag tag = new Tag();
        tag.setName(name);
        tag.setUser(user);
        return tagRepository.save(tag);
    }
}