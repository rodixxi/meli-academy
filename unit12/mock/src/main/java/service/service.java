package service;

import com.google.gson.Gson;
import domain.Site;
import domain.User;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.Delay;
import org.mockserver.model.Header;

import java.util.concurrent.TimeUnit;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class service {

    static MockServerClient mockServer = startClientAndServer(8081);
    static Gson gson;

    public static void consulta(String metodo, String ruta, int codigo, String content, String body, int delay){
        mockServer.when(
                request().withMethod(metodo).withPath(ruta)
        ).respond(
                response().withStatusCode(codigo)
                .withHeader(new Header("Content-Type", content))
                .withBody(body)
                .withDelay(new Delay(TimeUnit.MILLISECONDS, delay))
        );
    }

    public static void main(String[] args) {
        gson = new Gson();
        User user = new User();
        Site site = new Site();

        consulta("GET", "/users/.*", 200, "application/json; charset=utf-8", gson.toJson(user), 300);
        consulta("GET", "/sites/.*", 200, "application/json; charset=utf-8", gson.toJson(site), 300);

    }


}
