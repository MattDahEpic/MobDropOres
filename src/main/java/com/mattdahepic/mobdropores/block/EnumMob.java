package com.mattdahepic.mobdropores.block;

import com.google.common.collect.Maps;
import com.mattdahepic.mobdropores.MobDropOres;
import net.minecraft.block.Block;
import net.minecraft.util.IStringSerializable;

import java.util.Map;

public enum EnumMob implements IStringSerializable {
    ZOMBIE(1,new ItemStackWithChance(MobUtils.ROTTEN_FLESH,0.75F,2)),
    BLAZE(2,new ItemStackWithChance(MobUtils.BLAZE_ROD,0.5F,1)),
    CREEPER(1,new ItemStackWithChance(MobUtils.GUNPOWDER,0.75F,2)),
    ENDERMAN(2,new ItemStackWithChance(MobUtils.ENDER_PEARL,0.5F,1)),
    GHAST(2,new ItemStackWithChance(MobUtils.GHAST_TEAR,1.0F,1),new ItemStackWithChance(MobUtils.GUNPOWDER,0.5F,2)),
    GUARDIAN(2,new ItemStackWithChance(MobUtils.PRIS_CRYS,0.5F,1),new ItemStackWithChance(MobUtils.PRIS_SHARD,0.5F,2),new ItemStackWithChance(MobUtils.RAW_FISH,0.5F,1)),
    SKELETON(1,new ItemStackWithChance(MobUtils.BONE,0.5F,2),new ItemStackWithChance(MobUtils.ARROW,0.5F,2)),
    SLIME(1,new ItemStackWithChance(MobUtils.SLIME_BALL,0.5F,2)),
    SPIDER(1,new ItemStackWithChance(MobUtils.STRING,0.5F,2),new ItemStackWithChance(MobUtils.SPIDER_EYE,0.5F,1)),
    WITCH(2,new ItemStackWithChance(MobUtils.GLASS_BOTT,0.5F,1),new ItemStackWithChance(MobUtils.GLOW_DUST,0.5F,1),new ItemStackWithChance(MobUtils.GUNPOWDER,0.5F,1),new ItemStackWithChance(MobUtils.REDSTONE,0.5F,1),new ItemStackWithChance(MobUtils.SPIDER_EYE,0.5F,1),new ItemStackWithChance(MobUtils.STICK,0.5F,2),new ItemStackWithChance(MobUtils.SUGAR,0.5F,1)),
    WITHER(3,new ItemStackWithChance(MobUtils.STAR,0.01F,1)),
    WITHER_SKELETON(2,new ItemStackWithChance(MobUtils.BONE,0.5F,2),new ItemStackWithChance(MobUtils.COAL,0.5F,2),new ItemStackWithChance(MobUtils.WITHER_SKULL,0.1F,1)),

    CHICKEN(1,new ItemStackWithChance(MobUtils.RAW_CHICKEN,1.0f,1),new ItemStackWithChance(MobUtils.FEATHER,0.5f,2)),
    COW(1,new ItemStackWithChance(MobUtils.LEATHER,0.5f,2),new ItemStackWithChance(MobUtils.RAW_BEEF,0.75f,3)),
    PIG(1,new ItemStackWithChance(MobUtils.RAW_PORKCHOP,0.75f,3)),
    SHEEP(1,new ItemStackWithChance(MobUtils.WOOL,1.0f,1),new ItemStackWithChance(MobUtils.RAW_MUTTON,0.75f,2)),
    RABBIT(1,new ItemStackWithChance(MobUtils.RAW_RABBIT,0.5f,1),new ItemStackWithChance(MobUtils.RABBIT_HIDE,0.5f,1), new ItemStackWithChance(MobUtils.RABBIT_FOOT,0.1f,1)),
    SQUID(0,new ItemStackWithChance(MobUtils.INK_SAC,0.5f,3));

    public static Map<Integer,EnumMob> META_TO_MOB;

    private final String name;
    private final ItemStackWithChance[] drops;
    private final int harvestLevel;
    EnumMob (int harvestLevel,ItemStackWithChance... drops) {
        this.name = name().toLowerCase();
        this.drops = drops;
        this.harvestLevel = harvestLevel;
        setupMobMap(ordinal(),this);
    }

    public ItemStackWithChance[] getDrops () {
        return drops;
    }
    public String getName() {
        return name;
    }
    public int getHarvestLevel () {
        return harvestLevel;
    }
    public Block getBlock () {
        return MobDropOres.mob_ores.get(ordinal()/16);
    }
    public int getMeta () {
        return ordinal()%16;
    }

    private static void setupMobMap (int id, EnumMob mob) {
        if (META_TO_MOB == null) META_TO_MOB = Maps.newHashMap();
        META_TO_MOB.put(id,mob);
    }
}
