package pl.bartdel.quotesbasespring.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bartdel.quotesbasespring.security.GlobalUserDetailsService;

@SpringBootTest
public class LoginTest {
    @Autowired
    GlobalUserDetailsService globalUserDetailsService;

    public void loginTest(){

    }
}
