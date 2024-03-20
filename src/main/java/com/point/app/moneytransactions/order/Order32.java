package com.point.app.moneytransactions.order;

import jakarta.persistence.*;
import lombok.Data;

import java.util.concurrent.atomic.AtomicBoolean;

@Data
@Entity
@Table(name = "\"Order\"")
public class Order32 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private String orderStatus;

    private static final transient int boba = 0;


}
