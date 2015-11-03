package com.mattdahepic.mobdropores.block;

import com.google.common.collect.Maps;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class MobUtils {
    public static final ItemStack ROTTEN_FLESH = new ItemStack(Items.rotten_flesh);
    public static final ItemStack STRING = new ItemStack(Items.string);
    public static final ItemStack GUNPOWDER = new ItemStack(Items.gunpowder);
    public static final ItemStack BLAZE_ROD = new ItemStack(Items.blaze_rod);
    public static final ItemStack ENDER_PEARL = new ItemStack(Items.ender_pearl);
    public static final ItemStack GHAST_TEAR = new ItemStack(Items.ghast_tear);
    public static final ItemStack PRIS_CRYS = new ItemStack(Items.prismarine_crystals);
    public static final ItemStack PRIS_SHARD = new ItemStack(Items.prismarine_shard);
    public static final ItemStack RAW_FISH = new ItemStack(Items.fish);
    public static final ItemStack BONE = new ItemStack(Items.bone);
    public static final ItemStack ARROW = new ItemStack(Items.arrow);
    public static final ItemStack SLIME_BALL = new ItemStack(Items.slime_ball);
    public static final ItemStack SPIDER_EYE = new ItemStack(Items.spider_eye);
    public static final ItemStack GLASS_BOTT = new ItemStack(Items.glass_bottle);
    public static final ItemStack GLOW_DUST = new ItemStack(Items.glowstone_dust);
    public static final ItemStack REDSTONE = new ItemStack(Items.redstone);
    public static final ItemStack STICK = new ItemStack(Items.stick);
    public static final ItemStack SUGAR = new ItemStack(Items.sugar);
    public static final ItemStack STAR = new ItemStack(Items.nether_star);
    public static final ItemStack COAL = new ItemStack(Items.coal);
    public static final ItemStack WITHER_SKULL = new ItemStack(Items.skull,1,1);

    private static Map<Integer,EnumMob> META_TO_MOB = Maps.newHashMap();
    private static Map<EnumMob,Integer> MOB_TO_META = Maps.newHashMap();

    public static int metaFromMob (EnumMob mob) {
        return MOB_TO_META.get(mob);
    }
    public static EnumMob mobFromMeta (int meta) {
        return META_TO_MOB.get(meta);
    }
    public static void setupMetaMaps (int meta, EnumMob mob) {
        META_TO_MOB.put(meta, mob);
        MOB_TO_META.put(mob, meta);
    }
}
