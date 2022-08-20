package com.mirac.producterChallenge.entity;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static com.mirac.producterChallenge.entity.Position.PowerForward;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = Player.class)
public class PlayerTest {

    Player testPlayer = new Player();

    String TEST_NAME = "PRODUCTER";
    String TEST_SURNAME = "PRODUCTER";
    Position TEST_POSITION = PowerForward;

    @BeforeAll
    public void createTestPlayer(){
        testPlayer.setName(TEST_NAME);
        testPlayer.setSurname(TEST_SURNAME);
        testPlayer.setPosition(TEST_POSITION);
        testPlayer.setCreatedAt(new Date());
    }

    @Test
    void testCreatePlayer() {
        assertEquals(testPlayer.getName(),TEST_NAME);
        assertEquals(testPlayer.getName(),TEST_SURNAME);
        assertEquals(testPlayer.getPosition(),TEST_POSITION);
        assertNotNull(testPlayer.getCreatedAt());
        assertNull(testPlayer.getId());

    }

}
