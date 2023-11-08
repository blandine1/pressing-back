package com.pressing.pressing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "utilisateur")
//implements UserDetails
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String prenom;

    private String email;

    @Column(name = "date_naissance")
    private Date dateDeNaissance;

    private String password;

    @Column(name = "photo")
    private String photo;

    //@Enumerated(EnumType.STRING)
    private Role role;

    //@Column(name = "statut")
    private boolean statut;

    @CreationTimestamp
    @Column(name = "creationDate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp creationDate;

    @UpdateTimestamp
    private Timestamp lastUpdatedDate;

   /* @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @Override
    public String getUsername() {
        return email;
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
    }*/
}
