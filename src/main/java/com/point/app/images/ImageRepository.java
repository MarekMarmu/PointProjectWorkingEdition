package com.point.app.images;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

@Transactional
public interface ImageRepository extends JpaRepository<Image, Long> {

  Optional<Image> findImageByImageName(String name);
}
