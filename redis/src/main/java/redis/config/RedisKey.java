package redis.config;

/**
 * redis静态Key.
 *
 * @author Cc 2024/9/6 10:23
 */
public final class RedisKey {

    private RedisKey() {
        throw new RuntimeException("final class");
    }

    public static final String PERSONAL_IDENTITY_TRUE_PRO_RANK = "personalIdentityTrueProRank";
    public static final String EDUCATION_TYPE = "educationType";
    public static final String CHANGE_TYPE = "changeType:";
    public static final String IGNORE_CHANGE_TYPE = "ignoreChangeType";
}
