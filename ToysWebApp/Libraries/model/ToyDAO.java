package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToyDAO extends GeneralDAO {

	public List<ToyModel> getAllToys() {
		String sql = "SELECT * FROM Toys";
		ResultSet rs = execSELECT(sql);

		List<ToyModel> toys = new ArrayList<ToyModel>();
		try {
			while (rs.next()) {
				ToyModel toy = new ToyModel();
				toy.setcToyId(rs.getString("cToyId"));
				toy.setvToyName(rs.getString("vToyName"));
				toy.setvToyDescription(rs.getString("vToyDescription"));
				toy.setcCategoryId(rs.getString("cCategoryId"));
				toy.setmToyRate(rs.getFloat("mToyRate"));
				toy.setcBrandId(rs.getString("cBrandId"));
				toy.setImPhoto(rs.getBytes("imPhoto"));
				toy.setSiToyQoh(rs.getInt("siToyQoh"));
				toy.setSiLowerAge(rs.getInt("siLowerAge"));
				toy.setSiUpperAge(rs.getInt("siUpperAge"));
				toy.setSiToyWeight(rs.getInt("siToyWeight"));
				toy.setvToyImgPath(rs.getString("vToyImgPath"));
				toys.add(toy);
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return toys;
	}

	public ResultSet getBestSeller() {

		return null;
	}

	public List<ToyModel> getTopN(int n) {
		String sql = "SELECT TOP " + n + " * FROM Toys ORDER BY [mToyRate] desc";
		ResultSet rs = execSELECT(sql);

		List<ToyModel> toys = new ArrayList<ToyModel>();
		try {
			while (rs.next()) {
				ToyModel toy = new ToyModel();
				toy.setcToyId(rs.getString("cToyId"));
				toy.setcToyId(rs.getString("vToyName"));
				toy.setvToyDescription(rs.getString("vToyDescription"));
				toy.setcCategoryId(rs.getString("cCategoryId"));
				toy.setmToyRate(rs.getFloat("mToyRate"));
				toy.setcBrandId(rs.getString("cBrandId"));
				toy.setImPhoto(rs.getBytes("imPhoto"));
				toy.setSiToyQoh(rs.getInt("siToyQoh"));
				toy.setSiLowerAge(rs.getInt("siLowerAge"));
				toy.setSiUpperAge(rs.getInt("siUpperAge"));
				toy.setSiToyWeight(rs.getInt("siToyWeight"));
				toy.setvToyImgPath(rs.getString("vToyImgPath"));
				toys.add(toy);
			}
			System.out.println(toys.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return toys;
	}

	public List<ToyModel> findByName(String name) {
		String sql = "SELECT * FROM Toys WHERE vToyName like '%" + name + "%'";
		ResultSet rs = execSELECT(sql);

		List<ToyModel> toys = new ArrayList<ToyModel>();
		try {
			while (rs.next()) {
				ToyModel toy = new ToyModel();
				toy.setcToyId(rs.getString("cToyId"));
				toy.setvToyName(rs.getString("vToyName"));
				toy.setvToyDescription(rs.getString("vToyDescription"));
				toy.setcCategoryId(rs.getString("cCategoryId"));
				toy.setmToyRate(rs.getFloat("mToyRate"));
				toy.setcBrandId(rs.getString("cBrandId"));
				toy.setImPhoto(rs.getBytes("imPhoto"));
				toy.setSiToyQoh(rs.getInt("siToyQoh"));
				toy.setSiLowerAge(rs.getInt("siLowerAge"));
				toy.setSiUpperAge(rs.getInt("siUpperAge"));
				toy.setSiToyWeight(rs.getInt("siToyWeight"));
				toy.setvToyImgPath(rs.getString("vToyImgPath"));
				toys.add(toy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return toys;
	}

	public List<ToyModel> findById(int id) {
		String sql = "SELECT * FROM Toys WHERE cToyId = " + id;
		ResultSet rs = execSELECT(sql);

		List<ToyModel> toys = new ArrayList<ToyModel>();
		try {
			while (rs.next()) {
				ToyModel toy = new ToyModel();
				toy.setcToyId(rs.getString("cToyId"));
				toy.setvToyName(rs.getString("vToyName"));
				toy.setvToyDescription(rs.getString("vToyDescription"));
				toy.setcCategoryId(rs.getString("cCategoryId"));
				toy.setmToyRate(rs.getFloat("mToyRate"));
				toy.setcBrandId(rs.getString("cBrandId"));
				toy.setImPhoto(rs.getBytes("imPhoto"));
				toy.setSiToyQoh(rs.getInt("siToyQoh"));
				toy.setSiLowerAge(rs.getInt("siLowerAge"));
				toy.setSiUpperAge(rs.getInt("siUpperAge"));
				toy.setSiToyWeight(rs.getInt("siToyWeight"));
				toy.setvToyImgPath(rs.getString("vToyImgPath"));
				toys.add(toy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return toys;
	}

	public String createToy(ToyModel model) {
		String sql = "INSERT INTO Toys VALUES ('" + model.getcToyId() + "','" + model.getvToyName() + "','"
				+ model.getvToyDescription() + "','" + model.getcCategoryId() + "'," + model.getmToyRate() + ",'"
				+ model.getcBrandId() + "','" + model.getImPhoto() + "'," + model.getSiToyQoh() + ","
				+ model.getSiLowerAge() + "," + model.getSiUpperAge() + "," + model.getSiToyWeight() + ",'"
				+ model.getvToyImgPath() + "')";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String deleteToy(int id) {
		String sql = "DELETE Toys WHERE cToyId = " + id + ")";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

	public String updateToy(ToyModel model) {
		String sql = "UPDATE Toys SET " + "vToyName = '" + model.getvToyName() + "'," + "vToyDescription = '"
				+ model.getvToyDescription() + "'," + "cCategoryId = '" + model.getcCategoryId() + "'," + "mToyRate = "
				+ model.getmToyRate() + "," + "cBrandId = '" + model.getcBrandId() + "'," + "imPhoto = '"
				+ model.getImPhoto() + "'," + "siToyQoh = " + model.getSiToyQoh() + "," + "siLowerAge = "
				+ model.getSiLowerAge() + "," + "siUpperAge = " + model.getSiUpperAge() + "," + "siToyWeight = "
				+ model.getSiToyWeight() + "," + "vToyImgPath = '" + model.getvToyImgPath() + "'" + "WHERE cToyId = '"
				+ model.getcToyId() + "'";
		String result = execINSERT_UPDATE_DELETE(sql);
		return result;
	}

}
