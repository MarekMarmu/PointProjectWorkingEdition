package com.point.app.images;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

@Transactional
@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor

public class Image {

    @Id
    @SequenceGenerator(name = "image_sequence", sequenceName = "image_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_sequence")
    private Long id;

    @NonNull
    private String imageName;

    @NonNull
    private String type;

    @NonNull
    @Lob
    @Column
    private byte[] imageData;

}