package repository;

import bean.Book;

import java.util.List;

public interface BookRepository {
    void saveOrUpdate(Book book);
    void deleteByID(String id);
    Book findByID(String id);
    List<Book> findAll();
}
