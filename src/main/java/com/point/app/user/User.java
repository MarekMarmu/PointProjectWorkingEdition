package com.point.app.user;


import com.point.app.images.Image;
import jakarta.persistence.*;
import lombok.*;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.validation.constraints.Email;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
@Table(name = "\"User\"")
public class User implements UserDetails{

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long userId;

    @NonNull
    @Column(nullable = false, unique = true)
    private String username;

    @NonNull
    @Column(nullable = false)
    private String password;

    @NonNull
    @Email
    @Column(nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address residence;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image = new Image();

    @Enumerated(EnumType.STRING)
    @Column
    private ROLE ROLE;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return null;

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
