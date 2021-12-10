package be.christophe.order.item.api;

import be.christophe.order.domain.items.dto.ItemDto;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static  org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemIntegrationTest {
    @LocalServerPort
    private int port;

    @Test
    void testAddItem() {
        ItemDto itemDto= new ItemDto("","name", "description", 5.99, "Eur", 5);
        ItemDto responseMessage = RestAssured
                        .given()
                        .body(itemDto)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .when()
                        .port(port)
                        .post("/items")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(ItemDto.class);

        assertThat(responseMessage).isInstanceOf(ItemDto.class);
        assertThat(responseMessage.getAmountStock()).isEqualTo(5);
        assertThat(responseMessage.getName()).isEqualTo("name");

        assertThat(responseMessage.getCurrency()).isEqualTo("Eur");
        assertThat(responseMessage.getPrice()).isEqualTo(5.99);
        assertThat(responseMessage.getDescription()).isEqualTo("description");
    }
}