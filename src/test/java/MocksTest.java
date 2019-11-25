import com.github.tomakehurst.wiremock.WireMockServer;
import employee.EmployeeRepository;
import employee.EmployeeService;
import employee.PostcodesRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MocksTest {
    private EmployeeService employeeService = new EmployeeService(new EmployeeRepository(),
            new PostcodesRepository("http://localhost:8080"));

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
    public void countyAsExpectedForEmployeeId1() {
        // When
        stubFor(get(urlEqualTo("/postcodes/WD33AQ"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("{\n" +
                                "    \"result\" : {\n" +
                                "        \"admin_county\" : \"a mocked county\"\n" +
                                "    }\n" +
                                "}")
                ));

        // Then
        assertEquals("a mocked county", employeeService.getCounty(1));
    }
}
