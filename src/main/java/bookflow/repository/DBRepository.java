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
			
			BookModel b1 = new BookModel("Harry Potter y la Piedra filosofal","J.K Rowling","Salamandra",
					LocalDate.of(1999,3,1),264,1331,
					"https://images.cdn3.buscalibre.com/fit-in/360x360/ce/e6/cee6ef96dad70d3f599b953f0e50afc7.jpg");
			em.persist(b1);
			
			BookModel b2 = new BookModel("Harry Potter y la camara secreta","J.K Rowling","Salamandra",
					LocalDate.of(1999,10,18),294,1332,"https://m.media-amazon.com/images/I/91voauWrUKL.jpg");
			em.persist(b2);
			
			BookModel b3 = new BookModel("Jeronimo Stilton en el mundo de la fantasia","Elisabetta Dami","Destino",
					LocalDate.of(2005,11,3),264,1111,"https://m.media-amazon.com/images/I/71esEUxOgCL.jpg");
			em.persist(b3);
			
			BookModel b4 = new BookModel("Platero y Yo","Juan Ramón Jimenez","Edebé"
					,LocalDate.of(2007,1,26),192,1333,"https://www.edebe.com/publicaciones-generales/img_server.aspx?img=8627.jpg&tipo=F");
			em.persist(b4);
			
			BookModel b5 = new BookModel("La Odisea","Rosa Navarro Dúran","Edebé",
					LocalDate.of(2009,1,30),224,1334,"https://edebe.com/publicaciones-generales/img_server.aspx?img=9321.jpg&tipo=F");
			em.persist(b5);
			
			BookModel b6 = new BookModel("La Estrella","Javi Araguz","viceversaJuvenil"
					,LocalDate.of(2011,6,11),309,1335,"https://static.fnac-static.com/multimedia/ES/images_produits/ES/ZoomPE/4/4/7/9788492819744/tsp20110525191110/La-estrella.jpg");
			em.persist(b6);
			
			BookModel b7 = new BookModel("Don Quijote de la Mancha","Miguel de Cervantes","Edebé"
					,LocalDate.of(2013,6,19),179,1336,"https://m.media-amazon.com/images/I/91eA8LRBeKL.jpg");
			em.persist(b7);
			
			BookModel b8 = new BookModel("Kika SuperBruja y el libro de hechizos","Ludger Jochmann","Bruño"
					,LocalDate.of(2008,5,22),192,1337,"https://m.media-amazon.com/images/I/71chr36faKL.jpg");
			em.persist(b8);
			
			BookModel b9 = new BookModel("Sherlock Holmes 1 - Estudio en escarlata","Arthur Conan Doyle","Molino"
					,LocalDate.of(2019,10,24),192,1338,"https://www.penguinlibros.com/es/2234179-large_default/sherlock-holmes-1-estudio-en-escarlata.jpg");
			em.persist(b9);
			
			em.getTransaction().commit();
			
			em.getTransaction().begin();
			Book book1 = new Book(93724);
			book1.setBookModel(b1);
			em.persist(book1);
			Book book2 = new Book(58106);
			book2.setBookModel(b1);
			em.persist(book2);
			Book book3 = new Book(24785);
			book3.setBookModel(b2);
			em.persist(book3);
			Book book4 = new Book(81396);
			book4.setBookModel(b2);
			em.persist(book4);
			Book book5 = new Book(49217);
			book5.setBookModel(b3);
			em.persist(book5);
			Book book6 = new Book(67531);
			book6.setBookModel(b3);
			em.persist(book6);
			Book book7 = new Book(15640);
			book7.setBookModel(b4);
			em.persist(book7);
			Book book8 = new Book(73948);
			book8.setBookModel(b4);
			em.persist(book8);
			Book book9 = new Book(12509);
			book9.setBookModel(b5);
			em.persist(book9);
			Book book10 = new Book(87432);
			book10.setBookModel(b5);
			em.persist(book10);
			Book book11 = new Book(30657);
			book11.setBookModel(b6);
			em.persist(book11);
			Book book12 = new Book(59210);
			book12.setBookModel(b6);
			em.persist(book12);
			Book book13 = new Book(40825);
			book13.setBookModel(b7);
			em.persist(book13);
			Book book14 = new Book(95614);
			book14.setBookModel(b7);
			em.persist(book14);
			Book book15 = new Book(23178);
			book15.setBookModel(b8);
			em.persist(book15);
			Book book16 = new Book(78506);
			book16.setBookModel(b8);
			em.persist(book16);
			Book book17 = new Book(69412);
			book17.setBookModel(b9);
			em.persist(book17);
			Book book18 = new Book(50736);
			book18.setBookModel(b9);
			em.persist(book18);
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
