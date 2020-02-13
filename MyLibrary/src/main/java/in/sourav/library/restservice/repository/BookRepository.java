package in.sourav.library.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sourav.library.restservice.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

	List<Book> findByNameContaining(String bookName);
}