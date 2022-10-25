package codelion.dao;

import codelion.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao userDao;

    @BeforeEach
    void beforeEach() {
        userDao = new UserDaoFactory().localUserDao();
    }

    @AfterEach
    void afterEach() throws SQLException {
        userDao.deleteAll();
    }

    @Test
    @DisplayName("add(), findById() 가 잘 되는지")
    void addGet() throws SQLException {
        String id = "01";
        userDao.add(new User(id, "jaehyun", "123123"));

        User findUser = userDao.findById(id);
        assertEquals(findUser.getName(), "jaehyun");
    }
}