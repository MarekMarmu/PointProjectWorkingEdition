package com.point.app.moneytransactions.gateway.payment;

import com.point.app.moneytransactions.product.Product;
import com.point.app.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "\"Payment\"")
public class Payment {

    @Id
    @SequenceGenerator(name = "payment_sequence", sequenceName = "payment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_sequence")
    private long paymentId;

    @NonNull
    @ManyToMany
    private List<Product> productNames;

    LocalDateTime paymentApprovalTime = LocalDateTime.now();


    @NonNull
    @ManyToOne
    private User user;
}
