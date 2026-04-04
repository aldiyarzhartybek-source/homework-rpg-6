package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class DefendCommand implements ActionCommand {
    private final ArenaFighter target;
    private final double dodgeBoost;

    public DefendCommand(ArenaFighter target, double dodgeBoost) {
        this.target = target;
        this.dodgeBoost = dodgeBoost;
    }

    @Override
    public void execute() {
        target.modifyDodgeChance(dodgeBoost);
    }

    @Override
    public void undo() {
        target.modifyDodgeChance(-dodgeBoost);
    }

    @Override
    public String getDescription() {
        return String.format("Defend (dodge boost: +%.2f)", dodgeBoost);
    }
}