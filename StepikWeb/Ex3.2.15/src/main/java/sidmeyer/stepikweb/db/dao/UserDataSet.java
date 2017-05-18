package sidmeyer.stepikweb.db.dao;

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

    public UserDataSet() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDataSet that = (UserDataSet) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return signUpDate != null ? signUpDate.equals(that.signUpDate) : that.signUpDate == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (signUpDate != null ? signUpDate.hashCode() : 0);
        return result;
    }
}

