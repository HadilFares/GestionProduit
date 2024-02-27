package com.dao;

import java.util.List;

public interface IGestionCategorie {
	public void ajoutCategorie(Categorie c);
	public List<Categorie> getAllCategories();
	public Categorie rechercheParId(int id);
	

}
