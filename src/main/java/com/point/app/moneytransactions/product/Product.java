package com.point.app.moneytransactions.product;


        import com.point.app.images.Color;
        import com.point.app.images.Image;
        import com.point.app.moneytransactions.product.company.Company;
        import jakarta.persistence.*;
        import lombok.*;


        import java.io.Serializable;
        import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable {

    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;

    @ManyToOne
    @NonNull
    private Image mainImage;


    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Image> images;

    @NonNull
    private String name;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Color color;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Size size;

    @NonNull
    private Double price;

    @NonNull
    @ManyToOne
    private Company company; 

    @NonNull
    private Integer pieces;

    private Integer itemsSold;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String description;


}
