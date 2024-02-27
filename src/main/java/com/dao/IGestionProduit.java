package com.dao;
import java.util.List;

public interface IGestionProduit {
	
	
	
	
	
	public void ajoutProduit(Produit p);
	public void supprimeProduit(int id );
    public Produit rechercheParId(int id);
    public List<Produit>getAllProduits();
    public List<Produit>getProduitParNom(String nom);
   public void modifProduit(Produit p);
}
