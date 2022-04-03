package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String nom;

    @NotBlank
    @Size(max = 20)
    private String category;

    @OneToMany(mappedBy ="service", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Guichet> guichets;

    @OneToMany(mappedBy ="service", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> clients;
}
