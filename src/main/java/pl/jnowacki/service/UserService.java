package pl.jnowacki.service;

import pl.jnowacki.dao.UserDao;
import pl.jnowacki.dao.UserDaoImpl;
import pl.jnowacki.model.User;

public class UserService {

    private UserDao userDao = new UserDaoImpl();

    boolean checkIfValid (String login, String password) {
        User user = userDao.getUser(login);

        return user.getLogin().equals(login) && user.getPassword().equals(password);
    }
}
