package src.login;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/10/15
 */

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class User_DAO {
    public Integer addUserRole(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer userRoleId = null;
        try {
            tx = session.beginTransaction();
            userRoleId = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userRoleId;
    }
}

