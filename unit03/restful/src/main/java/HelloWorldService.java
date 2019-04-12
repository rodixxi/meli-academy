import spark.Spark;

import static spark.Spark.*;

public class HelloWorldService {

    public static void main(String[] args) {

        Spark.port(8080);

        get("/hello", (request, response) -> "Hello World");

        get("/hello/:name", (request, response) -> {
            return "Hello, " + request.params(":name");
        });
    }
}
