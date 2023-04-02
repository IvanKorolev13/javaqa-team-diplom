package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    //Ivan looks for bugs
    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfSomeGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Диплом", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);
        player.installGame(game2);
        player.play(game2, 10);

        int expected = 13;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfNoGameByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Диплом", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);
        player.installGame(game2);
        player.play(game1, 10);

        int expected = 0;
        int actual = player.sumGenre("Каскады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowErrorIfNoInstallGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(game, 2);
        });
    }

    @Test
    public void shouldAddExistGameForPlayer() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);
        player.play(game, 3);
        player.installGame(game);
        player.play(game, 10);

        int expected = 13;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowHoursIfFirstGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        int expected = 5;
        int actual = player.play(game, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowHoursIfRepeatedGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        player.play(game, 5);

        int expected = 15;
        int actual = player.play(game, 10);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMostPlayerByGenreIfNobodyPlayInGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    //не понятно по условию:
    // Метод принимает жанр и возвращает игру этого жанра, в которую играли больше всего
    //ИГРАЛИ- т.е. сумма часов по всем играм жанра (из HashMap playerTime
    //или сумма часов только по одному играку по его играм
    //уточнил у Филиппа- игрок говорит про себя.
    @Test
    public void shouldShowMostPlayerByGenreIfOneGameInGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Каскады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.play(game1, 7);
        player.play(game2, 6);

        Game expected = game2;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMostPlayerByGenreIfSomeGameInGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Диплом", "Аркады");

        Player player1 = new Player("Petya");
        player1.installGame(game1);
        player1.installGame(game2);
        player1.play(game1, 7);
        player1.play(game2, 6);

        Game expected = game1;
        Game actual = player1.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }
/*
    @Test
    public void shouldShowMostPlayerByGenreIfSomeGamesInGenreHaveMax() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Диплом", "Аркады");

        Player player1 = new Player("Petya");
        player1.installGame(game1);
        player1.play(game1, 5);
        player1.installGame(game2);
        player1.play(game2, 5);

        Game expected = game1;
        //тут не понятно какой результат должен быть, т.к. не указано что возвращается, если две и более игры имеют максимум
        //ответ Филиппа- любую
        Game actual = player1.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }
    //при дебаге тест проходит, если запускать без дебага и mvn- проваливается.
    //дебаг: expected = Game@1772 (game1),actual = Game@1772 (game1)
    //без дебага: expected = Game@2fdb9f70 ,actual = Game@679b1112
*/
    @Test
    public void shouldShowMostPlayerByGenreIfNoFindGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 2);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("Каскады");
        assertEquals(expected, actual);
    }
}
