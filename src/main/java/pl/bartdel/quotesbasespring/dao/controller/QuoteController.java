
package pl.bartdel.quotesbasespring.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bartdel.quotesbasespring.dao.entity.Quote;
import pl.bartdel.quotesbasespring.manager.QuoteManager;
import pl.bartdel.quotesbasespring.validation.QuoteValidator;


@Controller
@RequestMapping()
public class QuoteController {
    @Autowired
    private QuoteManager quoteManager;

    @Autowired
    private QuoteValidator quoteValidator;

    public QuoteController(QuoteManager quoteManager) {
        this.quoteManager = quoteManager;
    }

    @GetMapping()
    public String showMainPage(Model model){
        Iterable<Quote> quotesList = quoteManager.findAll();
        model.addAttribute("allQuotes", quotesList);
        return"main";
    }

    @RequestMapping(value="/getAllByAuthor={author}", method = RequestMethod.GET)
    public String showAllByAuthorForm(@RequestParam @PathVariable(value = "author") String author, Model model){
        if(author.isEmpty()){
            return "redirect:/";
        }
        Iterable<Quote> quotesListByAuthor = quoteManager.findAllByAuthor(author);
        model.addAttribute("quotesByAuthorRequest", true);
        model.addAttribute("getQuotesByAuthor",quotesListByAuthor);
        return "main";
    }
    @RequestMapping(value="/getAllByAuthor={author}", method=RequestMethod.POST)
    public String getAllByAuthor(@RequestParam @PathVariable(value = "author") String author, Model model){
        model.addAttribute("author", author);
        return "main";
    }

    @RequestMapping(value = "/addQuote", method = RequestMethod.GET)
    public String showAddingQuoteForm(Model model){
            model.addAttribute("newQuote", new Quote());
            return "addQuote";
    }
    @RequestMapping(value = "/addQuote", method = RequestMethod.POST)
    public String addQuote(@ModelAttribute(value = "newQuote") Quote newQuote, Model model, BindingResult bindingResult) {
        quoteValidator.validate(newQuote, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addQuote";
        }
        quoteManager.save(newQuote);
        model.addAttribute("quoteAddedSuccessfully", true);

        return "redirect:/";
    }

    @RequestMapping( value="/editQuote/{id}", method = RequestMethod.GET)
    public String getUpdatingQuote(@PathVariable Long id, Model model) {
        Quote quote = quoteManager.getById(id);
        model.addAttribute("editedQuote", quote);
        model.addAttribute("body", quote.getBody());
        model.addAttribute("author", quote.getAuthor());
        return "editQuote";
    }

    @RequestMapping(value = "/editQuote/{id}", method = RequestMethod.POST)
    public String postUpdateQuote(@ModelAttribute Quote editedQuote, @PathVariable Long id) {
        quoteManager.deleteById(id);
        quoteManager.save(editedQuote);
        return "redirect:/";
    }

    @RequestMapping(value="/deleteQuote/{id}", method = RequestMethod.GET)
    public String deleteQuote(@PathVariable Long id) {
        quoteManager.deleteById(id);
        return "redirect:/";
    }


}
