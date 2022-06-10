package com.graphqlapi.graphqlapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GraphqlApiClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphqlApiClientService.class);

    @Autowired
    private RestTemplateClient restTemplate;

    @Value("${swapi.api.get.url}")
    private String swapiApiServiceUrl;

    private String urlApender;

    /* The below method returning the Person's details such as name, height, mass, gender, homeworld*/
    public GraphqlApiResponse getPersonsDetails() {
        GraphqlApiResponse graphqlApiResponse = null;
        try {
            graphqlApiResponse = restTemplate.restTemplate().getForObject(swapiApiServiceUrl, GraphqlApiResponse.class);
            LOGGER.info("API call to " + swapiApiServiceUrl + " has received a response.");

        } catch (Exception ex) {
            LOGGER.error(String.format("Error calling service", swapiApiServiceUrl), ex.getMessage());
        }
        return graphqlApiResponse;
    }

    /*The below method returns the paginated Results based on the Id or page number selected by the user*/
    public GraphqlApiResponse getPaginatedResultsById(int id) {
        GraphqlApiResponse graphqlApiResponse = new GraphqlApiResponse();
        urlApender = new String();
        urlApender = "?page=".concat(String.valueOf(id));
        try {
            graphqlApiResponse = restTemplate.restTemplate().getForObject(swapiApiServiceUrl + urlApender, GraphqlApiResponse.class);
            LOGGER.info("API call to " + swapiApiServiceUrl + urlApender + " has received a response.");

        } catch (Exception ex) {
            LOGGER.error(String.format("Error calling service[%s]", swapiApiServiceUrl + urlApender), ex.getMessage());
        }
        return graphqlApiResponse;
    }

    /*The below method returns particular person results by Searching with name as a String*/
    public GraphqlApiResponse getSearchResultsOfParticularPersonByName(String name) {
        GraphqlApiResponse graphqlApiResponse = new GraphqlApiResponse();
        urlApender = new String();
        urlApender = "?search=".concat(String.valueOf(name));
        try {
            graphqlApiResponse = restTemplate.restTemplate().getForObject(swapiApiServiceUrl + urlApender, GraphqlApiResponse.class);
            LOGGER.info("API call to " + swapiApiServiceUrl + urlApender + " has recieved a response.");

        } catch (Exception ex) {
            LOGGER.error(String.format("Error calling service[%s]", swapiApiServiceUrl + urlApender), ex.getMessage());
        }
        return graphqlApiResponse;
    }
}
