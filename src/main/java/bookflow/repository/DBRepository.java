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
			
			BookModel b1 = new BookModel("Harry Potter y la Piedra filosofal","J.K Rowling","Salamandra",LocalDate.of(1999,3,1),264,1331);
			em.persist(b1);
			
			BookModel b2 = new BookModel("Harry Potter y la camara secreta","J.K Rowling","Salamandra",LocalDate.of(1999,10,18),294,1332);
			em.persist(b2);
			
			BookModel b3 = new BookModel("Jeronimo Stilton en el mundo de la fantasia","Elisabetta Dami","Destino",LocalDate.of(2005,11,3),264,1111);
			em.persist(b3);
			
			BookModel b4 = new BookModel("Platero y Yo","Juan Ramón Jimenez","Edebé",LocalDate.of(2007,1,26),192,1333);
			em.persist(b4);
			
			BookModel b5 = new BookModel("La Odisea","Rosa Navarro Dúran","E	debé",LocalDate.of(2009,1,30),224,1334);
			em.persist(b5);
			
			BookModel b6 = new BookModel("La Estrella","Javi Araguz","viceversaJuvenil",LocalDate.of(2011,6,11),309,1335);
			em.persist(b6);
			
			BookModel b7 = new BookModel("Don Quijote de la Mancha","Miguel de Cervantes","Edebé",LocalDate.of(2013,6,19),179,1336);
			em.persist(b7);
			
			BookModel b8 = new BookModel("Kika SuperBruja y el libro de hechizos","Ludger Jochmann","Bruño",LocalDate.of(2008,5,22),192,1337);
			em.persist(b8);
			
			BookModel b9 = new BookModel("Sherlock Holmes 1 - Estudio en escarlata","Arthur Conan Doyle","Molino",LocalDate.of(2019,10,24),192,1338);
			em.persist(b9);
			
			em.getTransaction().commit();
			
			em.getTransaction().begin();
			Book book1 = new Book(1);
			book1.setBookModel(b1);
			em.persist(book1);
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
