package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class HealCommand implements ActionCommand {
    private final ArenaFighter target;
    private final int healAmount;
    private int actualHealApplied;

    public HealCommand(ArenaFighter target, int healAmount) {
        this.target = target;
        this.healAmount = healAmount;
    }

    @Override
    public void execute() {
        actualHealApplied = 0;

        if (target.getHealPotions() <= 0) {
            return;
        }

        int missingHealth = target.getMaxHealth() - target.getHealth();
        if (missingHealth <= 0) {
            return;
        }

        actualHealApplied = Math.min(healAmount, missingHealth);
        target.heal(healAmount);
    }

    @Override
    public void undo() {
        if (actualHealApplied > 0) {
            target.takeDamage(actualHealApplied);
        }
    }

    @Override
    public String getDescription() {
        return "Heal for " + healAmount + " HP";
    }
}