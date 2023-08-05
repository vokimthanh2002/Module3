package repository.impl;

import bean.Book;
import bean.Category;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepositoryImpl implements BookRepository {
    private static Map<String,Book> bookMap;
    static {
        bookMap= new HashMap<>();
//        bookMap.put("1",new Book("Sach gk","1","vkt",new Category("7","Kinh Di")));
//        bookMap.put("2",new Book("Sach gk","1","vkt",new Category("7","Kinh Di")));
//        bookMap.put("3",new Book("Sach gk","1","vkt",new Category("7","Kinh Di")));
//        bookMap.put("4",new Book("Sach gk","1","vkt",new Category("7","Kinh Di")));
    }
    @Override
    public void saveOrUpdate(Book book) {
        bookMap.put(book.getId(),book);
    }

    @Override
    public void deleteByID(String id) {
        bookMap.remove(id);
    }

    @Override
    public Book findByID(String id) {
        return bookMap.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookMap.values());
    }
}
