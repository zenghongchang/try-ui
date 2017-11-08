package edu.hnust.orm.user;

public class UserSubordinate {
    private Integer id;    
    private Integer UserId;    
    private Integer subordinateId;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getUserId() {
        return UserId;
    }
    
    public void setUserId(Integer userId) {
        UserId = userId;
    }
    
    public Integer getSubordinateId() {
        return subordinateId;
    }
    
    public void setSubordinateId(Integer subordinateId) {
        this.subordinateId = subordinateId;
    }    
}
