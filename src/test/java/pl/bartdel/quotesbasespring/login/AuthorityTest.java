package pl.bartdel.quotesbasespring.login;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.AccessType;
import pl.bartdel.quotesbasespring.dao.entity.User;
import pl.bartdel.quotesbasespring.dao.entity.UserRole;
import pl.bartdel.quotesbasespring.security.GlobalUserDetailsService;

@SpringBootTest
public class AuthorityTest {
    @Autowired
    GlobalUserDetailsService globalUserDetailsService;

    User user1 = new User("User1", "User1", "User1", UserRole.USER);
    User user2 = new User("User2", "User2", "User1", UserRole.USER);
    User user3 = new User("User3", "User3", "User1", UserRole.ADMINISTRATOR);
    User user4 = new User("User4", "User4", "User1", UserRole.USER);
    User user5 = new User("User5", "User5", "User1", UserRole.ADMINISTRATOR);

    @Test
    public void checkAuthority(){
        Assertions.assertEquals(UserRole.USER,globalUserDetailsService.getAuthorities(user1.getUserRole()));
        Assertions.assertEquals(UserRole.USER,globalUserDetailsService.getAuthorities(user2.getUserRole()));
        Assertions.assertEquals(UserRole.ADMINISTRATOR,globalUserDetailsService.getAuthorities(user3.getUserRole()));
        Assertions.assertEquals(UserRole.USER,globalUserDetailsService.getAuthorities(user4.getUserRole()));
        Assertions.assertEquals(UserRole.ADMINISTRATOR,globalUserDetailsService.getAuthorities(user5.getUserRole()));
    }

}
