package aquarium.shop.user;

import org.hibernate.annotations.ColumnTransformer;

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

    @ColumnTransformer(

            write = "pgp_sym_encrypt( " +
                    "    ?, " +
                    "    current_setting('encrypt.key')" +
                    ") "
    )

    @Column(columnDefinition = "bytea", nullable = false)
    private String password;

    @Column(name = "user_role", nullable = false)
    private String userRole;

    public UserDetails(){}

    public UserDetails(String name, String password, String userRole) {
        this.name = name;
        this.password = password;
        this.userRole = userRole;
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
