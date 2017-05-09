package sidmeyer.stepikweb.authorization.accounts;

import sidmeyer.stepikweb.authorization.common.LongId;

/**
 * Created by stas on 09.05.17.
 */
public class UserProfile {
    //private static long numberOfProfiles = 0;
    //private final LongId<UserProfile> id;
    private final String login;
    private String password;

    public UserProfile(String login, String password) {
        this.login = login;
        this.password = password;
        //this.id = new LongId<>(numberOfProfiles++);
    }

//    public LongId<UserProfile> getId() {
//        return id;
//    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
