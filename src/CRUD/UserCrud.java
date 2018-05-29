package CRUD;

import java.sql.ResultSet;

import DataAccess.Conector;
import Entities.User;

public class UserCrud {

	public void CreUser(User pUser) throws Exception {
		String query;

		query = "INSERT INTO TBL_USER(NAME,LASTNAME,SECONDLASTNAME,IDENTIFICATION,EMAIL,PASSWORD)VALUES('" + pUser.NAME
				+ "'" + ",'" + pUser.LASTNAME + "'" + ",'" + pUser.SECONDLASNAME + "'" + ",'" + pUser.IDENTIFICATION
				+ "'" + ",'" + pUser.EMAIL + "'" + ",'" + pUser.PASSWORD + "');";
		try {
			Conector.getConector().ejecutarSQL(query);

		} catch (Exception ex) {
			throw ex;
		}
	}

	public User RetUser(User pUser) throws Exception {
		User user = null;
		String query;
		ResultSet rs;
		query = "SELECT * FROM TBL_USER WHERE EMAIL = '" + pUser.EMAIL + "' AND PASSWORD = '" + pUser.PASSWORD + "'";
		try {
			rs = Conector.getConector().ejecutarSQL(query, true);
			if (rs.next()) {
				user = new User(rs.getInt("ID"), rs.getString("NAME"), rs.getString("LASTNAME"),
						rs.getString("SECONDLASTNAME"), rs.getString("IDENTIFICATION"), rs.getString("EMAIL"),
						rs.getString("PASSWORD"));
			}
			rs.close();
			return user;

		} catch (Exception ex) {
			throw ex;
		}

	}
}
