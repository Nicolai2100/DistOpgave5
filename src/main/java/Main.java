import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("Skriv firmanavn: ");
        Scanner scanner = new Scanner(System.in);
        String VAT = getVAT(scanner.next());
        System.out.println(VAT);

    }

    private static String getVAT(String name) {
        HttpResponse<JsonNode> response = Unirest.get("https://cvrapi.dk/api?search="+name+"&country=dk")
                .asJson();

        return (response.getBody().getObject().getString("vat"));
    }
}
