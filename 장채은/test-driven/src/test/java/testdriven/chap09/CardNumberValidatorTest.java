package testdriven.chap09;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdriven.chap07.validCard.CardValidity;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.*;

public class CardNumberValidatorTest {
     private WireMockServer wireMockServer;

     @BeforeEach
    void setUp(){
         wireMockServer = new WireMockServer(options().port(8089));
         wireMockServer.start();
     }

     @AfterEach
    void tearDown(){
         wireMockServer.stop();
     }

     @Test
    void valid(){
         wireMockServer.stubFor(post(urlEqualTo("/card")) // url, post 요청
                 .withRequestBody(equalTo("1234567890")) // 요청 몸체가 "1234567890 과 요청이 같으면
                 .willReturn(aResponse()
                         .withHeader("Content-Type", "text/plain") // header는 다음과 같이
                         .withBody("ok"))); // 응답 몸체가 ok로 값을 전달해줌
         CardNumberValidator validator = new CardNumberValidator("http://localhost:8089");
         CardValidity validity = validator.validate("1234567890");
         assertEquals(CardValidity.VALID, validity);
     }

     @Test
     void timeout(){
         wireMockServer.stubFor(post(urlEqualTo("/card"))
                 .willReturn(aResponse().withFixedDelay(5000)));

         CardNumberValidator validator = new CardNumberValidator("http://localhost:8089");
         CardValidity validity = validator.validate("1234567890");
         assertEquals(CardValidity.TIMEOUT, validity);
     }
}
