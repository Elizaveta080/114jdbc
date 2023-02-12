package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String sql = String.format(
                    "CREATE TABLE IF NOT EXISTS users(%s, %s, %s, %s);",
                    "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT",
                    "name VARCHAR(255)",
                    "lastName VARCHAR(255)",
                    "age INT"
            );
            Query query = session.createSQLQuery(sql);
            query.executeUpdate();
            session.getTransaction().commit();

    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS users;";
            Query query = session.createSQLQuery(sql);
            query.executeUpdate();
            session.getTransaction().commit();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            session.getTransaction().commit();

    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();

    }

    @Override
    public List<User> getAllUsers() {

        Session session = Util.getSessionFactory().getCurrentSession();
        List users;

            session.beginTransaction();
            users = session.createCriteria(User.class).list();
            session.getTransaction().commit();

            session.close();

        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String sql = "TRUNCATE TABLE users;";
            Query query = session.createSQLQuery(sql);
            query.executeUpdate();
            session.getTransaction().commit();

    }
}
