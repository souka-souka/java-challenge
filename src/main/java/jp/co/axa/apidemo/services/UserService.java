package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.User;

/**
 * EmployeeService interface
 */
public interface UserService {
    String login(User member);
    void logout();

}