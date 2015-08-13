package mblog.persist.service;

import mblog.data.OpenOauth;
import mblog.data.User;

/**
 * @author langhsu on 2015/8/12.
 */
public interface OpenOauthService {
    //通过 oauth_token 查询 user
    User getUserByOauthToken(String oauth_token);

    OpenOauth getOauthByToken(String oauth_token);

    OpenOauth getOauthByUid(long userId);

    boolean checkIsOriginalPassword(long userId);

    void saveOauthToken(OpenOauth oauth);

    // 只允许第三方登录且没修改过用户名时才可以修改
    void updateUsername(long userId, String username, String nickname);
}
