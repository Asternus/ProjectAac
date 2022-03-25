package com.aac.entity;

import com.aac.model.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigInteger reputation;

    private String avatar;

    private Boolean active;

    @NotEmpty(message = "Nickname should not be empty")
    @Size(min = 2, max = 20, message = "Nickname should be between 2 and 20 characters")
    private String username;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 2, max = 20, message = "Password should be between 2 and 20 characters")
    private String password;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    private String name;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 20, message = "Surname should be between 2 and 20 characters")
    private String surname;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    @Size(min = 2, max = 100, message = "Email should be between 2 and 20 characters")
    private String email;

    @NotEmpty(message = "Country should not be empty")
    @Size(min = 2, max = 20, message = "Country should be between 2 and 20 characters")
    private String country;

    @NotEmpty(message = "City should not be empty")
    @Size(min = 2, max = 20, message = "City should be between 2 and 20 characters")
    private String city;

    @NotNull
    private Date dateOfBirth;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public People() {
    }

    public People(Long id, BigInteger reputation, String avatar, Boolean active, String username, String password, String name, String surname, String email, String country, String city, Date dateOfBirth) {
        this.id = id;
        this.reputation = reputation;
        this.avatar = avatar;
        this.active = active;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.country = country;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
    }
}