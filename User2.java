import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User get(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> list() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void delete(int id) {
        User user = get(id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
}
