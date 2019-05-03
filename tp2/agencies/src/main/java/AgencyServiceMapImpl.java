import com.google.gson.Gson;
import model.Agency;
import model.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.List;

public class AgencyServiceMapImpl implements AgencyService{

    private Collection<Agency> getCustomResponse(String site_id, String payment_method_id, String optionalQueryParams) throws AgencyServiceExpetion {
        String data = "";
        List<Agency> agencies;
        String url = new StringBuilder()
                .append("https://api.mercadolibre.com/sites/")
                .append(site_id)
                .append("/payment_methods/")
                .append(payment_method_id)
                .append("/agencies")
                .append(optionalQueryParams)
                .toString();

        try {
            data = readUrl(url);
            Response response = new Gson().fromJson(data, Response.class);
            agencies = response.getAgencies();
            return agencies;

        } catch (IOException e) {
            throw new AgencyServiceExpetion("No se pudo conectar al servicio");
        }
    }

    private String readUrl(String urlString) throws IOException {

        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int read = 0;
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            return buffer.toString();
        }   finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    @Override
    public Collection<Agency> getAgencies(String site_id, String payment_method_id, String optionalQueryParams) throws AgencyServiceExpetion{
        return getCustomResponse(site_id, payment_method_id, optionalQueryParams);
    }

    @Override
    public Collection<Agency> getAgencies(String site_id, String payment_method_id, String optionalQueryParams, String orderBy) throws AgencyServiceExpetion {
        Collection<Agency> agencies = getCustomResponse(site_id, payment_method_id, optionalQueryParams);
        setSortedMethod(agencies, orderBy);
        return CollectionSort.sort(agencies);
    }

    private void setSortedMethod(Collection<Agency> agencies, String orderBy) {
        Agency.OrderBy order = Agency.OrderBy.DISTANCE;
        switch (orderBy) {
            case "address_line": order = Agency.OrderBy.ADDRESS_LINE; break;
            case "agency_code": order = Agency.OrderBy.AGENCY_CODE; break;
            case "distance":order = Agency.OrderBy.DISTANCE; break;
        }
        for (Agency agency: agencies) {
            agency.orderBy = order;
            break;
        }
    }
}
