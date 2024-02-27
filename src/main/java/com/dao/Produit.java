package com.dao;

import jakarta.persistence.*;


@Entity
public class Produit {

	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private double prix;
	private int quantite;
	@ManyToOne
	Categorie categorie;
	
	
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
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Produit(String nom, double prix, int quantite,Categorie categorie) {
	
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie=categorie;
	}
	public Produit(int id, String nom, double prix, int quantite,Categorie categorie) {
	
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie=categorie;
	}
	public Produit () {
		
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", quantite=" + quantite + ", categorie="
				+ categorie + "]";
	}
	
	
	
	
	
}
