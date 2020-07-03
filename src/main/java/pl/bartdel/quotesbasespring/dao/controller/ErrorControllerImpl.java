package pl.bartdel.quotesbasespring.dao.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

public class ErrorControllerImpl implements ErrorController {
    @Override
    public String getErrorPath() {
        return "error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        return "error";
        }
    }
