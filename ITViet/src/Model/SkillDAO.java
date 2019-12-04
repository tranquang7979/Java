package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO extends GeneralDAO {

	public List<Skill> getAllData() {
		String sql = "SELECT * FROM Skill";
		ResultSet rs = execSELECT(sql);

		List<Skill> data = new ArrayList<Skill>();
		try {
			while (rs.next()) {
				Skill model = new Skill();
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

	public List<Skill> findByName(String name) {
		String sql = "SELECT * FROM Skill WHERE Name like '%" + name + "%'";
		ResultSet rs = execSELECT(sql);

		List<Skill> data = new ArrayList<Skill>();
		try {
			while (rs.next()) {
				Skill model = new Skill();
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

	public List<Skill> findById(int id) {
		String sql = "SELECT * FROM Skill WHERE Id = " + id;
		ResultSet rs = execSELECT(sql);

		List<Skill> data = new ArrayList<Skill>();
		try {
			while (rs.next()) {
				Skill model = new Skill();
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

	public String createModel(Skill model) {
		String sql = "INSERT INTO Skill VALUES ('" + model.getName() + "')";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String deleteModel(int id) {
		String sql = "DELETE Skill WHERE Id = " + id + ")";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String updateModel(Skill model) {
		String sql = "UPDATE Skill SET " + "Name = '" + model.getName() + "' WHERE Id = '" + model.getId() + "'";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

}
