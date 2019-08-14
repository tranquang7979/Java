package Models;

import Constant.PermissionType;

public class Permission {
	public int PermissionId = 0;
	public int getPermissionId() {
		return PermissionId;
	}
	public void setPermissionId(int permissionId) {
		PermissionId = permissionId;
	}
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
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
	public int RoleId = 0;
	public String Title = "";
	public PermissionType Create = PermissionType.None;
	public PermissionType Read = PermissionType.None;
	public PermissionType Update = PermissionType.None;
	public PermissionType Delete = PermissionType.None;
	public PermissionType Export = PermissionType.None;
	public PermissionType Print = PermissionType.None;
}
