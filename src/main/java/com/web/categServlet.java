package com.web;

import java.io.IOException;
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
import com.dao.Produit;

/**
 * Servlet implementation class categServlet
 */
@WebServlet(urlPatterns={"/listeCategories","/addCategorie"})
public class categServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    IGestionCategorie gestionCategorie;
	@Override
	public void init() throws ServletException {
		gestionCategorie=new GestionCategorieImpJpa();	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path =request.getServletPath();
		if(path.equals("/listeCategories")) {
		List<Categorie>liste =gestionCategorie.getAllCategories();
		request.setAttribute("listeC", liste);
		request.getRequestDispatcher("afficheCategorie.jsp").forward(request, response);
	
		}else if (path.equals("/addCategorie")) {
			request.setAttribute("categories", gestionCategorie.getAllCategories());
			request.getRequestDispatcher("ajoutCategorie.jsp").forward(request, response);}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path =request.getServletPath();

		    path.equals("/addCategorie");
			String nom=request.getParameter("nom");
		
			gestionCategorie.ajoutCategorie(new Categorie(nom));
			response.sendRedirect(request.getContextPath()+"/listeProduits");			
			}
	}


