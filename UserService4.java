import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.config.HibernateConfig;
import com.example.model.User;
import com.example.service.UserService;

public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        UserService userService = context.getBean(UserService.class);

        // Create
        User user1 = new User("Shivam Tomar", "shivam@example.com");
        userService.addUser(user1);

        // Read
        System.out.println("User List: " + userService.getAllUsers());

        // Update
        user1.setEmail("shivam.tomar@gmail.com");
        userService.updateUser(user1);

        // Delete
        userService.deleteUser(user1.getId());

        System.out.println("Final User List: " + userService.getAllUsers());

        context.close();
    }
}
