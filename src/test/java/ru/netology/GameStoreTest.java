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
    @Test
    public void shouldFindGamIfHashMapHasAFewAddedGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");

        assertTrue(store.containsGame(game2));
    }
    @Test
    public void shouldFalseIfCheckNoAddedGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("Нетология Баттл Онлайн 2","Аркады",store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldAddPlayTimeIfGameIsNew() {
        GameStore store = new GameStore();
        store.addPlayTime("John12",35);

        int expected = 35;
        int actual = store.getPlayedTime().get("John12");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldAddPlayTimeIfPlayerGamesAgain() {
        GameStore store = new GameStore();
        store.addPlayTime("John12",35);
        store.addPlayTime("John12",15);

        int expected = 50;
        int actual = store.getPlayedTime().get("John12");

        Assertions.assertEquals(expected,actual);

    }


    @Test
    public void shouldFindMostPlayerIfHashMapHasAFewPlayers() {
        GameStore store = new GameStore();
        store.addPlayTime("John12",50);
        store.addPlayTime("RickRick",25);
        store.addPlayTime("LanceWeek",26);

        String expected = "John12";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldFindMostPlayerIfHashMapHasOnlyOnePlayer() {
        GameStore store = new GameStore();
        store.addPlayTime("John12",50);

        String expected = "John12";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldFindMostPlayerIfHashMapHasAFewPlayersWithEqualHours() {
        GameStore store = new GameStore();
        store.addPlayTime("John12",50);
        store.addPlayTime("RickRick",50);
        store.addPlayTime("LanceWeek",26);

        String expected = "RickRick";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnNullBecauseHashMapDoesNotHavePlayers() {
        GameStore store = new GameStore();

        String expected = null;
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldSumPlayTimeIfHashMapHasAFewPlayers () {
        GameStore store = new GameStore();
        store.addPlayTime("John12",50);
        store.addPlayTime("RickRick",50);
        store.addPlayTime("LanceWeek",26);

        int expected = 126;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldSumPlayTimeIfHashMapHasOnlyOnePlayer () {
        GameStore store = new GameStore();
        store.addPlayTime("John12",35);
        store.addPlayTime("John12",15);

        int expected = 50;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnNullBecauseNoPlayers() {
        GameStore store = new GameStore();

        int expected = 0;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected,actual);
    }
}
