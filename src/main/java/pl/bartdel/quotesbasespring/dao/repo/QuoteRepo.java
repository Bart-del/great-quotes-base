package pl.bartdel.quotesbasespring.dao.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bartdel.quotesbasespring.dao.entity.Quote;

@Repository
public interface QuoteRepo extends CrudRepository<Quote,Long> {

    Iterable<Quote> findAllByAuthor(String author);

    Quote getById(Long id);

}
