package edu.hnust.orm.user;

public class GroupAclPermissions {
	public Integer id;
	public Integer aclId;// 按钮ID
	public Integer groupId;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getAclId() {
        return aclId;
    }
    
    public void setAclId(Integer aclId) {
        this.aclId = aclId;
    }
    
    public Integer getGroupId() {
        return groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
