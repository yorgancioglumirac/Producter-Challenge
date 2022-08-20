package com.mirac.producterChallenge.service;

import com.mirac.producterChallenge.dto.PlayerDto;
import com.mirac.producterChallenge.entity.Player;
import com.mirac.producterChallenge.entity.Position;
import com.mirac.producterChallenge.repos.PlayerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mirac.producterChallenge.entity.Position.PowerForward;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = PlayerService.class)
public class PlayerServiceTest {

    @MockBean
    PlayerRepository playerRepository;

    @MockBean
    PlayerService playerServiceMock;

    @Autowired
    PlayerService playerService;

    PlayerDto testPlayerDto = new PlayerDto();
    String TEST_NAME = "PRODUCTER";
    String TEST_SURNAME = "PRODUCTER";
    Position TEST_POSITION = PowerForward;

    Long TEST_ID = new Random().nextLong();

    ArrayList<Player> testPlayerList = new ArrayList<Player>();

    @BeforeAll
    public void createTestPlayer(){

        testPlayerDto.setName(TEST_NAME);
        testPlayerDto.setSurname(TEST_SURNAME);
        testPlayerDto.setPosition(TEST_POSITION);

    }

    @Test
    void testCanCreatePlayerWithDto() {
        Player testPlayer = new Player();
        testPlayer.setName("PRODUCTER");
        testPlayer.setSurname("PRODUCTER");
        testPlayer.setPosition(PowerForward);

        when(playerServiceMock.createPlayerFromDto(testPlayerDto)).thenReturn(testPlayer);
        assertEquals(testPlayer.getName(),TEST_NAME);
        assertEquals(testPlayer.getName(),TEST_SURNAME);
        assertEquals(testPlayer.getPosition(),TEST_POSITION);
        assertTrue(testPlayer instanceof Player);

    }


    @Test
    void testCanSavePlayer() {

        Player testPlayer = new Player();
        testPlayer.setName("PRODUCTER");
        testPlayer.setSurname("PRODUCTER");
        testPlayer.setPosition(PowerForward);
        when(playerServiceMock.savePlayer(testPlayer)).thenReturn(testPlayer);

        Player playerToSave = playerServiceMock.savePlayer(testPlayer);

        assertEquals(testPlayer.getName(), playerToSave.getName());
        assertEquals(testPlayer.getSurname(), playerToSave.getSurname());
        assertEquals(testPlayer.getPosition(), playerToSave.getPosition());

    }


    @Test
    void testCanDeletePlayerWithId() {
        Long TEST_ID = new Random().nextLong();
        Player testPlayer1 = new Player();
        testPlayer1.setName("Test1");
        testPlayer1.setSurname("TestSurname1");
        testPlayer1.setId(TEST_ID);
        testPlayerList.add(testPlayer1);

        Long returnId = 0L;

        for(int i = 0; i < testPlayerList.size(); i++){
            if(testPlayerList.get(i).getId() == TEST_ID){
                returnId = testPlayerList.remove(i).getId();
            }
        }
        when(playerServiceMock.deleteById(TEST_ID)).thenReturn(returnId);
        assertEquals(returnId,TEST_ID);
    }

    @Test
    void testCanFindAllPlayers() {
        Player testPlayer1 = new Player();
        Player testPlayer2 = new Player();
        Player testPlayer3 = new Player();
        testPlayerList.add(testPlayer1);
        testPlayerList.add(testPlayer2);
        testPlayerList.add(testPlayer3);

        when(playerRepository.findAll()).thenReturn(testPlayerList);
        List<Player> allPlayers = playerRepository.findAll();
        assertEquals(testPlayerList, allPlayers);
    }

}
