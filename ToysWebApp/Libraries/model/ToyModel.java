package model;

public class ToyModel {

	public String getcToyId() {
		return cToyId;
	}

	public void setcToyId(String cToyId) {
		this.cToyId = cToyId;
	}

	public String getvToyName() {
		return vToyName;
	}

	public void setvToyName(String vToyName) {
		this.vToyName = vToyName;
	}

	public String getvToyDescription() {
		return vToyDescription;
	}

	public void setvToyDescription(String vToyDescription) {
		this.vToyDescription = vToyDescription;
	}

	public String getcCategoryId() {
		return cCategoryId;
	}

	public void setcCategoryId(String cCategoryId) {
		this.cCategoryId = cCategoryId;
	}

	public String getcBrandId() {
		return cBrandId;
	}

	public void setcBrandId(String cBrandId) {
		this.cBrandId = cBrandId;
	}

	public byte[] getImPhoto() {
		return imPhoto;
	}

	public void setImPhoto(byte[] imPhoto) {
		this.imPhoto = imPhoto;
	}

	public String getvToyImgPath() {
		return vToyImgPath;
	}

	public void setvToyImgPath(String vToyImgPath) {
		this.vToyImgPath = vToyImgPath;
	}

	public float getmToyRate() {
		return mToyRate;
	}

	public void setmToyRate(float mToyRate) {
		this.mToyRate = mToyRate;
	}

	public int getSiToyQoh() {
		return siToyQoh;
	}

	public void setSiToyQoh(int siToyQoh) {
		this.siToyQoh = siToyQoh;
	}

	public int getSiLowerAge() {
		return siLowerAge;
	}

	public void setSiLowerAge(int siLowerAge) {
		this.siLowerAge = siLowerAge;
	}

	public int getSiUpperAge() {
		return siUpperAge;
	}

	public void setSiUpperAge(int siUpperAge) {
		this.siUpperAge = siUpperAge;
	}

	public int getSiToyWeight() {
		return siToyWeight;
	}

	public void setSiToyWeight(int siToyWeight) {
		this.siToyWeight = siToyWeight;
	}

	private String cToyId, vToyName, vToyDescription, cCategoryId, cBrandId, vToyImgPath;
	private float mToyRate = 0;
	private byte[] imPhoto = null;
	private int siToyQoh, siLowerAge, siUpperAge, siToyWeight;

	public ToyModel() {
	}
}
