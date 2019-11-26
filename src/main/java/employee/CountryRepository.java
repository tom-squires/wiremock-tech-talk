package employee;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import org.json.JSONObject;

import java.util.Optional;

public class CountryRepository {
    private final Client client = Client.create();
    private final String baseUrl;

    public CountryRepository(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public CountryRepository() {
        this.baseUrl = "http://api.postcodes.io";
    }

    public Optional<String> getCountry(String postCode) {
        // Query API
        ClientResponse clientResponse = client.resource(String.format("%s/postcodes/%s", baseUrl, postCode))
                .get(ClientResponse.class);

        // Parse field from json and return
        return Optional.of(new JSONObject(clientResponse.getEntity(String.class))
                .getJSONObject("result")
                .getString("country"));
    }
}
