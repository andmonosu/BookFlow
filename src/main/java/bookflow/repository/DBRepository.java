package bookflow.repository;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.EntityManager;

import bookflow.models.*;

public class DBRepository {
	
	public static void populateDB(EntityManager em) {
		
		try {
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Object").executeUpdate();
			em.getTransaction().commit();
			em.getTransaction().begin();
			
			Book b1 = new Book("Harry Potter y la Piedra filosofal","J.K Rowling","Salamandra",LocalDate.of(1999,3,1),264,10,1331);
			em.persist(b1);
			
			Book b2 = new Book("Harry Potter y la camara secreta","J.K Rowling","Salamandra",LocalDate.of(1999,10,18),294,8,1332);
			em.persist(b2);
			
			Book b3 = new Book("Jeronimo Stilton en el mundo de la fantasia","Elisabetta Dami","Destino",LocalDate.of(2005,11,3),264,12,1111);
			em.persist(b3);
			
			Book b4 = new Book("Platero y Yo","Juan Ramón Jimenez","Edebé",LocalDate.of(2007,1,26),192,5,1333);
			em.persist(b4);
			
			Book b5 = new Book("La Odisea","Rosa Navarro Dúran","E	debé",LocalDate.of(2009,1,30),224,14,1334);
			em.persist(b5);
			
			Book b6 = new Book("La Estrella","Javi Araguz","viceversaJuvenil",LocalDate.of(2011,6,11),309,18,1335);
			em.persist(b6);
			
			Book b7 = new Book("Don Quijote de la Mancha","Miguel de Cervantes","Edebé",LocalDate.of(2013,6,19),179,3,1336);
			em.persist(b7);
			
			Book b8 = new Book("Kika SuperBruja y el libro de hechizos","Ludger Jochmann","Bruño",LocalDate.of(2008,5,22),192,2,1337);
			em.persist(b8);
			
			Book b9 = new Book("Sherlock Holmes 1 - Estudio en escarlata","Arthur Conan Doyle","Molino",LocalDate.of(2019,10,24),192,7,1338);
			em.persist(b9);
			
			em.getTransaction().commit();
			
			
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		em.close();
	}

	}
}
