package so.sonya.servlet.listener;

import so.sonya.connection.DataSourceConfiguration;
import so.sonya.dao.UserDao;
import so.sonya.dao.impl.UserDaoImpl;
import so.sonya.service.AuthorizationService;
import so.sonya.service.PasswordEncoder;
import so.sonya.service.UserMapper;
import so.sonya.service.impl.AuthorizationServiceImpl;
import so.sonya.service.impl.PasswordEncoderImpl;
import so.sonya.service.impl.UserMapperImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

    DataSourceConfiguration dataSource;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        PasswordEncoder passwordEncoder = new PasswordEncoderImpl();
        UserMapper userMapper = new UserMapperImpl();
        UserDao userDao = new UserDaoImpl(dataSource);
        AuthorizationService authorizationService = new AuthorizationServiceImpl(userDao, passwordEncoder, userMapper);

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("userDao", userDao);
        servletContext.setAttribute("authorizationService", authorizationService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
