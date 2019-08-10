package pl.jnowacki.dao;

import pl.jnowacki.model.User;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUser(String login) {
        return new User("login", "pwd");
    }
}
