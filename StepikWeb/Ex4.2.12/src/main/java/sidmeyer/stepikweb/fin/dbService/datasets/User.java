package sidmeyer.stepikweb.fin.dbService.datasets;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Users")
public class User implements Serializable {

    private static final long serialVersionUID = -5170875020617735652L;

    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<ChatMessage> messages;

    public User(String userName, String password) {
        this.userId = -1;
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


}
