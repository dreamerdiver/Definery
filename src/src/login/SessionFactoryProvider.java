package src.login;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Project: Definery
 * Class: SessionFactoryProvider
 * Created by Meesh
 * 11/11/15
 */
public class SessionFactoryProvider {
    private final Logger logger = Logger.getLogger(this.getClass());
    private static SessionFactory sessionFactory;

    public static void createSessionFactory() {
            Configuration configuration = new Configuration();
            configuration.configure("/hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .buildServiceRegistry();
        System.out.println("createSessionFactory config: " + configuration.buildSessionFactory(serviceRegistry));
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public boolean checkSessionExists() {
        if (sessionFactory == null) {
            logger.info("SessionFactoryProvider: Session Created: " + true);
            return true;
        } else {
            logger.info("SessionFactoryProvider: Session Created: " + false);
            return false;
        }
    }

    public static SessionFactory getSessionFactory() {
        createSessionFactory();
        System.err.println("Get session was successful");
        return sessionFactory;
    }
}