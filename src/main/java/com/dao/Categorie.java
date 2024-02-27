package com.dao;
import java.util.*;
import jakarta.persistence.*;

@Entity
public class Categorie {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY )
	private int id;
	private String nom;
	@OneToMany(mappedBy="categorie")
	List<Produit>  produits;
	public Categorie(int id, String nom, List<Produit> produits) {
		super();
		this.id = id;
		this.nom = nom;
		this.produits = produits;
	}
	
	
	
	public Categorie() {
		super();
	}
	



	public Categorie(String nom) {
		super();
		this.nom = nom;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	
	
}
