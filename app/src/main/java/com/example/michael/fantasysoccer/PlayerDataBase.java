package com.example.michael.fantasysoccer;

import com.example.michael.fantasysoccer.SoccerPlayer.Player;

import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by Michael on 9/24/2015.
 */
public class PlayerDataBase {
    protected Hashtable<String, Player> playerNames = new Hashtable();

    public boolean addPlayer(String firstName, String lastName, int playerNumber, String teamName) {


        if (playerNames.containsKey(playerToKey(firstName, lastName))) {
            return false;
        }


        //Player is not in database, so add them
        Player player = new Player(firstName, lastName, playerNumber, teamName);
        playerNames.put(playerToKey(firstName, lastName), player);

        return true;
    }

    public boolean removePlayer(String firstName, String lastName) {
        if (playerNames.containsKey(playerToKey(firstName, lastName))) {
            playerNames.remove(playerToKey(firstName, lastName));
            return true;
        }
        return false;
    }

    public Player getPlayer(String firstName, String lastName) {
        return playerNames.get(playerToKey(firstName, lastName));
    }

    public int numPlayers(String teamName) {

        if (teamName == null) {

            return playerNames.size();
        }
        else
        {
            int count = 0;
            Collection<Player> playersOfTeam = playerNames.values();
            for (Player player : playersOfTeam ){
                if ( player.getTeamName().equals(teamName)){
                    count++;
                }

            }
            return count;
        }


    }

    public HashSet<String> getTeams() {
        return new HashSet<String>();
    }


    private String playerToKey(String firstName, String lastName) {
        return firstName + "#" + lastName;
    }
}
