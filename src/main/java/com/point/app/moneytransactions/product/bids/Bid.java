package com.point.app.moneytransactions.product.bids;

import com.point.app.moneytransactions.product.Product;
import com.point.app.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User bidder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDateTime bidTime;


}