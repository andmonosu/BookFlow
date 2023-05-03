package bookflow.repository;

import javax.persistence.EntityManager;

import bookflow.models.User;

public class UserRepository {

	public static User getUserByUsername(String username, EntityManager em) {
		User user = em.createQuery(
                "SELECT u FROM User u WHERE u.username = :username", User.class)
				.setParameter("username", username).getSingleResult();
		return user;
	}
	
	public static User getUserById(String id, EntityManager em) {
		User user = em.createQuery(
                "SELECT u FROM User u WHERE u.id = :id", User.class)
				.setParameter("id", Integer.parseInt(id)).getSingleResult();
		return user;
	}
	
}
