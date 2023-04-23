package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.common.JwtUtil;
import jp.co.axa.apidemo.common.MsgEnum;
import jp.co.axa.apidemo.common.RedisCache;
import jp.co.axa.apidemo.entities.LoginUser;
import jp.co.axa.apidemo.entities.User;
import jp.co.axa.apidemo.exception.ApiException;
import jp.co.axa.apidemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Optional;

/**
 * implement the EmployeeService
 */
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public void UserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public String login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new ApiException(20001,"login failed");
        }
        //generate token by userid
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwtToken = JwtUtil.createJWT(userId);
        //put authenticate into redis
        redisCache.setCacheObject("login:"+userId,loginUser);
        //return token
        return jwtToken;
    }

    @Override
    public void logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redisCache.deleteObject("login:"+userid);
    }
}