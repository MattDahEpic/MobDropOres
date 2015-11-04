package com.mattdahepic.mobdropores.block;

import net.minecraft.util.IStringSerializable;

public enum EnumMob implements IStringSerializable {
    ZOMBIE("zombie",0,1,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.ROTTEN_FLESH,0.75F,2)}),
    BLAZE("blaze",1,2,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.BLAZE_ROD,0.5F,1)}),
    CREEPER("creeper",2,1,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.GUNPOWDER,0.75F,2)}),
    ENDERMAN("enderman",3,2,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.ENDER_PEARL,0.5F,1)}),
    GHAST("ghast",4,2,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.GHAST_TEAR,1.0F,1),new ItemStackWithChance(MobUtils.GUNPOWDER,0.5F,2)}),
    GUARDIAN("guardian",5,2,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.PRIS_CRYS,0.5F,1),new ItemStackWithChance(MobUtils.PRIS_SHARD,0.5F,2),new ItemStackWithChance(MobUtils.RAW_FISH,0.5F,1)}),
    SKELETON("skeleton",6,1,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.BONE,0.5F,2),new ItemStackWithChance(MobUtils.ARROW,0.5F,2)}),
    SLIME("slime",7,1,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.SLIME_BALL,0.5F,2)}),
    SPIDER("spider",8,1,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.STRING,0.5F,2),new ItemStackWithChance(MobUtils.SPIDER_EYE,0.5F,1)}),
    WITCH("witch",9,2,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.GLASS_BOTT,0.5F,1),new ItemStackWithChance(MobUtils.GLOW_DUST,0.5F,1),new ItemStackWithChance(MobUtils.GUNPOWDER,0.5F,1),new ItemStackWithChance(MobUtils.REDSTONE,0.5F,1),new ItemStackWithChance(MobUtils.SPIDER_EYE,0.5F,1),new ItemStackWithChance(MobUtils.STICK,0.5F,2),new ItemStackWithChance(MobUtils.SUGAR,0.5F,1)}),
    WITHER("wither",10,3,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.STAR,0.01F,1)}),
    WITHER_SKELETON("wither_skeleton",11,2,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.BONE,0.5F,2),new ItemStackWithChance(MobUtils.COAL,0.5F,2),new ItemStackWithChance(MobUtils.WITHER_SKULL,0.1F,1)});

    private final String name;
    private final ItemStackWithChance[] drops;
    private final int harvestLevel;
    EnumMob (String name, int meta, int harvestLevel,ItemStackWithChance[] drops) {
        this.name = name;
        this.drops = drops;
        this.harvestLevel = harvestLevel;
        MobUtils.setupMetaMaps(meta,this);
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
