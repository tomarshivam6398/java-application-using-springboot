

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDAO;
import com.example.model.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void addUser(User user) {
        userDAO.save(user);
    }

    public User getUser(int id) {
        return userDAO.get(id);
    }

    public List<User> getAllUsers() {
        return userDAO.list();
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    public void deleteUser(int id) {
        userDAO.delete(id);
    }
}
