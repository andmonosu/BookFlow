package bookflow.repository;

import java.time.LocalDate;
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
					"https://images.cdn3.buscalibre.com/fit-in/360x360/ce/e6/cee6ef96dad70d3f599b953f0e50afc7.jpg",
					"Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y el insoportable primo Dudley. Harry se siente muy triste y solo, hasta que un buen día recibe una carta que cambiará su vida para siempre. En ella le comunican que ha sido aceptado como alumno en el Colegio Hogwarts de Magia. A partir de ese momento, la suerte de Harry da un vuelco espectacular. En esa escuela tan especial aprenderá encantamientos, trucos fabulosos y tácticas de defensa contra las malas artes. Se convertirá en el campeón escolar de Quidditch, especie de fútbol aéreo que se juega montado sobre escobas, y hará un puñado de buenos amigos... aunque también algunos temibles enemigos. Pero, sobre todo, conocerá los secretos que le permitirán cumplir su destino. Pues, aunque no lo parezca a primera vista, Harry no es un chico común y corriente: ¡es un verdadero mago!");
			em.persist(b1);
			
			BookModel b2 = new BookModel("Harry Potter y la camara secreta","J.K Rowling","Salamandra",
					LocalDate.of(1999,10,18),294,1332,"https://m.media-amazon.com/images/I/91voauWrUKL.jpg"
					,"Tras derrotar una vez más a lord Voldemort, su siniestro enemigo en Harry Potter y la piedra filosofal, Harry espera impaciente en casa de sus insoportables tíos el inicio del segundo curso del Colegio Hogwarts de Magia y Hechicería. Sin embargo, la espera dura poco, pues un elfo aparece en su habitación y le advierte que una amenaza mortal se cierne sobre la escuela. Así pues, Harry no se lo piensa dos veces y, acompañado de Ron, su mejor amigo, se dirige a Hogwarts en un coche volador. Pero ¿puede un aprendiz de mago defender la escuela de los malvados que pretenden destruirla? Sin saber que alguien ha abierto la Cámara de los Secretos, dejando escapar una serie de monstruos peligrosos, Harry y sus amigos Ron y Hermione tendrán que enfrentarse con arañas gigantes, serpientes encantadas, fantasmas enfurecidos y, sobre todo, con la mismísima reencarnación de su más temible adversario.");
			em.persist(b2);
			
			BookModel b3 = new BookModel("Jeronimo Stilton en el mundo de la fantasia","Elisabetta Dami","Destino",
					LocalDate.of(2005,11,3),264,1111,"https://m.media-amazon.com/images/I/71esEUxOgCL.jpg",
					"Geronimo Stilton viaja al Reino de la fantasía y descubre cómo huele el reino de las brujas, de las sirenas, de los dragones, de las hadas, de los duendes... ¡Éste es el primer libro del mundo con 8 olores sorprendentes! Frótalos y huele, ¿perfume o tufo?");
			em.persist(b3);
			
			BookModel b4 = new BookModel("Platero y Yo","Juan Ramón Jimenez","Edebé"
					,LocalDate.of(2007,1,26),192,1333,"https://www.edebe.com/publicaciones-generales/img_server.aspx?img=8627.jpg&tipo=F"
					,"Narración lírica de Juan Ramón Jiménez que recrea poéticamente la vida y muerte del burro Platero y formada por breves capítulos que pueden considerarse poemas en prosa. Este fragmento es el comienzo del libro: “Platero es pequeño, peludo, suave, tan blando por fuera, que se diría todo de algodón, que no lleva huesos. Sólo los espejos de azabache de sus ojos son duros cual dos escarabajos de cristal negro.” El nombre de Juan Ramón Jiménez (1881-1958) está indisolublemente ligado al título de Platero y yo, que no sólo es su obra más conocida, sino una de las más universales de las letras hispánicas. Y, a pesar de ello, cabe afirmar que Platero y yo ha sido víctima de su éxito popular. El propio Juan Ramón protestaba en vida contra tanta lectura superficial aferrada al sentimentalismo fácil de la anécdota. Richard Cardwell, uno de los primeros especialistas en el gran andaluz universal, autor de una obra decisiva sobre la formación modernista de Juan Ramón Jiménez, explica en la Introducción cuál ha sido la intención básica de aquél y el objetivo que perseguía: la propagación de los grandes ideales de la pedagogía cultural del krausismo. La prosecución de esta guía, sin disminuir el encanto, amplía el interés de la lectura. Porque a la vez que se señalan todos los recursos del arte literario, se nos descubren las verdaderas raíces de la universalidad de un libro tan conmovedor y, en apariencia, tan sencillo.");
			em.persist(b4);
			
			BookModel b5 = new BookModel("La Odisea","Rosa Navarro Dúran","Edebé",
					LocalDate.of(2009,1,30),224,1334,"https://edebe.com/publicaciones-generales/img_server.aspx?img=9321.jpg&tipo=F",
					"Tras una década de guerra, Ulises regresa desde Troya hasta su hogar, Ítaca. La 'Odisea' narra la larga travesía y todas las aventuras vividas por Ulises. Se cruzará con el cíclope Polifemo, con la maga Circe o con la ninfa Calipso. Historias que, casi 3.000 años después, siguen formando parte de nuestra cultura.");
			em.persist(b5);
			
			BookModel b6 = new BookModel("La Estrella","Javi Araguz","viceversaJuvenil"
					,LocalDate.of(2011,6,11),309,1335,"https://static.fnac-static.com/multimedia/ES/images_produits/ES/ZoomPE/4/4/7/9788492819744/tsp20110525191110/La-estrella.jpg",
					"Los ojos del muchacho brillaron con intensidad, anunciando la inminente ruptura de La Quietud. Lan sabía que tocar a un Caminante de La Estrella estaba prohibido, pero ahora ya no había vuelta atrás y sus destinos estaban irremediablemente unidos. Hace siglos, una catástrofe convirtió el Linde en un lugar hostil; desde entonces, los supervivientes han aprendido a vivir aislados dentro de los Límites Seguros, pero a menudo el planeta cambia de forma y la gente se pierde para siempre. Tras un violento episodio, Lan, una valiente muchacha del clan de Salvia, despierta en medio del desierto y es rescatada por su peor enemigo. Novela juvenil.");
			em.persist(b6);
			
			BookModel b7 = new BookModel("Don Quijote de la Mancha","Miguel de Cervantes","Edebé"
					,LocalDate.of(2013,6,19),179,1336,"https://m.media-amazon.com/images/I/91eA8LRBeKL.jpg"
					,"En plena transición del Renacimiento al Barroco, Cervantes escribe  El Quijote  (1605-1615), la novela más importante de la literatura universal, una síntesis poética del ser humano. Esta edición, íntegra pero con la ortografía actualizada al castellano actual, ha sido cuidadosamente preparada por Vicente Muñoz Puelles, autor de las notas léxicas (que acompañan al texto en los márgenes) y críticas (que aclaran referencias históricas, geográficas, mitológicas o cuestiones estilísticas, etc.), y del apéndice final sobre la época, el autor y la obra. Acompañan al libro, además, dos prólogos de Emilio Pascual y José Corredor-Matheos, y las magníficas ilustraciones de Jordi Vila delclòs.");
			em.persist(b7);
			
			BookModel b8 = new BookModel("Kika SuperBruja y el libro de hechizos","Ludger Jochmann","Bruño"
					,LocalDate.of(2008,5,22),192,1337,"https://m.media-amazon.com/images/I/71chr36faKL.jpg"
					,"Desde que un buen día se encontró un libro de magia junto a su cama, a Kika le encanta hacer hechizos, aunque la verdad es que a veces sus conjuros tienen consecuencias inesperadas. ¿Quién es realmente la bruja Elviruja? ¿Por qué su libro de hechizos acabó en manos de Kika? ¿Cómo influyó en ello el dragón Héctor? ¿Y qué pintan el perverso brujo Jerónimo y el malaspulgas de su perro Serafín en esta historia? Por fin vas a saberlo TODO sobre cómo empezaron las aventuras de Kika Superbruja!");
			em.persist(b8);
			
			BookModel b9 = new BookModel("Sherlock Holmes 1 - Estudio en escarlata","Arthur Conan Doyle","Molino"
					,LocalDate.of(2019,10,24),192,1338,"https://www.penguinlibros.com/es/2234179-large_default/sherlock-holmes-1-estudio-en-escarlata.jpg",
					"Primera parte de las aventuras de Sherlock Holmes. Un gran clásico de la literatura de misterio, en una nueva edición adaptada e ilustrada por Pilar Hernández. Cuando el doctor Watson decide compartir apartamento, no puede imaginar todo lo que le sucederá en el 221B de Baker Street. Allí convive con Sherlock Holmes, el detective más excentrico que jamás ha conocido y su nuevo compañero de aventuras. Su primer caso: descubrir quien y por que, ha cometido un asesinato en una casa deshabitada. La colección Inolvidables de Molino presenta los clásicos imprescindibles de la literatura en cuidadas ediciones actualizadas, ilustradas y adaptadas a lectores a partir de 9 años.");
			em.persist(b9);
			
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
