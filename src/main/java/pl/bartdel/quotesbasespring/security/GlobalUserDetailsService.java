package pl.bartdel.quotesbasespring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bartdel.quotesbasespring.dao.entity.User;
import pl.bartdel.quotesbasespring.dao.entity.UserRole;
import pl.bartdel.quotesbasespring.manager.UserManager;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class GlobalUserDetailsService implements UserDetailsService {

    @Autowired
    private UserManager userManager;

    public GlobalUserDetailsService(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userManager.findByLogin(s);
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(), getAuthorities(user.getUserRole()));
    }

    public List<GrantedAuthority> getAuthorities (UserRole userRole) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = new ArrayList<String>();
        roles.add(userRole.toString());
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
