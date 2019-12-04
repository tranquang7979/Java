package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends GeneralDAO {

	public List<City> getAllData() {
		String sql = "SELECT * FROM City";
		ResultSet rs = execSELECT(sql);

		List<City> data = new ArrayList<City>();
		try {
			while (rs.next()) {
				City model = new City();
				model.setId(rs.getInt("Id"));
				model.setName(rs.getString("Name"));
				data.add(model);
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public List<City> findByName(String name) {
		String sql = "SELECT * FROM City WHERE Name like '%" + name + "%'";
		ResultSet rs = execSELECT(sql);

		List<City> data = new ArrayList<City>();
		try {
			while (rs.next()) {
				City model = new City();
				model.setId(rs.getInt("Id"));
				model.setName(rs.getString("Name"));
				data.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public List<City> findById(int id) {
		String sql = "SELECT * FROM City WHERE Id = " + id;
		ResultSet rs = execSELECT(sql);

		List<City> data = new ArrayList<City>();
		try {
			while (rs.next()) {
				City model = new City();
				model.setId(rs.getInt("Id"));
				model.setName(rs.getString("Name"));
				data.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public String createModel(City model) {
		String sql = "INSERT INTO City VALUES ('" + model.getName() + "')";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String deleteModel(int id) {
		String sql = "DELETE City WHERE Id = " + id + ")";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String updateModel(City model) {
		String sql = "UPDATE City SET " + "Name = '" + model.getName() + "' WHERE Id = '" + model.getId() + "'";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

}
