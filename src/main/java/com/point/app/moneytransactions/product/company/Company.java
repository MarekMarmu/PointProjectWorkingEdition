package com.point.app.moneytransactions.product.company;

import com.point.app.images.Image;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;

@Data
@Entity
@Table
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String name;

    @OneToOne
    private Image logo;

    private String phoneNumber;

    @Email
    private String email;

}