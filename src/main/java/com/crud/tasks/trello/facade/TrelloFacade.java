package com.crud.tasks.trello.facade;


import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.validator.TrelloValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class TrelloFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloFacade.class);

    private final TrelloValidator trelloValidator;
    private final TrelloService trelloService;
    private final TrelloMapper trelloMapper;

    public List<TrelloBoardDto> fetchTrelloBoards(){
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloService.fetchTrelloBoards());

        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        return trelloMapper.mapToBoardsDto(filteredBoards);
    }

    public CreatedTrelloCardDto createCard(TrelloCardDto cardDto){
        TrelloCard trelloCard = trelloMapper.mapToCard(cardDto);
        trelloValidator.validateCard(trelloCard);

        return trelloService.createTrelloCard(trelloMapper.mapToCardDto(trelloCard));
    }
}
