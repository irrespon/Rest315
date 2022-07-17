package service;

import model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> allUsers(String url, HttpEntity<String> entity);
    ResponseEntity<String> add(String url, HttpEntity<User> entity);
    ResponseEntity<String> edit(String url, HttpEntity<User> entity);
    ResponseEntity<String> delete(String url, HttpEntity<User> entity);
}
