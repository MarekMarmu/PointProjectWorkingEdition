/*
package com.point.app.thymeleaf;

import com.point.app.user.User;
import com.point.app.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@AllArgsConstructor
public class ThymeLeafConfig {

    private final UserRepository userRepository;

    @Bean
    public CurrentUserUtil currentUserUtil() {
        return new CurrentUserUtil(userRepository);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public static class CurrentUserUtil {

        private UserRepository userRepository;

        public User getAuthenticatedUser() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return userRepository.findByUsername(authentication.getName())
                    .orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
        }
    }
}
*/
