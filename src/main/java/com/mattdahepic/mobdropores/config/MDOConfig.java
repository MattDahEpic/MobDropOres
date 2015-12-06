package com.mattdahepic.mobdropores.config;

import com.mattdahepic.mdecore.config.annot.Comment;
import com.mattdahepic.mdecore.config.annot.Config;
import com.mattdahepic.mdecore.config.annot.Range;
import com.mattdahepic.mdecore.config.sync.ConfigProcessor;
import com.mattdahepic.mdecore.config.sync.ConfigSyncable;

public class MDOConfig extends ConfigSyncable {
    @Config("zombie") @Comment({"The maximum size of a vein for zombie ore"}) @Range(min = 0, max = 255) public static int zombie_maxVeinSize = 6;
    @Config("zombie") @Comment({"How many veins of zombie ore to *try* and spawn per chunk"}) @Range(min = 0, max = 255) public static int zombie_spawnChances = 16;
    @Config("zombie") @Comment({"The lowest level a zombie ore can spawn at"}) @Range(min=0,max=255) public static int zombie_minY = 0;
    @Config("zombie") @Comment({"The highest level a zombe ore can spawn at"}) @Range(min = 0,max=255) public static int zombie_maxY = 64;

    @Config("blaze") @Comment({"The maximum size of a vein for blaze ore"}) @Range(min = 0, max = 255) public static int blaze_maxVeinSize = 4;
    @Config("blaze") @Comment({"How many veins of blaze ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int blaze_spawnChances = 2;
    @Config("blaze") @Comment({"The lowest level a blaze ore can spawn at"}) @Range(min = 0,max = 255) public static int blaze_minY = 0;
    @Config("blaze") @Comment({"The highest level a blaze ore can spawn at"}) @Range(min = 0,max = 255) public static int blaze_maxY = 128;

    @Config("creeper") @Comment({"The maximum size of a vein for creeper ore"}) @Range(min = 0,max = 255) public static int creeper_maxVeinSize = 5;
    @Config("creeper") @Comment({"How many veins of creeper ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int creeper_spawnChances = 8;
    @Config("creeper") @Comment({"The lowest level a creeper ore can spawn at"}) @Range(min = 0,max = 255) public static int creeper_minY = 0;
    @Config("creeper") @Comment({"The highest level a creeper ore can spawn at"}) @Range(min = 0,max = 255) public static int creeper_maxY = 64;

    @Config("enderman") @Comment({"The maximum size of a vein for enderman ore"}) @Range(min = 0,max = 255) public static int enderman_maxVeinSize = 3;
    @Config("enderman") @Comment({"How many veins of enderman ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int enderman_spawnChances = 4;
    @Config("enderman") @Comment({"The lowest level a enderman ore can spawn at"}) @Range(min = 0,max = 255) public static int enderman_minY = 0;
    @Config("enderman") @Comment({"The highest level a enderman ore can spawn at"}) @Range(min = 0,max = 255) public static int enderman_maxY = 75;

    @Config("ghast") @Comment({"The maximum size of a vein for ghast ore"}) @Range(min = 0,max = 255) public static int ghast_maxVeinSize = 3;
    @Config("ghast") @Comment({"How many veins of ghast ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int ghast_spawnChances = 3;
    @Config("ghast") @Comment({"The lowest level a ghast ore can spawn at"}) @Range(min = 0,max = 255) public static int ghast_minY = 0;
    @Config("ghast") @Comment({"The highest level a ghast ore can spawn at"}) @Range(min = 0,max = 255) public static int ghast_maxY = 128;

    @Config("guardian") @Comment({"The maximum size of a vein for guardian ore"}) @Range(min = 0,max = 255) public static int guardian_maxVeinSize = 4;
    @Config("guardian") @Comment({"How many veins of guardian ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int guardian_spawnChances = 3;
    @Config("guardian") @Comment({"The lowest level a guardian ore can spawn at"}) @Range(min = 0,max = 255) public static int guardian_minY = 0;
    @Config("guardian") @Comment({"The highest level a guardian ore can spawn at"}) @Range(min = 0,max = 255) public static int guardian_maxY = 64;

    @Config("skeleton") @Comment({"The maximum size of a vein for skeleton ore"}) @Range(min = 0,max = 255) public static int skeleton_maxVeinSize = 6;
    @Config("skeleton") @Comment({"How many veins of skeleton ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int skeleton_spawnChances = 6;
    @Config("skeleton") @Comment({"The lowest level a skeleton ore can spawn at"}) @Range(min = 0,max = 255) public static int skeleton_minY = 0;
    @Config("skeleton") @Comment({"The highest level a skeleton ore can spawn at"}) @Range(min = 0,max = 255) public static int skeleton_maxY = 64;

    @Config("slime") @Comment({"The maximum size of a vein for slime ore"}) @Range(min = 0,max = 255) public static int slime_maxVeinSize = 4;
    @Config("slime") @Comment({"How many veins of slime ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int slime_spawnChances = 6;
    @Config("slime") @Comment({"The lowest level a slime ore can spawn at"}) @Range(min = 0,max = 255) public static int slime_minY = 16;
    @Config("slime") @Comment({"The highest level a slime ore can spawn at"}) @Range(min = 0,max = 255) public static int slime_maxY = 24;

    @Config("spider") @Comment({"The maximum size of a vein for spider ore"}) @Range(min = 0,max = 255) public static int spider_maxVeinSize = 5;
    @Config("spider") @Comment({"How many veins of spider ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int spider_spawnChances = 4;
    @Config("spider") @Comment({"The lowest level a spider ore can spawn at"}) @Range(min = 0,max = 255) public static int spider_minY = 0;
    @Config("spider") @Comment({"The highest level a spider ore can spawn at"}) @Range(min = 0,max = 255) public static int spider_maxY = 64;

    @Config("witch") @Comment({"The maximum size of a vein for witch ore"}) @Range(min = 0,max = 255) public static int witch_maxVeinSize = 3;
    @Config("witch") @Comment({"How many veins of witch ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int witch_spawnChances = 5;
    @Config("witch") @Comment({"The lowest level a witch ore can spawn at"}) @Range(min = 0,max = 255) public static int witch_minY = 0;
    @Config("witch") @Comment({"The highest level a witch ore can spawn at"}) @Range(min = 0,max = 255) public static int witch_maxY = 64;

    @Config("wither") @Comment({"The maximum size of a vein for wither ore"}) @Range(min = 0,max = 255) public static int wither_maxVeinSize = 1;
    @Config("wither") @Comment({"How many veins of wither ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int wither_spawnChances = 1;
    @Config("wither") @Comment({"The lowest level a wither ore can spawn at"}) @Range(min = 0,max = 255) public static int wither_minY = 0;
    @Config("wither") @Comment({"The highest level a wither ore can spawn at"}) @Range(min = 0,max = 255) public static int wither_maxY = 10;

    @Config("wither_skeleton") @Comment({"The maximum size of a vein for wither skeleton ore"}) @Range(min = 0,max = 255) public static int wither_skeleton_maxVeinSize = 1;
    @Config("wither_skeleton") @Comment({"How many veins of wither skeleton ore to *try* and spawn per chunk"}) @Range(min = 0,max = 255) public static int wither_skeleton_spawnChances = 2;
    @Config("wither_skeleton") @Comment({"The lowest level a wither skeleton ore can spawn at"}) @Range(min = 0,max = 255) public static int wither_skeleton_minY = 0;
    @Config("wither_skeleton") @Comment({"The highest level a wither skeleton ore can spawn at"}) @Range(min = 0,max = 255) public static int wither_skeleton_maxY = 32;

    private static ConfigSyncable INSTANCE;
    public static ConfigSyncable instance(String configName) {
        if (INSTANCE == null) {
            INSTANCE = new MDOConfig(configName);
        }
        return INSTANCE;
    }
    public static ConfigProcessor processor;

    protected MDOConfig(String configName) {
        super(configName);
    }
    @Override
    public void init() {
        addSection("zombie");
        addSection("blaze");
        addSection("creeper");
        addSection("enderman");
        addSection("ghast");
        addSection("guardian");
        addSection("skeleton");
        addSection("slime");
        addSection("spider");
        addSection("witch");
        addSection("wither");
        addSection("wither_skeleton");
        processor = new ConfigProcessor(getClass(), this.config, this.configFileName);
        processor.process(true);
    }
    @Override
    protected void reloadIngameConfigs() {}
    @Override
    protected void reloadNonIngameConfigs() {}
    @Override
    public String getConfigName() {
        return this.configFileName;
    }
}
