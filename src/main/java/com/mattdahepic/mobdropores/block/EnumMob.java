package com.mattdahepic.mobdropores.block;

import net.minecraft.util.IStringSerializable;

public enum EnumMob implements IStringSerializable {
    ZOMBIE("zombie",1,new ItemStackWithChance(MobUtils.ROTTEN_FLESH,0.75F,2)),
    BLAZE("blaze",2,new ItemStackWithChance(MobUtils.BLAZE_ROD,0.5F,1)),
    CREEPER("creeper",1,new ItemStackWithChance(MobUtils.GUNPOWDER,0.75F,2)),
    ENDERMAN("enderman",2,new ItemStackWithChance(MobUtils.ENDER_PEARL,0.5F,1)),
    GHAST("ghast",2,new ItemStackWithChance(MobUtils.GHAST_TEAR,1.0F,1),new ItemStackWithChance(MobUtils.GUNPOWDER,0.5F,2)),
    GUARDIAN("guardian",2,new ItemStackWithChance(MobUtils.PRIS_CRYS,0.5F,1),new ItemStackWithChance(MobUtils.PRIS_SHARD,0.5F,2),new ItemStackWithChance(MobUtils.RAW_FISH,0.5F,1)),
    SKELETON("skeleton",1,new ItemStackWithChance(MobUtils.BONE,0.5F,2),new ItemStackWithChance(MobUtils.ARROW,0.5F,2)),
    SLIME("slime",1,new ItemStackWithChance(MobUtils.SLIME_BALL,0.5F,2)),
    SPIDER("spider",1,new ItemStackWithChance(MobUtils.STRING,0.5F,2),new ItemStackWithChance(MobUtils.SPIDER_EYE,0.5F,1)),
    WITCH("witch",2,new ItemStackWithChance(MobUtils.GLASS_BOTT,0.5F,1),new ItemStackWithChance(MobUtils.GLOW_DUST,0.5F,1),new ItemStackWithChance(MobUtils.GUNPOWDER,0.5F,1),new ItemStackWithChance(MobUtils.REDSTONE,0.5F,1),new ItemStackWithChance(MobUtils.SPIDER_EYE,0.5F,1),new ItemStackWithChance(MobUtils.STICK,0.5F,2),new ItemStackWithChance(MobUtils.SUGAR,0.5F,1)),
    WITHER("wither",3,new ItemStackWithChance(MobUtils.STAR,0.01F,1)),
    WITHER_SKELETON("wither_skeleton",2,new ItemStackWithChance(MobUtils.BONE,0.5F,2),new ItemStackWithChance(MobUtils.COAL,0.5F,2),new ItemStackWithChance(MobUtils.WITHER_SKULL,0.1F,1)),

    CHICKEN("chicken",1,new ItemStackWithChance(MobUtils.RAW_CHICKEN,1.0f,1),new ItemStackWithChance(MobUtils.FEATHER,0.5f,2)),
    COW("cow",1,new ItemStackWithChance(MobUtils.LEATHER,0.5f,2),new ItemStackWithChance(MobUtils.RAW_BEEF,0.75f,3)),
    PIG("pig",1,new ItemStackWithChance(MobUtils.RAW_PORKCHOP,0.75f,3)),
    SHEEP("sheep",1,new ItemStackWithChance(MobUtils.WOOL,1.0f,1),new ItemStackWithChance(MobUtils.RAW_MUTTON,0.75f,2)),
    RABBIT("rabbit",1,new ItemStackWithChance(MobUtils.RAW_RABBIT,0.5f,1),new ItemStackWithChance(MobUtils.RABBIT_HIDE,0.5f,1), new ItemStackWithChance(MobUtils.RABBIT_FOOT,0.1f,1)),
    SQUID("squid",0,new ItemStackWithChance(MobUtils.INK_SAC,0.5f,3));

    private final String name;
    private final ItemStackWithChance[] drops;
    private final int harvestLevel;
    EnumMob (String name, int harvestLevel,ItemStackWithChance... drops) {
        this.name = name;
        this.drops = drops;
        this.harvestLevel = harvestLevel;
        MobUtils.setupMetaMaps(ordinal(),this);
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
}
