package ru.netology.ticketsearchservice.manager;

import ru.netology.playertournament.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {

        int strengthPlayer1 = 0;
        int strengthPlayer2 = 0;

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "The player named" + playerName1 + "is not registered in the game"
            );
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "The player named" + playerName2 + "is not registered in the game"
            );
        } else {
            for (Player player : players) {
                if (player.getName() == playerName1) {
                    strengthPlayer1 = player.getStrength();
                }
            }
            for (Player player : players) {
                if (player.getName() == playerName2) {
                    strengthPlayer2 = player.getStrength();
                }
            }
            if (strengthPlayer1 > strengthPlayer2) {
                return 1;
            } else if (strengthPlayer1 < strengthPlayer2) {
                return -1;
            } else return 0;
        }

    }
}
