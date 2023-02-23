package testdriven.chap09;

import testdriven.chap07.validCard.CardValidity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;

public class CardNumberValidator {

    // 7장과 달리 추가된 코드
    // 생성자로부터 server url 을 받아 하드코딩이 되지 않도록 함.
    private String server;

    public CardNumberValidator(String server){
        this.server = server;
    }
    //
    public CardValidity validate(String cardNumber){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(server + "/card"))
                .header("Content-Type", "text/plain")
                .POST(HttpRequest.BodyPublishers.ofString(cardNumber))
                .build();
        try{
            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            switch (response.body()){
                case "ok" : return CardValidity.VALID;
                case "bad" : return CardValidity.INVALID;
                case "expired" : return CardValidity.EXPIRED;
                case "theft" : return CardValidity.THEFT;
                default : return CardValidity.UNKNOWNS;
            }
        }catch (HttpTimeoutException e){
            return CardValidity.TIMEOUT;
        }
        catch (IOException | InterruptedException e){
            return CardValidity.ERROR;
        }
    }
}
