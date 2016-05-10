package com.mattdahepic.mobdropores.config;

import com.mattdahepic.mdecore.config.sync.Config;
import com.mattdahepic.mdecore.config.sync.ConfigSyncable;
import com.mattdahepic.mobdropores.MobDropOres;

public class MDOConfig extends ConfigSyncable {
    public String getConfigVersion () {return "1";}
    public String getConfigName () {return MobDropOres.MODID;}
    public Class getConfigClass () {return getClass();}

    @Config(cat = "zombie",comment = "The maximum size of a vein for zombie ore",range = @Config.Range(min = 0,max = 255)) public static int zombie_maxVeinSize = 6;
    @Config(cat = "zombie",comment = "How many veins of zombie ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int zombie_spawnChances = 16;
    @Config(cat = "zombie",comment = "The lowest level a zombie ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int zombie_minY = 0;
    @Config(cat = "zombie",comment = "The highest level a zombe ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int zombie_maxY = 64;

    @Config(cat = "blaze",comment = "The maximum size of a vein for blaze ore",range = @Config.Range(min = 0, max = 255)) public static int blaze_maxVeinSize = 4;
    @Config(cat = "blaze",comment = "How many veins of blaze ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int blaze_spawnChances = 2;
    @Config(cat = "blaze",comment = "The lowest level a blaze ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int blaze_minY = 0;
    @Config(cat = "blaze",comment = "The highest level a blaze ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int blaze_maxY = 128;

    @Config(cat = "creeper",comment = "The maximum size of a vein for creeper ore",range = @Config.Range(min = 0,max = 255)) public static int creeper_maxVeinSize = 5;
    @Config(cat = "creeper",comment = "How many veins of creeper ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int creeper_spawnChances = 8;
    @Config(cat = "creeper",comment = "The lowest level a creeper ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int creeper_minY = 0;
    @Config(cat = "creeper",comment = "The highest level a creeper ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int creeper_maxY = 64;

    @Config(cat = "enderman",comment = "The maximum size of a vein for enderman ore",range = @Config.Range(min = 0,max = 255)) public static int enderman_maxVeinSize = 3;
    @Config(cat = "enderman",comment = "How many veins of enderman ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int enderman_spawnChances = 4;
    @Config(cat = "enderman",comment = "The lowest level a enderman ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int enderman_minY = 0;
    @Config(cat = "enderman",comment = "The highest level a enderman ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int enderman_maxY = 75;

    @Config(cat = "ghast",comment = "The maximum size of a vein for ghast ore",range = @Config.Range(min = 0,max = 255)) public static int ghast_maxVeinSize = 3;
    @Config(cat = "ghast",comment = "How many veins of ghast ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int ghast_spawnChances = 3;
    @Config(cat = "ghast",comment = "The lowest level a ghast ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int ghast_minY = 0;
    @Config(cat = "ghast",comment = "The highest level a ghast ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int ghast_maxY = 128;

    @Config(cat = "guardian",comment = "The maximum size of a vein for guardian ore",range = @Config.Range(min = 0,max = 255)) public static int guardian_maxVeinSize = 4;
    @Config(cat = "guardian",comment = "How many veins of guardian ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int guardian_spawnChances = 3;
    @Config(cat = "guardian",comment = "The lowest level a guardian ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int guardian_minY = 0;
    @Config(cat = "guardian",comment = "The highest level a guardian ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int guardian_maxY = 64;

    @Config(cat = "skeleton",comment = "The maximum size of a vein for skeleton ore",range = @Config.Range(min = 0,max = 255)) public static int skeleton_maxVeinSize = 6;
    @Config(cat = "skeleton",comment = "How many veins of skeleton ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int skeleton_spawnChances = 6;
    @Config(cat = "skeleton",comment = "The lowest level a skeleton ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int skeleton_minY = 0;
    @Config(cat = "skeleton",comment = "The highest level a skeleton ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int skeleton_maxY = 64;

    @Config(cat = "slime",comment = "The maximum size of a vein for slime ore",range = @Config.Range(min = 0,max = 255)) public static int slime_maxVeinSize = 4;
    @Config(cat = "slime",comment = "How many veins of slime ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int slime_spawnChances = 6;
    @Config(cat = "slime",comment = "The lowest level a slime ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int slime_minY = 16;
    @Config(cat = "slime",comment = "The highest level a slime ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int slime_maxY = 24;

    @Config(cat = "spider",comment = "The maximum size of a vein for spider ore",range = @Config.Range(min = 0,max = 255)) public static int spider_maxVeinSize = 5;
    @Config(cat = "spider",comment = "How many veins of spider ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int spider_spawnChances = 4;
    @Config(cat = "spider",comment = "The lowest level a spider ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int spider_minY = 0;
    @Config(cat = "spider",comment = "The highest level a spider ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int spider_maxY = 64;

    @Config(cat = "witch",comment = "The maximum size of a vein for witch ore",range = @Config.Range(min = 0,max = 255)) public static int witch_maxVeinSize = 3;
    @Config(cat = "witch",comment = "How many veins of witch ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int witch_spawnChances = 5;
    @Config(cat = "witch",comment = "The lowest level a witch ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int witch_minY = 0;
    @Config(cat = "witch",comment = "The highest level a witch ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int witch_maxY = 64;

    @Config(cat = "wither",comment = "The maximum size of a vein for wither ore",range = @Config.Range(min = 0,max = 255)) public static int wither_maxVeinSize = 1;
    @Config(cat = "wither",comment = "How many veins of wither ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int wither_spawnChances = 1;
    @Config(cat = "wither",comment = "The lowest level a wither ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int wither_minY = 0;
    @Config(cat = "wither",comment = "The highest level a wither ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int wither_maxY = 10;

    @Config(cat = "wither_skeleton",comment = "The maximum size of a vein for wither skeleton ore",range = @Config.Range(min = 0,max = 255)) public static int wither_skeleton_maxVeinSize = 1;
    @Config(cat = "wither_skeleton",comment = "How many veins of wither skeleton ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int wither_skeleton_spawnChances = 2;
    @Config(cat = "wither_skeleton",comment = "The lowest level a wither skeleton ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int wither_skeleton_minY = 0;
    @Config(cat = "wither_skeleton",comment = "The highest level a wither skeleton ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int wither_skeleton_maxY = 32;

    @Config(cat = "chicken",comment = "The maximum size of a vein for chicken ore",range = @Config.Range(min = 0,max = 255)) public static int chicken_maxVeinSize = 3;
    @Config(cat = "chicken",comment = "How many veins of chicken ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int chicken_spawnChances = 2;
    @Config(cat = "chicken",comment = "The lowest level a chicken ore to spawn at",range = @Config.Range(min = 0,max = 255)) public static int chicken_minY = 32;
    @Config(cat = "chicken",comment = "The highest level a chicken ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int chicken_maxY = 128;

    @Config(cat = "cow",comment = "The maximum size of a vein for cow ore",range = @Config.Range(min = 0,max = 255)) public static int cow_maxVeinSize = 3;
    @Config(cat = "cow",comment = "How many veins of cow ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int cow_spawnChances = 2;
    @Config(cat = "cow",comment = "The lowest level a cow ore to spawn at",range = @Config.Range(min = 0,max = 255)) public static int cow_minY = 32;
    @Config(cat = "cow",comment = "The highest level a cow ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int cow_maxY = 128;

    @Config(cat = "pig",comment = "The maximum size of a vein for pig ore",range = @Config.Range(min = 0,max = 255)) public static int pig_maxVeinSize = 3;
    @Config(cat = "pig",comment = "How many veins of pig ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int pig_spawnChances = 2;
    @Config(cat = "pig",comment = "The lowest level a pig ore to spawn at",range = @Config.Range(min = 0,max = 255)) public static int pig_minY = 32;
    @Config(cat = "pig",comment = "The highest level a pig ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int pig_maxY = 128;

    @Config(cat = "sheep",comment = "The maximum size of a vein for sheep ore",range = @Config.Range(min = 0,max = 255)) public static int sheep_maxVeinSize = 3;
    @Config(cat = "sheep",comment = "How many veins of sheep ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int sheep_spawnChances = 2;
    @Config(cat = "sheep",comment = "The lowest level a sheep ore to spawn at",range = @Config.Range(min = 0,max = 255)) public static int sheep_minY = 32;
    @Config(cat = "sheep",comment = "The highest level a sheep ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int sheep_maxY = 128;

    @Config(cat = "rabbit",comment = "The maximum size of a vein for rabbit ore",range = @Config.Range(min = 0,max = 255)) public static int rabbit_maxVeinSize = 3;
    @Config(cat = "rabbit",comment = "How many veins of rabbit ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int rabbit_spawnChances = 2;
    @Config(cat = "rabbit",comment = "The lowest level a rabbit ore to spawn at",range = @Config.Range(min = 0,max = 255)) public static int rabbit_minY = 32;
    @Config(cat = "rabbit",comment = "The highest level a rabbit ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int rabbit_maxY = 128;

    @Config(cat = "squid",comment = "The maximum size of a vein for squid ore",range = @Config.Range(min = 0,max = 255)) public static int squid_maxVeinSize = 3;
    @Config(cat = "squid",comment = "How many veins of squid ore to *try* and spawn per chunk",range = @Config.Range(min = 0,max = 255)) public static int squid_spawnChances = 2;
    @Config(cat = "squid",comment = "The lowest level a squid ore to spawn at",range = @Config.Range(min = 0,max = 255)) public static int squid_minY = 32;
    @Config(cat = "squid",comment = "The highest level a squid ore can spawn at",range = @Config.Range(min = 0,max = 255)) public static int squid_maxY = 128;
}
