import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class Test {

    private static final String URL_SITES = "https://api.mercadolibre.com/sites";

    public static void main(String[] args) {
        for (int x = 0 ; x < 5 ; x++) {
            getCategoteisRandomSite();
        }
    }

    private static String readUrl(String urlString) throws IOException {

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

    private static void getCategoteisRandomSite(){
        Random random = new Random();
        String data = "";

        try {
            data = readUrl(URL_SITES);
            Site[] sites = new Gson().fromJson(data, Site[].class);
            int n =random.nextInt(sites.length);
            data = readUrl(new StringBuilder()
                    .append("https://api.mercadolibre.com/sites/")
                    .append(sites[n].getId())
                    .append("/categories")
                    .toString());
            Category[] categories = new Gson().fromJson(data, Category[].class);
            System.out.println(new StringBuilder()
                    .append(" ----------- ")
                    .append(sites[n].getName())
                    .append(" ----------- ")
                    .toString());
            for (Category category: categories) {
                System.out.println(category.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error connection to url");
        }
    }
}
