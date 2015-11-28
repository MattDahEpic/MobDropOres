package com.mattdahepic.mobdropores.config;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.config.Configuration;

public class OreGenConfigOption {
    public static final String COMMENT_ENABLED = "Spawns the ore if set to true, disables it if false.";
    public static final String COMMENT_VEIN_COUNT = "The number of veins the game will attempt to spawn per chunk.";
    public static final String COMMENT_VEIN_SIZE = "The size of veins that are spawned.";
    public static final String COMMENT_MIN_Y = "The lowest level veins can spawn at.";
    public static final String COMMENT_MAX_Y = "The highest level veins can spawn at.";
    public static final String COMMENT_RARITY = "Only one in this many veins will spawn. Set to 1 for no chance of failure.";

    public static final int VEIN_COUNT_MIN = 0;
    public static final int VEIN_COUNT_MAX = 1000;
    public static final int VEIN_SIZE_MIN = 0;
    public static final int VEIN_SIZE_MAX = 1000;
    public static final int Y_MIN = 0;
    public static final int Y_MAX = 255;
    public static final int RARITY_MIN = 1;
    public static final int RARITY_MAX = 1000;

    public boolean enabled = true;
    public int veinAmount = 1;
    public int veinSize = 8;
    public int minY = 0;
    public int maxY = 128;
    public int rarity = 1;
    public IBlockState block;

    public OreGenConfigOption (Block ore) {
        this.block = ore.getDefaultState();
    }
    public OreGenConfigOption loadValue (Configuration config, String category) {
        enabled = config.get(category,"Enabled",enabled,COMMENT_ENABLED).getBoolean();
        veinAmount = config.get(category,"VeinAmount",veinAmount,COMMENT_VEIN_COUNT).getInt();
        veinSize = config.get(category,"VeinSize",veinSize,COMMENT_VEIN_SIZE).getInt();
        minY = config.get(category,"MinY",minY,COMMENT_MIN_Y).getInt();
        maxY  = config.get(category,"MaxY",maxY,COMMENT_MAX_Y).getInt();
        rarity = config.get(category,"Rarity",rarity,COMMENT_RARITY).getInt();
        return this.validate();
    }
    public OreGenConfigOption validate () {
        veinAmount = MathHelper.clamp_int(veinAmount,VEIN_COUNT_MIN,VEIN_COUNT_MAX);
        veinSize = MathHelper.clamp_int(veinSize,VEIN_SIZE_MIN,VEIN_SIZE_MAX);
        minY = MathHelper.clamp_int(minY,Y_MIN,Y_MAX);
        maxY = MathHelper.clamp_int(maxY,Y_MIN,Y_MAX);
        rarity = MathHelper.clamp_int(rarity,RARITY_MIN,RARITY_MAX);
        return this;
    }
}
