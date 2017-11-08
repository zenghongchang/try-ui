package edu.hnust.orm.user;

public class UserMaxLevelGroup {
    private Integer userId;    
    private Integer maxLevel;    
    private String groupName;
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getMaxLevel() {
        return maxLevel;
    }
    
    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }    
}
