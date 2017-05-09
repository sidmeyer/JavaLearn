package sidmeyer.stepikweb.authorization.accounts;

import sidmeyer.stepikweb.authorization.common.LongId;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stas on 09.05.17.
 */
public class AccountService {
    private static long numberOfProfiles = 0;

    Map<LongId<UserProfile>, UserProfile> userIdToProfile = new HashMap<>();
    //Map<LongId<Session>, LongId<UserProfile>> sessionIdToUserId = new HashMap<>();

    public void addNewUser(UserProfile userProfile) {
        userIdToProfile.put(new LongId<UserProfile>(numberOfProfiles++), userProfile);
    }

    private boolean userExist(UserProfile userProfile) {
        return userIdToProfile.containsValue(userProfile);
    }

//    private LongId<UserProfile> getLongIdByUserProfile(UserProfile userProfile) {
//        return userIdToProfile.containsValue(userProfile)
//    }
}
