package sidmeyer.stepikweb.db.main;

import javax.persistence.*;

/**
 * Created by stas on 15.05.17.
 */
@Entity
@Table(name = "Users")
public class UserDataSet {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Confirmed")
    private boolean confirmed;

    @Column(name = "SignUpDate")
    private String signUpDate;

    public UserDataSet(String firstName, String lastName, String email, boolean confirmed, String signUpDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.confirmed = confirmed;
        this.signUpDate = signUpDate;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getSignUpDate() {
        return signUpDate;
    }
}

