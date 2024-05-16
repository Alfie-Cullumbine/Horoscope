import java.net.URI;
import java.net.http.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Zodiac Sign: \n");
        String sign = myObj.nextLine();
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://daily-horoscope-api.p.rapidapi.com/api/Daily-Horoscope-English/?zodiacSign="+sign+"&timePeriod=today"))
		.header("X-RapidAPI-Key", "6240ee8072msh88e14cff1fd8ccbp18e999jsne5faa1ebcd67")
		.header("X-RapidAPI-Host", "daily-horoscope-api.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
