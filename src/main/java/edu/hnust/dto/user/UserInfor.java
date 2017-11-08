package edu.hnust.dto.user;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import edu.hnust.orm.user.Acl;
import edu.hnust.orm.user.Menu;
import edu.hnust.orm.user.User;


public class UserInfor implements Serializable {

    private static final long serialVersionUID = 1L;    
    private User user;    
    private List<Menu> menus;    
    private List<Acl> acls;    
    private List<GroupInfo> groups;    
    private Map<String, String> menuUrlPermissions;    
    private Map<String, String> aclUrlPermissions;
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public List<GroupInfo> getGroups() {
        return groups;
    }
    
    public void setGroups(List<GroupInfo> groups) {
        this.groups = groups;
    }
    
    public List<Menu> getMenus() {
        return menus;
    }
    
    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
    
    public List<Acl> getAcls() {
        return acls;
    }
    
    public void setAcls(List<Acl> acls) {
        this.acls = acls;
    }
    
    public Map<String, String> getMenuUrlPermissions() {
        return menuUrlPermissions;
    }
    
    public void setMenuUrlPermissions(Map<String, String> menuUrlPermissions) {
        this.menuUrlPermissions = menuUrlPermissions;
    }
    
    public Map<String, String> getAclUrlPermissions() {
        return aclUrlPermissions;
    }
    
    public void setAclUrlPermissions(Map<String, String> aclUrlPermissions) {
        this.aclUrlPermissions = aclUrlPermissions;
    }    
}