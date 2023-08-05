package service.impl;

import bean.Book;
import repository.BookRepository;
import repository.impl.BookRepositoryImpl;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookRepository repository = new BookRepositoryImpl();


    @Override
    public void saveOrUpdate(Book book) {
        repository.saveOrUpdate(book);
    }

    @Override
    public void deleteByID(String id) {
        repository.deleteByID(id);
    }

    @Override
    public Book findByID(String id) {
        return repository.findByID(id);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }
}
