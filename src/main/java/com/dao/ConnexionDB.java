package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {

	
	private static Connection connection;
	
	
	private ConnexionDB()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/gestionproduit","root","");
			System.out.println("connexion établie ....");
			
		}catch (ClassNotFoundException e )
		{
			System.out.println("probleme chargement pilote....");
			e.printStackTrace();

		}
		catch (SQLException e )
		{
			System.out.println("probleme établissement connexion....");
			e.printStackTrace();

		}
	}
	public static Connection getConnection()  {
		if(connection==null)
			new ConnexionDB();
		return connection;
	}
}
