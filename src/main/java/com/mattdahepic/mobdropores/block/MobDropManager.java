package com.mattdahepic.mobdropores.block;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MobDropManager {
    public static List<ItemStack> getDrops (EnumMob mob, int fortune, Random rand) {
        List<ItemStack> ret = new ArrayList<>();
        ItemStackWithChance[] possiblities = mob.getDrops();
        for (ItemStackWithChance possible : possiblities) {
            ItemStack item = possible.getStack();
            float chance = possible.getChance();
            for (int i = 0; i < possible.getTries(); i++) {
                if (rand.nextFloat() <= chance) {
                    ret.add(item);
                }
            }
        }
        return ret;
    }
}
