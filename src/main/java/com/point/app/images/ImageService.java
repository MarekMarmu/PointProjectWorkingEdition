package com.point.app.images;

import com.point.app.user.User;
import com.point.app.user.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

import static com.point.app.images.ImageUtils.compressImage;

@Transactional
@AllArgsConstructor
@Service
public class ImageService {
    
    private ImageRepository imageRepository;

    private final UserRepository userRepository;

    @Deprecated(since="2024")
    private void saveToUserProfileImage(Image image) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> optionalUser = userRepository.findByUsername(authentication.getName());
        User user = optionalUser.orElseThrow(()-> new UsernameNotFoundException("User does not exists"));
        user.setImage(image);
    }

    public Image saveImage(MultipartFile file) throws IOException {
        Image image = new Image(
                Objects.requireNonNull(file.getOriginalFilename())
                , file.getOriginalFilename()
                , compressImage(file.getBytes())
        );
        imageRepository.save(image);
        return image;
    }

    public byte[] downloadImage(Long imageId) {
        Optional<Image> dbImageData = imageRepository.findById(imageId);
        return dbImageData.map(image -> ImageUtils.decompressImage(image.getImageData())).orElseThrow(IllegalStateException::new);
    }

    public static String getImageAsBase64(byte[] imageData) {
        return Base64.getEncoder().encodeToString(imageData);
    }

}