package aquarium.shop;
import org.springframework.security.crypto.bcrypt.BCrypt;


import javax.persistence.*;



import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String password;

    @Column(nullable = false)
    private String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt(10));

    @Column(nullable = false)
    private String userRole;

    public UserDetails(){}

    public UserDetails(String name, String password, String userRole) {
        this.name = name;
        this.password = password;
        this.userRole = userRole;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
