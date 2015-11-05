package com.mattdahepic.mobdropores.config;

import net.minecraftforge.common.config.Configuration;

public class ConfigSectionMobOre {
    public int maxVeinSize;
    public int spawnChances;
    public int minY;
    public int maxY;

    public String SECTION_NAME;
    ConfigSectionMobOre (String mob_name,int maxVeinSize,int spawnChances,int minY, int maxY) {
        this.SECTION_NAME = mob_name;
        this.maxVeinSize = maxVeinSize;
        this.spawnChances = spawnChances;
        this.minY = minY;
        this.maxY = maxY;
    }
    public void load (Configuration c) {
        maxVeinSize = c.getInt("maxVeinSize",SECTION_NAME,maxVeinSize,0,255,"The maximum size of a vein for "+SECTION_NAME+" ore");
        spawnChances = c.getInt("spawnChances",SECTION_NAME,spawnChances,0,255,"How many veins of "+SECTION_NAME+" ore to *try* and spawn per chunk");
        minY = c.getInt("minY",SECTION_NAME,minY,0,255,"The lowest level a "+SECTION_NAME+" ore can spawn at");
        maxY = c.getInt("maxY",SECTION_NAME,maxY,0,255,"The highest level a "+SECTION_NAME+" ore can spawn at");
    }
}
