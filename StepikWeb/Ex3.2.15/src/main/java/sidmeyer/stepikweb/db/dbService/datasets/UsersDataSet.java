package sidmeyer.stepikweb.db.dbService.datasets;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by stas on 19.05.17.
 */
@Entity
@Table(name = "Users")
public class UsersDataSet implements Serializable {
    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    public UsersDataSet(String userName, String password) {
        this.userId = -1;
        this.userName = userName;
        this.password = password;
    }

    public UsersDataSet() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
