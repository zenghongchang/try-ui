package edu.hnust.dao.impl.user;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.hnust.dao.it.user.IUserDao;
import edu.hnust.orm.user.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUsers(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotalUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
