package devoir_JDBC;

import java.sql.*;
import java.util.Random;

public class JDBC {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/devoirjdbc";
		String username = "root";
		String password = "2468";
		String select_query = "SELECT ID_Etudiant, Departement, Prenom, Nom, Rang FROM Etudiants";
		Random rn = new Random();
		int id = rn.nextInt(9000) + 10204;
		String insert_query = "INSERT INTO Etudiants VALUES (" + id + ", 'EM', 'Khaled', 'Metlej', 10)";
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Is it available?
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement s = con.createStatement();
			System.out.println("Select query: ");
			ResultSet rs = s.executeQuery(select_query);
			
			while (rs.next()) {
				String infoEtudiant = "";
				for (int i = 1; i <= 5; ++i) {
					infoEtudiant += rs.getString(i) + " - ";
				}
				System.out.println(infoEtudiant);
			}
			rs.close();
			
			System.out.println("Insert query: ");
			s.executeUpdate(insert_query);
			System.out.println("Inserted new record in database. ");
			
			s.close();
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
