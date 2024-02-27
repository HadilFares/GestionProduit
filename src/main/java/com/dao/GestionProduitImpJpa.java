package com.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class GestionProduitImpJpa  implements IGestionProduit{
EntityManagerFactory emf;
EntityManager em;
EntityTransaction et;


public  GestionProduitImpJpa () {
	emf=Persistence.createEntityManagerFactory("punit1");
	em=emf.createEntityManager();
	et=em.getTransaction();
}
@Override
public void ajoutProduit(Produit p) {
	// TODO Auto-generated method stub
	et.begin();
	em.persist(p);
	et.commit();
}
@Override
public void supprimeProduit(int id) {
	
	// TODO Auto-generated method stub
	et.begin();
Produit produitToRemove = em.find(Produit.class, id);
    
    if (produitToRemove != null) {
        em.remove(produitToRemove);
    }
    
    et.commit();
}
@Override
public Produit rechercheParId(int id) {
	// TODO Auto-generated method stub
	Produit produit =em.find(Produit.class, id);
   return produit ;
	
}
@Override
public List<Produit> getAllProduits() {
	// TODO Auto-generated method stub
	Query q=em.createQuery("select p from Produit p");
	return q.getResultList();
}
@Override
public List<Produit> getProduitParNom(String nom) {
	// TODO Auto-generated method stub
	Query q=em.createQuery("select p from Produit p where p.nom like :n");
	q.setParameter("n", "%"+nom+"%");
	return q.getResultList();
	
}
@Override
public void modifProduit(Produit p) {
	// TODO Auto-generated method stub
	et.begin();
	em.merge(p);
	et.commit();
	
}
	
}
