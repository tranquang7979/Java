package Models;

import Constant.PermissionType;

public class Permission  extends BaseModel {
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public PermissionType getCreate() {
		return Create;
	}
	public void setCreate(PermissionType create) {
		Create = create;
	}
	public PermissionType getRead() {
		return Read;
	}
	public void setRead(PermissionType read) {
		Read = read;
	}
	public PermissionType getUpdate() {
		return Update;
	}
	public void setUpdate(PermissionType update) {
		Update = update;
	}
	public PermissionType getDelete() {
		return Delete;
	}
	public void setDelete(PermissionType delete) {
		Delete = delete;
	}
	public PermissionType getExport() {
		return Export;
	}
	public void setExport(PermissionType export) {
		Export = export;
	}
	public PermissionType getPrint() {
		return Print;
	}
	public void setPrint(PermissionType print) {
		Print = print;
	}
	public String RoleId = "";
	public String Title = "";
	public PermissionType Create = PermissionType.None;
	public PermissionType Read = PermissionType.None;
	public PermissionType Update = PermissionType.None;
	public PermissionType Delete = PermissionType.None;
	public PermissionType Export = PermissionType.None;
	public PermissionType Print = PermissionType.None;
}
