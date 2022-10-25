package codelion.dao;

import codelion.dao.connection.LocalConnectionMaker;

public class UserDaoFactory {
    public UserDao localUserDao() {
        UserDao userDao = new UserDao(new LocalConnectionMaker());
        return userDao;
    }
}
