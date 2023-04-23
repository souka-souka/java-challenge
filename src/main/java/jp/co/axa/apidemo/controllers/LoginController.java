package jp.co.axa.apidemo.controllers;


import io.swagger.annotations.ApiOperation;
import jp.co.axa.apidemo.common.ResultBody;
import jp.co.axa.apidemo.entities.User;
import jp.co.axa.apidemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * LoginController
 * </p>
 *
 */
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;

    //login and return token
    @PostMapping("login")
    @ApiOperation(value = "login and return token", notes = "usename:sg,password:1234;databese:usename:sg,password:$2a$10$oVh6uioKPOaxRAlPIB8DaedpV9Q4b7pasgHZtS26B/dy8zrf3v9ru;")
    public ResultBody loginUser(@RequestBody User user) {
        String token = userService.login(user);
        return ResultBody.ok().data("token",token);
    }

    //logout
    @PostMapping("logout")
    public ResultBody logout(HttpServletRequest request) {
        userService.logout();
        return ResultBody.ok();
    }
}

