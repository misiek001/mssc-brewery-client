package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient breweryClient;

    @Test
    void getBeerByID() {
        assertNotNull(breweryClient.getBeerByID(UUID.randomUUID()));
    }

    @Test
    void saveNewBeerDto() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        URI uri = breweryClient.saveNewBeerDto(beerDto);

        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void updateBeer() {

        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerByID() {
        assertNotNull(breweryClient.getCustomerByID(UUID.randomUUID()));
    }

    @Test
    void saveNewCustomerDto() {
        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();

        URI uri = breweryClient.saveNewCustomerDto(customerDto);

        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void updateCustomer() {

        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();

        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}