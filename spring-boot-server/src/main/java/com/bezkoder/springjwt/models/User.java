package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@NotBlank
	@Size(max = 20)
	private String nom;

	@NotBlank
	@Size(max = 20)
	private String prenom;


	private Date dateNaissance;

	@NotBlank
	@Size(max = 20)
	private String numTel;

	@NotBlank
	@Size(max = 20)
	private String address;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();


	//Client
	@ManyToOne
	@JoinColumn(name = "Id_Service")
	private Services service;

	@OneToMany(mappedBy ="client", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Ticket> tickets;

	//Agent
	@OneToOne
	private Guichet guichet;

	//Admin
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Article> articles;



	public User(String username, String email, String nom, String prenom, Date dateNaissance,String numTel, String address, String password) {
		this.username = username;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.numTel = numTel;
		this.address = address;
		this.password = password;
	}

}
