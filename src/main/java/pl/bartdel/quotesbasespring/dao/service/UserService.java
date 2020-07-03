package pl.bartdel.quotesbasespring.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bartdel.quotesbasespring.dao.entity.User;
import pl.bartdel.quotesbasespring.dao.entity.UserRole;
import pl.bartdel.quotesbasespring.manager.UserManager;

@Service
public class UserService implements IUserService {
    @Autowired
    private final UserManager userManager;

    @Autowired
    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    @Transactional
    @Override
    public void registerNewUserAccount(User newUser){

        User user = new User();
        user.setLogin(newUser.getLogin());
        user.setPassword(passwordEncoder().encode(newUser.getPassword()));
        user.setMatchingPassword(newUser.getMatchingPassword());
        user.setUserRole(UserRole.USER);
        userManager.registerUser(user);
    }

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}