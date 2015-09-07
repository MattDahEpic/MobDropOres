package com.mattdahepic.mobdropores.block;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import java.util.HashMap;
import java.util.Map;

public enum EnumMob implements IStringSerializable {
    ZOMBIE("zombie",0,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.ROTTEN_FLESH,0.5F,2)}),
    BLAZE("blaze",1,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.BLAZE_ROD,0.5F,1)}),
    CREEPER("creeper",2,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.GUNPOWDER,0.5F,2)}),
    ENDERMAN("enderman",3,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.ENDER_PEARL,0.5F,1)}),
    GHAST("ghast",4,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.GHAST_TEAR,1.0F,1),new ItemStackWithChance(MobUtils.GUNPOWDER,0.5F,2)}),
    GUARDIAN("guardian",5,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.PRIS_CRYS,0.5F,1),new ItemStackWithChance(MobUtils.PRIS_SHARD,0.5F,2),new ItemStackWithChance(MobUtils.RAW_FISH,0.5F,1)}),
    SKELETON("skeleton",6,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.BONE,0.5F,2),new ItemStackWithChance(MobUtils.ARROW,0.5F,2)}),
    SLIME("slime",7,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.SLIME_BALL,0.5F,2)}),
    SPIDER("spider",8,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.STRING,0.5F,2),new ItemStackWithChance(MobUtils.SPIDER_EYE,0.5F,1)}),
    WITCH("witch",9,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.GLASS_BOTT,0.5F,1),new ItemStackWithChance(MobUtils.GLOW_DUST,0.5F,1),new ItemStackWithChance(MobUtils.GUNPOWDER,0.5F,1),new ItemStackWithChance(MobUtils.REDSTONE,0.5F,1),new ItemStackWithChance(MobUtils.SPIDER_EYE,0.5F,1),new ItemStackWithChance(MobUtils.STICK,0.5F,2),new ItemStackWithChance(MobUtils.SUGAR,0.5F,1)}),
    WITHER("wither",10,new ItemStackWithChance[]{new ItemStackWithChance(MobUtils.STAR,0.01F,1)});

    private final String name;
    private final ItemStackWithChance[] drops;
    EnumMob (String name, int meta, ItemStackWithChance[] drops) {
        this.name = name;
        this.drops = drops;
        MobUtils.setupMetaMaps(meta,this);
    }
    public ItemStackWithChance[] getDrops () {
        return drops;
    }
    public String getName() {
        return name;
    }
}
