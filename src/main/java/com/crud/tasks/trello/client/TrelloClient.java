package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrelloClient {
    private final RestTemplate restTemplate;

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;
    @Value("${trello.username}")
    private String trelloUsername;


    private URI getUrl(){
        URI url=  UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint+"/members/"+trelloUsername+"/boards")
                .queryParam("key",trelloAppKey)
                .queryParam("token",trelloToken)
                .queryParam("fields","name,id")
                .build()
                .encode()
                .toUri();

        return url;
    }

    public List<TrelloBoardDto> getTrelloBoards(){
      URI url = getUrl();
      TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url,TrelloBoardDto[].class);

      List<TrelloBoardDto> boards = Arrays.asList(boardsResponse).stream()
              .filter(trelloBoardDto -> trelloBoardDto.getId() !=null && trelloBoardDto!=null)
              .filter(trelloBoardDto -> trelloBoardDto.getName().equals("Kodilla"))
              .collect(Collectors.toList());


        return Optional.ofNullable(boards)
                .orElse(Collections.emptyList());
    }
}
