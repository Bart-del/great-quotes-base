package pl.bartdel.quotesbasespring.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.bartdel.quotesbasespring.dao.entity.Quote;

@Component
public class QuoteValidator implements Validator {

    @Override
    public boolean supports(Class<?> bClass) {
        return Quote.class.equals(bClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Quote quote = (Quote) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body", "NotEmpty");
        if (quote.getBody().length() < 5 || quote.getBody().length() > 200) {
            errors.rejectValue("body", "Size.quoteForm.body");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "NotEmpty");
        if (quote.getAuthor().length() < 2 || quote.getAuthor().length() > 50) {
            errors.rejectValue("author", "Size.quoteForm.author");
        }

    }
}