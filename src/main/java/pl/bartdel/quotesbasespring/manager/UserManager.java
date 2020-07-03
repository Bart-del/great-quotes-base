package pl.bartdel.quotesbasespring.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bartdel.quotesbasespring.dao.entity.User;
import pl.bartdel.quotesbasespring.dao.repo.UserRepo;

@Service
public class UserManager {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    public UserManager() {
    }

    public UserManager(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void registerUser(User user){
        userRepo.save(user);
    }

    public User findByLogin(String login) {
        return userRepo.findUserByLogin(login);
    }
}
