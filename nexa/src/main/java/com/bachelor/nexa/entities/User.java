package com.bachelor.nexa.entities;

import com.bachelor.nexa.config.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Users", schema = "dbo")
public class User implements UserDetails,Comparable<User> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "player_name")
    private String playerName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "level")
    private int level;
    @Column(name = "coins")
    private int coins;
    @Column(name = "experience")
    private int experience;
    @Column(name = "required_experience")
    private int requiredExperience;


    @Enumerated(EnumType.STRING)
    @Transient
    private final Role role = Role.USER;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public int compareTo(User o) {
        if(level == o.getLevel()){
            return 0;
        } else if(level >  o.getLevel()){
            return 1;
        } else {
            return -1;
        }
    }
}
