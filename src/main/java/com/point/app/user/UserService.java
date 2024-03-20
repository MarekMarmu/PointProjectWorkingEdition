package com.point.app.user;

import com.point.app.exceptions.UserAlreadyExistException;
import com.point.app.images.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Validated
public class UserService {

    private final UserRepository userRepository;
    private final ImageService imageService;
    public final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUserById(long userId) {
        return userRepository.getUserByUserId(userId);
    }

    public void saveProfileImage(MultipartFile file) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        log.info(username);
        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElse(null);
        Objects.requireNonNull(user).setImage(imageService.saveImage(file));

    }

    public void saveUser(User user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()).isPresent() ) {
            throw new UserAlreadyExistException("User with username " + user.getUsername() + " already exists.");
        }

        Address residence = user.getResidence();
        if (residence != null && residence.getId() == null) addressRepository.save(residence);


        if (user.getUsername().isBlank()) throw new IllegalArgumentException("Username cannot be blank.");

        user.setPassword((passwordEncoder.encode( user.getPassword())));
        userRepository.save(user);
    }



    }



