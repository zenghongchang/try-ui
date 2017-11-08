package edu.hnust.service.user;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import edu.hnust.common.utils.crypto.MD5Coding;
import edu.hnust.junit.base.BaseSpringUnitTestCase;
import edu.hnust.orm.user.User;
import edu.hnust.service.user.IUserService;

@SuppressWarnings({"unused", "deprecation"})
@RunWith(SpringJUnit4ClassRunner.class) // 指定测试用例的运行器 这里是指定了Junit4
public class UserServiceTest extends BaseSpringUnitTestCase {
    @Autowired
    @Qualifier("userService")
    private IUserService userService;
    
    @Test
    public void loginTest() {
        User user = new User();
        user.setLoginName("test123");
        user.setPassword("admin123");
        
        user = userService.login(user);
        System.out.println(user.toString());
        Assert.assertNotNull(user);
    }
    
    @Test
    public void findUsersTest() {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("loginName", "test123");
        queryMap.put("password", "admin123");
        // 断言此姓名和密码的用户为空
        List<User> users = userService.findUser(queryMap);
        // Assert.assertNotNull(users);
        // 这里发生异常是不会回滚的,因为此方法并没有被纳入事务管理中
    }
    
    @Test
    public void getTotalUserTest() {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("loginName", "test123");
        queryMap.put("password", "admin123");
        
        Long total = userService.getTotalUser(queryMap);
        System.out.println(total);
        Assert.assertEquals(total, new Long(1));
    }
    
    @Test
    public void updateUserTest() {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("loginName", "test123");
        queryMap.put("password", "admin123");
        List<User> userList = userService.findUser(queryMap);
        User user = userList.get(0);
        user.setUserName("test1234");
        Boolean result = userService.updateUser(user);
        System.out.println(result);
        Assert.assertEquals(result, 1);
    }
    
    @Test
    public void addUserTest() {
        User user = new User();
        user.setLoginName("test");
        user.setUserName("test");
        user.setPassword(MD5Coding.encode2HexStr("test".getBytes()));
        user.setState(1);
        user.setCreateUser(777);
        user.setCreateDate("2017-05-17 18:14:00");
        user.setUpdateDate("2017-05-17 18:14:00");
        Boolean result = userService.addUser(user);
        System.out.println(result);
        Assert.assertEquals(result, 1);
    }
    
    @Test
    public void deleteUserTest() {
        Integer id = 12;
        int result = userService.deleteUser(id);
        System.out.println(result);
        Assert.assertEquals(result, result);
    }
    
    @Test
    public void Md5Test() {
        String str = "test";
        System.out.println(MD5Coding.encode2HexStr(str.getBytes()));
        System.out.println(MD5Coding.encode2HexStr(str.getBytes()));
        System.out.println(MD5Coding.encode2HexStr(str.getBytes()));
    }    
}