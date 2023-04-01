package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

// Тест от Вани
//    @Test
//    public void shouldNoAddGame() {
//
//        GameStore store = new GameStore();
//        Game game = new Game("Нетология Баттл Онлайн", "Аркады", store);
//
//        assertTrue(!store.containsGame(game));
//    }

//    @Test
//    public void shouldAddPlayTime() {
//        GameStore store = new GameStore();
//        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//        Game game2 = store.publishGame("Нетология Баттл 2 Онлайн", "Аркады");
//        Player player = new Player("John12");
//
//        store.addPlayTime("John12",333);
//
//        int expected = 351 ; // суммарное количество часов
//        int actual = store.getPlayedTime().get("John12");
//
//        Assertions.assertEquals(expected,actual);
//    }
//
//    @Test
//    public void shouldFindMostPlayer() {
//        GameStore store = new GameStore();
//        String player = store.addPlayTime("John12");
//        String player1 = store.addPlayTime("Rick");
//
//
//    }

//    @Test
//    public void shouldSumAllPlayerTime() {
//        GameStore store = new GameStore();
//        Game game = store.getSumPlayedTime()
//    }
}
