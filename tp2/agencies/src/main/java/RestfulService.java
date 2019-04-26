import com.google.gson.Gson;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static spark.Spark.*;

public class RestfulService {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            fh = new FileHandler("./logger.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        port(8080);

        AgencyServiceMapImpl agencyService = new AgencyServiceMapImpl();

        get("/agencias/:site_id/:payment_method_id", (request, response) -> {
            String optionalDefaultQueryParams = "";
            response.type("application/json");
            optionalDefaultQueryParams += (request.queryParams("near_to") != null) ? "&near_to=" +  request.queryParams("near_to") : "";
            optionalDefaultQueryParams += (request.queryParams("limit") != null) ? "&limit=" +  request.queryParams("limit") : "";
            optionalDefaultQueryParams += (request.queryParams("offset") != null) ? "&offset=" +  request.queryParams("offset") : "";
            optionalDefaultQueryParams = (!optionalDefaultQueryParams.equals("")) ? "?" + optionalDefaultQueryParams : "";
            logger.info(request.uri() + optionalDefaultQueryParams);

            try {
                if (request.queryParams("order_by") != null) {

                    return new Gson().toJson(
                            new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                    .toJsonTree(agencyService.getAgencies(request.params(":site_id"), request.params(":payment_method_id"), optionalDefaultQueryParams, request.queryParams("order_by")))));
                } else {
                    return new Gson().toJson(
                            new StandardResponse(StatusResponse.SUCCESS, new Gson()
                                    .toJsonTree(agencyService.getAgencies(request.params(":site_id"), request.params(":payment_method_id"), optionalDefaultQueryParams))));
                }
            } catch (AgencyServiceExpetion e) {
                response.status(503);
                return null;
            }
        });


    }
}
