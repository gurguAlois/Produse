package operations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import users.User;

public class DbUsers extends DbInitializer{

    private Session session;
    private Transaction transaction;


    public User getUser(int id) {
        getSessionAndTransaction();
        User user = session.find(User.class, id);
        commitTransaction();
        return user;
    }

    public void getSessionAndTransaction() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public void commitTransaction() {
        transaction.commit();
        session.close();
    }

    public void insertUser(User user) {
        getSessionAndTransaction();
        session.persist(user);
        commitTransaction();
    }

    public User getUserByName(String name, String password) {
        getSessionAndTransaction();
        Query query = session.createNamedQuery("find_by_name");
        query.setParameter("name", name);
        query.setParameter("password", password);
        User user = (User)query.getSingleResult();
        commitTransaction();
        return user;
    }
}
