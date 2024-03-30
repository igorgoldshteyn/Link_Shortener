package com.MicroserviceSpringApp.clientInterface;

import com.MicroserviceSpringApp.clientInterface.api.ClientInterfaceController;
import com.MicroserviceSpringApp.clientInterface.db.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ClientInterfaceApplicationTests {


    @Mock
    private ClientInterfaceController clientInterfaceController;

    String localhost = "http://localhost:8080";

    @Test
    public void
    addClientsTest() throws IOException, InterruptedException {


        Client client = Client.builder()
                .firstName("firstName")
                .lastName("lastName")
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        //todo добавить тело запроса
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(localhost + "/addClient")).build();

        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(response.body().toString(), "");
    }

}
