import com.github.tomakehurst.wiremock.WireMockServer;
import employee.EmployeeRepository;
import employee.EmployeeService;
import employee.CountryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MocksTest {
    private EmployeeService employeeService = new EmployeeService(new EmployeeRepository(),
            new CountryRepository("http://localhost:9999"));

    private static WireMockServer wireMockServer = new WireMockServer();

    @BeforeAll
    public static void setUp() {
        wireMockServer.start();
    }

    @AfterEach
    public void tearDown() {
        wireMockServer.resetAll();
    }

    @Test
    public void countryAsExpectedForEmployeeId() {
        // When
        stubFor(get(urlEqualTo("/postcodes/WD33AQ"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("{\n" +
                                "    \"result\" : {\n" +
                                "        \"country\" : \"a mocked country\"\n" +
                                "    }\n" +
                                "}")
                ));

        // Then
        assertEquals("a mocked country", employeeService.getCountry(1));
    }
}
