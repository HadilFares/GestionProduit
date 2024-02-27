package com.web;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.Categorie;
import com.dao.GestionCategorieImpJpa;
import com.dao.GestionProduitImpJpa;
import com.dao.IGestionCategorie;
import com.dao.IGestionProduit;
import com.dao.Produit;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(urlPatterns={"/listeProduits","/addProduit","/suppProduit","/modifProduit","/findProduit","/listeCategorie"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
       
    }
    
    IGestionProduit gestion;
    IGestionCategorie gestionCategorie;
    
   

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		//gestion = new GestionProduitImp();
		gestion = new GestionProduitImpJpa();
		gestionCategorie=new GestionCategorieImpJpa();	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path =request.getServletPath();
		if(path.equals("/listeProduits")) {
		List<Produit>liste =gestion.getAllProduits();
		request.setAttribute("listeP", liste);
		request.getRequestDispatcher("affiche.jsp").forward(request, response);
	
	}else if (path.equals("/addProduit")) {
		request.setAttribute("categories", gestionCategorie.getAllCategories());
		request.getRequestDispatcher("ajout.jsp").forward(request, response);

	}else if (path.equals("/suppProduit")) {
		int id=Integer.parseInt(request.getParameter("id"));
		gestion.supprimeProduit(id);
		response.sendRedirect(request.getContextPath()+"/listeProduits");
	}
	else if (path.equals("/modifProduit")) {
		int id=Integer.parseInt(request.getParameter("id"));
		Produit p =gestion.rechercheParId(id);
		request.setAttribute("produit", p);
		request.setAttribute("categories", gestionCategorie.getAllCategories());
		request.getRequestDispatcher("modif.jsp").forward(request, response);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String path =request.getServletPath();

		if (path.equals("/addProduit")) {
			String nom=request.getParameter("nom");
			double prix=Double.parseDouble(request.getParameter("prix"));
			int quantite=Integer.parseInt(request.getParameter("quantite"));
			int idcat=Integer.parseInt(request.getParameter("idcat"));
			Categorie c=gestionCategorie.rechercheParId(idcat);
			gestion.ajoutProduit(new Produit(nom,prix,quantite,c));
			response.sendRedirect(request.getContextPath()+"/listeProduits");			
			}
		else if (path.equals("/modifProduit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String nom=request.getParameter("nom");
			double prix=Double.parseDouble(request.getParameter("prix"));
			int quantite=Integer.parseInt(request.getParameter("quantite"));
			int idcat=Integer.parseInt(request.getParameter("idcat"));
			Categorie c=gestionCategorie.rechercheParId(idcat);
			gestion.modifProduit(new Produit(id,nom,prix,quantite,c));
			response.sendRedirect(request.getContextPath()+"/listeProduits");			
			}
	
		else if (path.equals("/findProduit")) {
			String nom=request.getParameter("motcle");
			List<Produit>listefilter=gestion.getProduitParNom(nom);
			request.setAttribute("listeP", listefilter);
			request.getRequestDispatcher("affiche.jsp").forward(request, response);
			}
	
}}