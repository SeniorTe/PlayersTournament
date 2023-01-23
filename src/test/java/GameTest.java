import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.playertournament.domain.Player;
import ru.netology.ticketsearchservice.manager.Game;
import ru.netology.ticketsearchservice.manager.NotRegisteredException;

public class GameTest {

    Game manager = new Game();

    Player player1 = new Player(
            1,
            "Sergey",
            1150
    );

    Player player2 = new Player(
            1,
            "Kolya",
            320
    );

    Player player3 = new Player(
            1,
            "Olya",
            20
    );

    Player player4 = new Player(
            1,
            "Max",
            320
    );

    @Test

    public void shouldReturnOneFirstPlayerWin() {

        manager.register(player1);
        manager.register(player2);

        int expected = 1;
        int actual = manager.round("Sergey", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldReturnMinusOneSecondPlayerWin() {

        manager.register(player3);
        manager.register(player4);

        int expected = -1;
        int actual = manager.round("Olya", "Max");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldReturnZeroDraw() {

        manager.register(player2);
        manager.register(player4);

        int expected = 0;
        int actual = manager.round("Kolya", "Max");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldReturnNotRegisteredExceptionFirstPlayer() {

        manager.register(player1);
        manager.register(player2);
        manager.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Max", "Sergey");
        });
    }

    @Test

    public void shouldReturnNotRegisteredExceptionSecondPlayer() {

        manager.register(player1);
        manager.register(player2);
        manager.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Sergey", "Max");
        });
    }
}
