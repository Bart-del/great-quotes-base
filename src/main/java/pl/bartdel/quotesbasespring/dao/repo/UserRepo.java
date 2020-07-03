package pl.bartdel.quotesbasespring.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bartdel.quotesbasespring.dao.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findUserByLogin(String login);
}
