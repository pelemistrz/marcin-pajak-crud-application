package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class TrelloMapper {
    //checked
    public TrelloBoard mapToBoard(TrelloBoardDto trelloBoardDto) {
        return new TrelloBoard(trelloBoardDto.getName(),trelloBoardDto.getId(), mapToList(trelloBoardDto.getLists()));
    }
    //checked
    public List<TrelloList> mapToList(List<TrelloListDto> lists) {
        return lists.stream()
                .map(tl -> new TrelloList(tl.getId(), tl.getName(), tl.isClosed()))
                .collect(toList());
    }
    //checked
    public List<TrelloBoard> mapToBoards(List<TrelloBoardDto> trelloBoardsDto) {
        return trelloBoardsDto.stream()
                .map(trelloBoardDto -> new TrelloBoard( trelloBoardDto.getName(), trelloBoardDto.getId(),mapToList(trelloBoardDto.getLists())))
                .collect(toList());
    }
//checked
    public List<TrelloBoardDto> mapToBoardsDto(List<TrelloBoard> trelloBoards) {
        return trelloBoards.stream()
                .map(trelloBoard -> new TrelloBoardDto(trelloBoard.getName(),trelloBoard.getId(), mapToListDto(trelloBoard.getLists())))
                .collect(toList());
    }
//checked
    public List<TrelloListDto> mapToListDto(final List<TrelloList> trelloLists) {
        return trelloLists.stream()
                .map(trelloList -> new TrelloListDto(trelloList.getId(), trelloList.getName(), trelloList.isClosed()))
                .collect(toList());
    }

    public TrelloCardDto mapToCardDto(TrelloCard trelloCard) {
        return new TrelloCardDto(trelloCard.getName(), trelloCard.getDescription(), trelloCard.getPos(), trelloCard.getListId());
    }

    public TrelloCard mapToCard(TrelloCardDto trelloCardDto) {
        return new TrelloCard(trelloCardDto.getName(), trelloCardDto.getDescription(), trelloCardDto.getPos(), trelloCardDto.getListId());
    }
}
