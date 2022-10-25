package codelion.dao;

import codelion.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    UserDao userDao;

    @Autowired
    ApplicationContext ac;

    @BeforeEach
    void beforeEach() {
        userDao = ac.getBean("localUserDao", UserDao.class);
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

    @Test
    @DisplayName("findById 실패 시나리오")
    void findByIdFail() {
        String id = "01";
        assertThrows(NoSuchElementException.class, () -> userDao.findById(id));
    }
}