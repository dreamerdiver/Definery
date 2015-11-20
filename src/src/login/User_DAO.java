package src.login;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/10/15
 */

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class User_DAO {
    private final Logger logger = Logger.getLogger(this.getClass());
    private Session session = null;

    public Integer addUserRole(User user) {
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
        } catch (NullPointerException n) {
            logger.info("User_DAO: The session failed to build and is null");
            n.printStackTrace();
        }
        logger.info("User_DAO: Created session successfully");
        Transaction tx = null;
        Integer userRoleId = null;
            try {
                tx = session.beginTransaction();
                userRoleId = (Integer) session.save(user);
                logger.info("User_DAO: Saved User instance to database");
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
                logger.info("User_DAO: Closed session successfully");
            }
        return userRoleId;
    }
}

