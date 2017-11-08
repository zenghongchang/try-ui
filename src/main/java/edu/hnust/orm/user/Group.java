package edu.hnust.orm.user;

import java.io.Serializable;
import java.util.List;

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String code;//组代码
	//组名
	private String groupName;
	//员工级别
	private Integer staffLevel;
	//国际化key
	private String i18nKey;
	//创建时间
	private String createDate;
	//更新时间
	private String updateDate;
	//创建人
	private Integer createUser;
	//系统备注
	private String sysRemark;
	
	public List<Integer> menuIds;
    public List<Integer> aclIds;
    public List<Integer> userIds;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public Integer getStaffLevel() {
        return staffLevel;
    }
    
    public void setStaffLevel(Integer staffLevel) {
        this.staffLevel = staffLevel;
    }
    
    public String getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    
    public String getUpdateDate() {
        return updateDate;
    }
    
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    
    public Integer getCreateUser() {
        return createUser;
    }
    
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }
    
    public String getSysRemark() {
        return sysRemark;
    }
    
    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }
    
    public String getI18nKey() {
        return i18nKey;
    }
    
    public void setI18nKey(String i18nKey) {
        this.i18nKey = i18nKey;
    }
    
    public List<Integer> getMenuIds() {
        return menuIds;
    }
    
    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }
    
    public List<Integer> getAclIds() {
        return aclIds;
    }
    
    public void setAclIds(List<Integer> aclIds) {
        this.aclIds = aclIds;
    }
    
    public List<Integer> getUserIds() {
        return userIds;
    }
    
    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }    
}
