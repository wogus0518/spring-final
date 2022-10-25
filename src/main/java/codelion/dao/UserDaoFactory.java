package codelion.dao;

import codelion.dao.connection.ConnectionMaker;
import codelion.dao.connection.LocalConnectionMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoFactory {

    @Bean
    public UserDao localUserDao() {
        return new UserDao(localConnectionMaker());
    }

    @Bean
    public ConnectionMaker localConnectionMaker() {
        return new LocalConnectionMaker();
    }

}
