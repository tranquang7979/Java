package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDAO extends GeneralDAO {
	
	private Job BuildModel(ResultSet rs) throws SQLException {
		Job model = new Job();
		model.setId(rs.getInt("Id"));
		model.setCompanyId(rs.getInt("CompanyId"));
		model.setTitle(rs.getString("Title"));
		model.setShortDescription(rs.getString("ShortDescription"));
		model.setIsHotJob(rs.getBoolean("IsHotJob"));
		model.setCreateDate(rs.getDate("CreateDate"));		
		return model;
	}

	public List<Job> getAllData() {
		String sql = "SELECT * FROM Job";
		ResultSet rs = execSELECT(sql);

		List<Job> data = new ArrayList<Job>();
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

	public List<Job> findByName(String name) {
		String sql = "SELECT * FROM Job WHERE Name like '%" + name + "%'";
		ResultSet rs = execSELECT(sql);

		List<Job> data = new ArrayList<Job>();
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

	public List<Job> findById(int id) {
		String sql = "SELECT * FROM Job WHERE Id = " + id;
		ResultSet rs = execSELECT(sql);

		List<Job> data = new ArrayList<Job>();
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

	public String createModel(Job model) {
		String sql = "";//"INSERT INTO Job VALUES ('" + model.getName() + "')";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String deleteModel(int id) {
		String sql = "DELETE Job WHERE Id = " + id + ")";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String updateModel(Job model) {
		String sql = "";//"UPDATE Job SET " + "Name = '" + model.getName() + "' WHERE Id = '" + model.getId() + "'";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

}
