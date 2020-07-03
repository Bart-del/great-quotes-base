package pl.bartdel.quotesbasespring.dao.service;

import pl.bartdel.quotesbasespring.dao.entity.User;

public interface IUserService {
    void registerNewUserAccount(User userDto);
}