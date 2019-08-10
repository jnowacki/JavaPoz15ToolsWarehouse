package pl.jnowacki.service;

import pl.jnowacki.dao.UserDao;
import pl.jnowacki.dao.UserDaoImpl;
import pl.jnowacki.model.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    public boolean checkIfValid (String login, String password) {
        User user = userDao.getUser(login);

        return user.getLogin().equals(login) && user.getPassword().equals(password);
    }
}
