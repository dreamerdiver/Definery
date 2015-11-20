package src.login;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/11/15
 */
public class SessionFactoryProvider {
    private final Logger logger = Logger.getLogger(this.getClass());
    private static SessionFactory sessionFactory;

    public void init() {
        createSessionFactory();
        checkSessionExists();
        getSessionFactory();
    }

    public static void createSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("/hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .buildServiceRegistry();
            System.out.println("createSessionFactory config: " + configuration.buildSessionFactory(serviceRegistry));
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable x) {
            throw new ExceptionInInitializerError(x);
        }
    }

    public boolean checkSessionExists() {
        if (sessionFactory == null) {
            logger.info("SessionFactoryProvider: Session Created Successfully");
            return true;
        } else {
            logger.info("SessionFactoryProvider: Session Failed to Instantiate");
            return false;
        }
    }

    public static SessionFactory getSessionFactory() {
        createSessionFactory();

        return sessionFactory;
    }
}