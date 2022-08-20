package com.mirac.producterChallenge.dto;

import com.mirac.producterChallenge.entity.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static com.mirac.producterChallenge.entity.Position.PowerForward;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = PlayerDto.class)
public class PlayerDtoTest {

    PlayerDto testPlayer = new PlayerDto();

    String TEST_NAME = "PRODUCTER";
    String TEST_SURNAME = "PRODUCTER";
    Position TEST_POSITION = PowerForward;

    @BeforeAll
    public void createTestPlayer(){
        testPlayer.setName(TEST_NAME);
        testPlayer.setSurname(TEST_SURNAME);
        testPlayer.setPosition(TEST_POSITION);

    }

    @Test
    void testCreatePlayerWithId() {
        assertEquals(testPlayer.getName(),TEST_NAME);
        assertEquals(testPlayer.getName(),TEST_SURNAME);
        assertEquals(testPlayer.getPosition(),TEST_POSITION);

    }

}
