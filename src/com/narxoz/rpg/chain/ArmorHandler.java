package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class ArmorHandler extends DefenseHandler {
    private final int armorValue;

    public ArmorHandler(int armorValue) {
        this.armorValue = armorValue;
    }

    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        int remaining = Math.max(0, incomingDamage - armorValue);
        int absorbed = incomingDamage - remaining;

        System.out.println("[Armor] Absorbed " + absorbed + " damage.");
        passToNext(remaining, target);
    }
}