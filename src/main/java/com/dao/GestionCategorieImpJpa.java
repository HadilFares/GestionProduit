package com.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class GestionCategorieImpJpa implements IGestionCategorie {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction et;

	

public  GestionCategorieImpJpa () {
	emf=Persistence.createEntityManagerFactory("punit1");
	em=emf.createEntityManager();
	et=em.getTransaction();
}



@Override
public void ajoutCategorie(Categorie c) {
	// TODO Auto-generated method stub
	et.begin();
	em.persist(c);
	et.commit();
}



@Override
public List<Categorie> getAllCategories() {
	// TODO Auto-generated method stub
	Query q=em.createQuery("select c from Categorie c");
	return q.getResultList();
}



@Override
public Categorie rechercheParId(int id) {
	// TODO Auto-generated method stub
	Categorie categorie =em.find(Categorie.class, id);
	   return categorie ;
}
	

}
