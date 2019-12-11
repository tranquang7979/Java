package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanySkillDAO extends GeneralDAO {

	private CompanySkill BuildModel(ResultSet rs) throws SQLException {
		CompanySkill model = new CompanySkill();
		model.setId(rs.getInt("Id"));
		model.setCompanyId(rs.getInt("CompanyId"));	
		model.setSkillId(rs.getInt("SkillId"));
		return model;
	}

	public List<CompanySkill> getAllData() {
		String sql = "SELECT * FROM CompanySkill";
		ResultSet rs = execSELECT(sql);

		List<CompanySkill> data = new ArrayList<CompanySkill>();
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

	public List<CompanySkill> findByName(String name) {
		String sql = "SELECT * FROM CompanySkill WHERE Name like '%" + name + "%'";
		ResultSet rs = execSELECT(sql);

		List<CompanySkill> data = new ArrayList<CompanySkill>();
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

	public List<CompanySkill> findById(int id) {
		String sql = "SELECT * FROM CompanySkill WHERE Id = " + id;
		ResultSet rs = execSELECT(sql);

		List<CompanySkill> data = new ArrayList<CompanySkill>();
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

	public String createModel(CompanySkill model) {
		String sql = "";//"INSERT INTO CompanySkill VALUES ('" + model.getName() + "')";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String deleteModel(int id) {
		String sql = "";//"DELETE CompanySkill WHERE Id = " + id + ")";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String updateModel(CompanySkill model) {
		String sql = "";//"UPDATE CompanySkill SET " + "Name = '" + model.getName() + "' WHERE Id = '" + model.getId() + "'";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

}
