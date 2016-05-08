package com.mattdahepic.mobdropores.block;

import com.google.common.collect.Maps;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class MobUtils {
    static final ItemStack ROTTEN_FLESH = new ItemStack(Items.ROTTEN_FLESH);
    static final ItemStack STRING = new ItemStack(Items.ROTTEN_FLESH);
    static final ItemStack GUNPOWDER = new ItemStack(Items.GUNPOWDER);
    static final ItemStack BLAZE_ROD = new ItemStack(Items.BLAZE_ROD);
    static final ItemStack ENDER_PEARL = new ItemStack(Items.ENDER_PEARL);
    static final ItemStack GHAST_TEAR = new ItemStack(Items.GHAST_TEAR);
    static final ItemStack PRIS_CRYS = new ItemStack(Items.PRISMARINE_CRYSTALS);
    static final ItemStack PRIS_SHARD = new ItemStack(Items.PRISMARINE_SHARD);
    static final ItemStack RAW_FISH = new ItemStack(Items.FISH);
    static final ItemStack BONE = new ItemStack(Items.BONE);
    static final ItemStack ARROW = new ItemStack(Items.ARROW);
    static final ItemStack SLIME_BALL = new ItemStack(Items.SLIME_BALL);
    static final ItemStack SPIDER_EYE = new ItemStack(Items.SPIDER_EYE);
    static final ItemStack GLASS_BOTT = new ItemStack(Items.GLASS_BOTTLE);
    static final ItemStack GLOW_DUST = new ItemStack(Items.GLOWSTONE_DUST);
    static final ItemStack REDSTONE = new ItemStack(Items.REDSTONE);
    static final ItemStack STICK = new ItemStack(Items.STICK);
    static final ItemStack SUGAR = new ItemStack(Items.SUGAR);
    static final ItemStack STAR = new ItemStack(Items.NETHER_STAR);
    static final ItemStack COAL = new ItemStack(Items.COAL);
    static final ItemStack WITHER_SKULL = new ItemStack(Items.SKULL,1,1);

    private static Map<Integer,EnumMob> META_TO_MOB = Maps.newHashMap();
    private static Map<EnumMob,Integer> MOB_TO_META = Maps.newHashMap();

    public static int metaFromMob (EnumMob mob) {
        return MOB_TO_META.get(mob);
    }
    public static EnumMob mobFromMeta (int meta) {
        return META_TO_MOB.get(meta);
    }
    static void setupMetaMaps (int meta, EnumMob mob) {
        META_TO_MOB.put(meta, mob);
        MOB_TO_META.put(mob, meta);
    }
}
