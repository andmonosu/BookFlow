package bookflow.repository;

import javax.persistence.EntityManager;

import bookflow.models.User;

public class UserRepository {

	public User getUserByUsername(String username, EntityManager em) {
		User user = new User();
		return user;
	}
	
}
