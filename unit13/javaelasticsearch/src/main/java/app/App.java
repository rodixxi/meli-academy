package app;


import service.CountService;
import service.DataService;
import service.DeleteService;
import service.IngestService;
import util.Manager;
import org.elasticsearch.client.Client;


public class App {

    public static void main(String[] args) {
        Manager esManager = new Manager();
        Client client = esManager.getClient("localhost", 9200).get();

        CountService countService = new CountService(client);
        DataService dataService = new DataService(client);
        IngestService ingestService = new IngestService(client);
        DeleteService deleteService = new DeleteService(client);

        //count
        System.out.println("\ngetMatchAllQueryCount from ::: " + countService.getMatchAllQueryCount());
        System.out.println("\ngetBoolQueryCount from ::: " + countService.getBoolQueryCount());
        System.out.println("\ngetPhraseQueryCount from ::: " + countService.getPhraseQueryCount());


        // Data
        System.out.println("\ngetMatchAllQueryData from ::: ");
        dataService.getMatchAllQueryData().forEach(item -> System.out.println(item));

        System.out.println("\ngetBoolQueryData from ::: ");
        dataService.getBoolQueryData().forEach(item -> System.out.println(item));

        System.out.println("\ngetPhraseQueryData from ::: ");
        dataService.getPhraseQueryData().forEach(item -> System.out.println(item));

        //Ingest
        String json1 = "{" +
                "\"nombre\":\"Pipo\"," +
                "\"color\":\"Rojo\"," +
                "\"lugar\":\"Argentina\"" +
                "}";

        String json2 = "{" +
                "\"nombre\":\"Maca\"," +
                "\"color\":\"Azul\"," +
                "\"lugar\":\"Argentina\"" +
                "}";

        System.out.println("delete by query " + deleteService.deleteByQuery("Pepe"));
        client.close();

    }

}
