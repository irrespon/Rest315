package service;

import model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{

    final
    RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<String> allUsers(String url, HttpEntity<String> entity) {
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    @Override
    public ResponseEntity<String> add(String url, HttpEntity<User> entity) {
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }

    @Override
    public ResponseEntity<String> edit(String url, HttpEntity<User> entity) {
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
    }

    @Override
    public ResponseEntity<String> delete(String url, HttpEntity<User> entity) {
        return restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
    }
}
