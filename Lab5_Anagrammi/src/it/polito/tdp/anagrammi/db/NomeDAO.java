package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class NomeDAO {

	public Set<String> isNome(Set<String> permutazioni) {

		String sql = "SELECT nome FROM parola WHERE nome = ?;";
		Set<String> parole = new HashSet<>();

		try {
			Connection c = DBConnect.getConnection();
			PreparedStatement statement = c.prepareStatement(sql);
			for (String permutazione : permutazioni) {
				statement.setString(1, permutazione);
				ResultSet res = statement.executeQuery();

				while (res.next()) {
					parole.add(permutazione);
				}
				res.close();
			}
			statement.close();
			c.close();
			return parole;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
