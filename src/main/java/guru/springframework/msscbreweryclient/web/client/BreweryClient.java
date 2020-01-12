package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreInvalidFields = false)
public class BreweryClient {

    private final String BEER_PATH_V1 = "/api/v1/beer/";
    private final String Customer_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;
    private String apiHost;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerByID(UUID uuid) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeerDto(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto){
        restTemplate.put(apiHost + BEER_PATH_V1  + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apiHost + BEER_PATH_V1  + uuid.toString());
    }

    public CustomerDto getCustomerByID(UUID uuid) {
        return restTemplate.getForObject(apiHost + Customer_PATH_V1 + uuid.toString(), CustomerDto.class);
    }

    public URI saveNewCustomerDto(CustomerDto CustomerDto){
        return restTemplate.postForLocation(apiHost + Customer_PATH_V1, CustomerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto CustomerDto){
        restTemplate.put(apiHost + Customer_PATH_V1  + uuid.toString(), CustomerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apiHost + Customer_PATH_V1  + uuid.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

}
