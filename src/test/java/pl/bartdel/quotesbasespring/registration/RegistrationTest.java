package pl.bartdel.quotesbasespring.registration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bartdel.quotesbasespring.dao.service.UserService;
import pl.bartdel.quotesbasespring.dao.entity.User;
import pl.bartdel.quotesbasespring.dao.entity.UserRole;
import pl.bartdel.quotesbasespring.dao.repo.UserRepo;
import pl.bartdel.quotesbasespring.manager.UserManager;


@SpringBootTest
public class RegistrationTest {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserManager userManager;
    @Autowired
    UserService userService;

    User user1 = new User("User1", "User1", "User1", UserRole.USER);
    User user2 = new User("User2", "User2", "User1", UserRole.USER);
    User user3 = new User("User3", "User3", "User1", UserRole.USER);
    User user4 = new User("User4", "User4", "User1", UserRole.USER);
    User user5 = new User("User5", "User5", "User1", UserRole.USER);
    User user6 = new User("User6", "User6", "User1", UserRole.USER);

    @Test
    public void registerUsersByRepo(){
        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);
        userRepo.save(user4);
        userRepo.save(user5);
        userRepo.save(user6);
    }

    @Test
    public void registerUsersByManager(){
        userManager.registerUser(user1);
        userManager.registerUser(user2);
        userManager.registerUser(user3);
        userManager.registerUser(user4);
        userManager.registerUser(user5);
        userManager.registerUser(user6);
    }

    @Test
    public void registerUsersByService(){
        userService.registerNewUserAccount(user1);
        userService.registerNewUserAccount(user2);
        userService.registerNewUserAccount(user3);
        userService.registerNewUserAccount(user4);
        userService.registerNewUserAccount(user5);
        userService.registerNewUserAccount(user6);
    }

}
