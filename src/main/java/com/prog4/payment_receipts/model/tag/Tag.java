package com.prog4.payment_receipts.model.tag;

import com.prog4.payment_receipts.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    //asi quedaria si quisieramos que la relacion sea bidireccional... el mapped by es
    // para que la tabla intermedia se cree del lado de la entidad dueña que es payment receipt

    // @ManyToMany(mappedBy = "tags")
    // private List<PaymentReceipt> paymentReceipts;

}
