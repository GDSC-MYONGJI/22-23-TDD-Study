package testdriven.chap09;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.awt.*;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@RequiredArgsConstructor
public class UserApiE2Test {
    private final TestRestTemplate testRestTemplate;

//    @Test
//    void weakPwResponse(){
//        String reqBody = "{\"id\":\"id\", \"pw\":\"123\",\"email\":\"a@a.com\"}";
//        RequestEntity<String> request = RequestEntity.post(URI.create("/users"))
//                .contentType(PageAttributes.MediaType.APPLICATION_JSON_UTP8)
//                .body(reqBody);
//
//        ResponseEntity<String> response = testRestTemplate.exchange(
//                request, String.class
//        );
//
//        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
//        assertTrue(response.getBody().contains("WeakPasswordException"));
//    }
}
