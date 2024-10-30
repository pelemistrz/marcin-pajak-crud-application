package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloMapperTest {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToBoard(){
        //given
        TrelloListDto trelloListDto1 = new TrelloListDto("14","zadanie 1",true);
        TrelloListDto trelloListDto2 = new TrelloListDto("15","zadanie 2",false);
        List<TrelloListDto> listOfTrellosListDto = new ArrayList<>();
        listOfTrellosListDto.add(trelloListDto1);
        listOfTrellosListDto.add(trelloListDto2);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("Kodilla","2",listOfTrellosListDto);
        //when
        TrelloBoard trelloBoard = trelloMapper.mapToBoard(trelloBoardDto);
        //then
        assertInstanceOf(TrelloBoard.class, trelloBoard);
        assertEquals(trelloBoard.getLists().get(0).getName(), trelloListDto1.getName());
        assertEquals(trelloBoard.getLists().get(1).getClass() , TrelloList.class);
        assertEquals(trelloBoard.getId(),trelloBoardDto.getId());
        assertEquals(trelloBoard.getName(), trelloBoardDto.getName());
    }
    @Test
    void testMapToList(){
        //given
        TrelloListDto trelloListDto1 = new TrelloListDto("14","zadanie 1",true);
        TrelloListDto trelloListDto2 = new TrelloListDto("15","zadanie 2",false);
        List<TrelloListDto> listOfTrellosListDto = new ArrayList<>();
        listOfTrellosListDto.add(trelloListDto1);
        listOfTrellosListDto.add(trelloListDto2);
        //when
        List<TrelloList> trelloLists = trelloMapper.mapToList(listOfTrellosListDto);
        //then
        assertEquals(trelloLists.get(0).getName(), trelloListDto1.getName());
        assertEquals(trelloLists.get(0).getClass() , TrelloList.class);
        assertEquals(trelloLists.get(0).getId(), listOfTrellosListDto.get(0).getId());
        assertThrows(IndexOutOfBoundsException.class,()->trelloLists.get(2));
    }

    @Test
    void testMapToBoards(){
        //given
        TrelloListDto trelloListDto1 = new TrelloListDto("14","zadanie 1",true);
        TrelloListDto trelloListDto2 = new TrelloListDto("15","zadanie 2",false);
        List<TrelloListDto> listOfTrellosListDto = new ArrayList<>();
        listOfTrellosListDto.add(trelloListDto1);
        listOfTrellosListDto.add(trelloListDto2);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("Kodilla","2",listOfTrellosListDto);
        TrelloListDto trelloListDto4 = new TrelloListDto("16","zadanie 1",true);
        TrelloListDto trelloListDto5 = new TrelloListDto("17","zadanie 2",false);
        List<TrelloListDto> listOfTrellosListDto2 = new ArrayList<>();
        listOfTrellosListDto.add(trelloListDto4);
        listOfTrellosListDto.add(trelloListDto5);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("Java","3",listOfTrellosListDto2);
        List<TrelloBoardDto> listBoardsDto = new ArrayList<>();
        listBoardsDto.add(trelloBoardDto1);
        listBoardsDto.add(trelloBoardDto2);
        //when
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(listBoardsDto);
        //then
        assertEquals(trelloBoards.get(0).getName(), trelloBoardDto1.getName());
        assertEquals(trelloBoards.get(0).getClass() , TrelloBoard.class);
        assertEquals(trelloBoards.get(1).getId(), listBoardsDto.get(1).getId());
        assertInstanceOf(TrelloBoard.class, trelloBoards.get(1));
    }
    @Test
    void testMapToBoardsDto(){
        //given
        TrelloList trelloList1 = new TrelloList("14","zadanie 1",true);
        TrelloList trelloList2 = new TrelloList("15","zadanie 2",false);
        List<TrelloList> listOfTrellosList = new ArrayList<>();
        listOfTrellosList.add(trelloList1);
        listOfTrellosList.add(trelloList2);
        TrelloBoard trelloBoard1 = new TrelloBoard("Kodilla","2",listOfTrellosList);
        TrelloList trelloList4 = new TrelloList("16","zadanie 1",true);
        TrelloList trelloList5 = new TrelloList("17","zadanie 2",false);
        List<TrelloList> listOfTrellosList2 = new ArrayList<>();
        listOfTrellosList.add(trelloList4);
        listOfTrellosList.add(trelloList5);
        TrelloBoard trelloBoard2 = new TrelloBoard("Java","3",listOfTrellosList2);
        List<TrelloBoard> listBoards = new ArrayList<>();
        listBoards.add(trelloBoard1);
        listBoards.add(trelloBoard2);
        //when
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(listBoards);
        //then
        assertEquals(trelloBoardsDto.get(0).getName(), trelloBoard1.getName());
        assertEquals(trelloBoardsDto.get(0).getClass() , TrelloBoardDto.class);
        assertEquals(trelloBoardsDto.get(1).getId(), listBoards.get(1).getId());
        assertEquals(TrelloListDto.class,trelloBoardsDto.get(0).getLists().get(0).getClass());
        assertInstanceOf(TrelloBoardDto.class, trelloBoardsDto.get(1));
    }
    @Test
    void testMapToListDto(){
        //given
        TrelloList trelloList1 = new TrelloList("14","zadanie 1",true);
        TrelloList trelloList2 = new TrelloList("15","zadanie 2",false);
        List<TrelloList> listOfTrellosList = new ArrayList<>();
        listOfTrellosList.add(trelloList1);
        listOfTrellosList.add(trelloList2);
        //when
        List<TrelloListDto> trelloLists = trelloMapper.mapToListDto(listOfTrellosList);
        //then
        assertEquals(trelloLists.get(0).getName(), trelloList1.getName());
        assertEquals(trelloLists.get(0).getClass() , TrelloListDto.class);
        assertEquals(trelloLists.get(0).getId(), listOfTrellosList.get(0).getId());
    }
    @Test
    void testMapToCardDto(){
        //given
        TrelloCard trelloCard = new TrelloCard("Test","napisac testy","up","3");
        //when
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //then
        assertNotNull(trelloCardDto);
        assertEquals("Test", trelloCardDto.getName());
        assertEquals("napisac testy",trelloCardDto.getDescription());
        assertTrue(trelloCardDto instanceof TrelloCardDto);
        assertEquals(trelloCardDto.getClass(),TrelloCardDto.class);
    }
    @Test
    void testMapToCard(){
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test","napisac testy","up","3");
        //when
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //then
        assertNotNull(trelloCard);
        assertEquals("Test", trelloCard.getName());
        assertEquals("napisac testy",trelloCard.getDescription());
        assertTrue(trelloCard instanceof TrelloCard);
        assertEquals(trelloCard.getClass(),TrelloCard.class);

    }


}
