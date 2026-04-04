package com.narxoz.rpg.arena;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TournamentResult {
    private String winner;
    private int rounds;
    private final List<String> log = new ArrayList<>();

    public String getWinner() { return winner; }
    public void setWinner(String winner) { this.winner = winner; }

    public int getRounds() { return rounds; }
    public void setRounds(int rounds) { this.rounds = rounds; }

    public void addLine(String line) { log.add(line); }
    public List<String> getLog() { return Collections.unmodifiableList(log); }
}