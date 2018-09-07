package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NomeDAO {

	public boolean isNome(String nome) {

		String sql = "SELECT nome FROM parola WHERE nome = ?;";
		boolean nomeOK = false;

		try {
			Connection c = DBConnect.getConnection();
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1, nome);
			ResultSet res = statement.executeQuery();

			while (res.next()) {
				nomeOK = true;
			}
			res.close();
			statement.close();
			c.close();
			return nomeOK;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
