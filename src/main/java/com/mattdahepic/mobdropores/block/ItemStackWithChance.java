package com.mattdahepic.mobdropores.block;

import net.minecraft.item.ItemStack;

public class ItemStackWithChance {
    private final ItemStack stack;
    private final float chance;
    private final int tries;
    public ItemStackWithChance(ItemStack stack, float chance, int tries) {
        this.stack = stack;
        this.chance = chance;
        this.tries = tries;
    }
    public ItemStack getStack () {
        return stack;
    }
    public float getChance () {
        return chance;
    }
    public int getTries () {
        return tries;
    }
}
