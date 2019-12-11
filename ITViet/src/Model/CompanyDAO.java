package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO extends GeneralDAO {

	private Company BuildModel(ResultSet rs) throws SQLException {
		Company model = new Company();
		model.setId(rs.getInt("Id"));
		model.setLogo(rs.getString("Logo"));	
		model.setBanner(rs.getString("Banner"));
		model.setName(rs.getString("Name"));
		model.setAddress(rs.getString("Address"));
		model.setCompanyType(rs.getString("CompanyType"));
		model.setCountryFlag(rs.getString("CountryFlag"));
		model.setCountryName(rs.getString("CountryName"));
		model.setWorkingDay(rs.getString("WorkingDay"));
		model.setOTOption(rs.getString("OTOption"));
		model.setDescription(rs.getString("Description"));
		model.setCompanySize(rs.getInt("CompanySize"));
		model.setRating(rs.getFloat("Rating"));
		return model;
	}

	public List<Company> getAllData() {
		String sql = "SELECT * FROM Company";
		ResultSet rs = execSELECT(sql);

		List<Company> data = new ArrayList<Company>();
		try {
			while (rs.next()) {
				data.add(BuildModel(rs));
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public List<Company> findByName(String name) {
		String sql = "SELECT * FROM Company WHERE Name like '%" + name + "%'";
		ResultSet rs = execSELECT(sql);

		List<Company> data = new ArrayList<Company>();
		try {
			while (rs.next()) {
				data.add(BuildModel(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public List<Company> findById(int id) {
		String sql = "SELECT * FROM Company WHERE Id = " + id;
		ResultSet rs = execSELECT(sql);

		List<Company> data = new ArrayList<Company>();
		try {
			while (rs.next()) {
				data.add(BuildModel(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public String createModel(Company model) {
		String sql = "INSERT INTO Company VALUES ('" + model.getName() + "')";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String deleteModel(int id) {
		String sql = "DELETE Company WHERE Id = " + id + ")";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String updateModel(Company model) {
		String sql = "UPDATE Company SET " + "Name = '" + model.getName() + "' WHERE Id = '" + model.getId() + "'";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

}
