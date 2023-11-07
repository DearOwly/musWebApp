package so.sonya;

import so.sonya.connection.DataSourceConfiguration;
import so.sonya.dao.UserDao;
import so.sonya.dao.impl.UserDaoImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitListener implements ServletContextListener {

    private final DataSourceConfiguration dataSource = DataSourceConfiguration.getInstance();
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        UserDao userDao = new UserDaoImpl(dataSource);
        // AuthorizationService authorizationService = new AuthorizationServiceImpl(usersRepository);

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("userDao", userDao);
       // servletContext.setAttribute("authorizationService", authorizationService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
