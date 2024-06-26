package vip.fairy.app19a.service;

import java.util.List;
import vip.fairy.app19a.domain.Book;
import vip.fairy.app19a.domain.Category;

public interface BookService {

  List<Category> getAllCategories();

  Category getCategory(int id);

  List<Book> getAllBooks();

  Book save(Book book);

  Book update(Book book);

  Book get(long id);

  long getNextId();

}
