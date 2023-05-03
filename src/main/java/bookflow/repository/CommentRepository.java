package bookflow.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import bookflow.models.Book;
import bookflow.models.BookModel;
import bookflow.models.Comment;
import bookflow.models.Loan;
import bookflow.models.User;
import bookflow.util.State;

public class CommentRepository {

	public static List<Comment> getCommentsByBookModelId(Integer id, EntityManager em){
		List<Comment> comments = em.createQuery(
                "SELECT c FROM Comment c WHERE c.bookModel.id = :id", Comment.class)
				.setParameter("id", id).getResultList();
		return comments;
	}
	
	public static void createComment(User user, BookModel book, String text, EntityManager em) {
		em.getTransaction().begin();
		Comment comment = new Comment(text);
		comment.setUser(user);
		comment.setBookModel(book);
		em.persist(comment);
		em.getTransaction().commit();
	}
	
}
