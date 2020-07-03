package pl.bartdel.quotesbasespring.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bartdel.quotesbasespring.dao.entity.Quote;
import pl.bartdel.quotesbasespring.dao.repo.QuoteRepo;

@Service
public class QuoteManager {
    @Autowired
    private QuoteRepo quoteRepo;

    @Autowired
    public QuoteManager(QuoteRepo quoteRepo) {
        this.quoteRepo = quoteRepo;
    }

    public Iterable<Quote> findAllByAuthor(String author){
        return quoteRepo.findAllByAuthor(author);
    }

    public Iterable<Quote> findAll(){
        return quoteRepo.findAll();
    }

    public Quote save(Quote quote){
        return quoteRepo.save(quote);
    }

    public void deleteById(Long id){
        quoteRepo.deleteById(id);
    }

    public Quote getById(Long id){
        return quoteRepo.getById(id);
    }




}
