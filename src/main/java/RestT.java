import model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import service.HeadServiceImpl;
import service.UserServiceImpl;


public class RestT {

    static final String URL_EMPLOYEES = "http://94.198.50.185:7081/api/users";

    public static void main(String[] args) {

        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<>(headers);
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        UserServiceImpl userService = new UserServiceImpl(restTemplate);

        ResponseEntity<String> response = userService.allUsers(URL_EMPLOYEES,entity);
        HttpHeaders headersResp = response.getHeaders();

        HeadServiceImpl headService = new HeadServiceImpl();
        headService.setAccept(headers);
        headService.setContentType(headers);
        headService.set(headers,headersResp);

        User user = new User();
        user.setId(3L);
        user.setAge((byte) 10);
        user.setLastName("Brown");
        user.setName("James");

        HttpEntity<User> entity1 = new HttpEntity<>(user,headers);
        ResponseEntity<String> response1 = userService.add(URL_EMPLOYEES,entity1);

        user.setLastName("Shelby");
        user.setName("Thomas");

        HttpEntity<User> entity2 = new HttpEntity<>(user,headers);
        ResponseEntity<String> response2 = userService.edit(URL_EMPLOYEES,entity2);

        ResponseEntity<String> response3 = userService.delete(URL_EMPLOYEES + " /3", entity2);

        System.out.println(response1.getBody() + response2.getBody() + response3.getBody());

    }

}
