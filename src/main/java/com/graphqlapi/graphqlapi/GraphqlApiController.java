package com.graphqlapi.graphqlapi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dev/")
public class GraphqlApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphqlApiController.class);

    @Autowired
    private GraphqlApiClientService clientService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/graphql")
    public GraphqlApiResponse processPersonsDetails() {
        try {
            GraphqlApiResponse apiResponse = clientService.getPersonsDetails();
            return apiResponse;
        } catch (Exception ex) {
            LOGGER.error(String.format("Failed to Retrieve Persons Details From Swapi Api", ex.getMessage()));
        }
        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/page")
    public GraphqlApiResponse processPaginatedResultsById(@RequestParam Integer id) {
        try {
            GraphqlApiResponse apiResponse = clientService.getPaginatedResultsById(id);
            return apiResponse;
        } catch (Exception ex) {
            LOGGER.error(String.format("Failed to Retrieve Paginated Results By Id", ex.getMessage()));
        }
        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/search")
    public GraphqlApiResponse processSearchResultsByName(@RequestParam String name) {
        try {
            GraphqlApiResponse apiResponse = clientService.getSearchResultsOfParticularPersonByName(name);
            return apiResponse;
        } catch (Exception ex) {
            LOGGER.error(String.format("Failed to Retrieve Search Results By Name", ex.getMessage()));
        }
        return null;
    }
}