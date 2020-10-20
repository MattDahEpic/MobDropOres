package com.mattdahepic.mobdropores.common;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraftforge.common.ForgeConfigSpec;

import static net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType.*;
import static com.mattdahepic.mobdropores.common.config.MDOConfig.Common.*;

public enum EnumMob {
    //overworld hostile
    ZOMBIE(1,
            new ResourceLocation("minecraft","entities/zombie"),
            field_241882_a,
            zombie_veinSize,
            zombie_maxHeight,
            zombie_spawnChances
            ),
    CREEPER(1,
            new ResourceLocation("minecraft","entities/creeper"),
            field_241882_a,
            creeper_veinSize,
            creeper_maxHeight,
            creeper_spawnChances),
    ENDERMAN(2,
            new ResourceLocation("minecraft","entities/enderman"),
            field_241882_a,
            enderman_veinSize,
            enderman_maxHeight,
            enderman_spawnChances),
    GUARDIAN(2,
            new ResourceLocation("minecraft","entities/guardian"),
            field_241882_a,
            guardian_veinSize,
            guardian_maxHeight,
            guardian_spawnChances),
    SKELETON(1,
            new ResourceLocation("minecraft","entities/skeleton"),
            field_241882_a,
            skeleton_veinSize,
            skeleton_maxHeight,
            skeleton_spawnChances),
    SLIME(1,
            new ResourceLocation("minecraft","entities/slime"),
            field_241882_a,
            slime_veinSize,
            slime_maxHeight,
            slime_spawnChances),
    SPIDER(1,
            new ResourceLocation("minecraft","entities/spider"),
            field_241882_a,
            spider_veinSize,
            spider_maxHeight,
            spider_spawnChances),
    WITCH(2,
            new ResourceLocation("minecraft","entities/witch"),
            field_241882_a,
            witch_veinSize,
            witch_maxHeight,
            witch_spawnChances),
    WITHER(3,
            new ResourceLocation("mobdropores","nether_star"), //TODO change to vanilla loot table if nether star gets added
            field_241882_a,
            wither_veinSize,
            wither_maxHeight,
            wither_spawnChances),
    //overworld passive
    CHICKEN(1,
            new ResourceLocation("minecraft","entities/chicken"),
            field_241882_a,
            chicken_veinSize,
            chicken_maxHeight,
            chicken_spawnChances),
    COW(1,
            new ResourceLocation("minecraft","entities/cow"),
            field_241882_a,
            cow_veinSize,
            cow_maxHeight,
            cow_spawnChances),
    PIG(1,
            new ResourceLocation("minecraft","entities/pig"),
            field_241882_a,
            pig_veinSize,
            pig_maxHeight,
            pig_spawnChances),
    SHEEP(1,
            new ResourceLocation("minecraft","entities/sheep/white"),
            field_241882_a,
            sheep_veinSize,
            sheep_maxHeight,
            sheep_spawnChances),
    RABBIT(1,
            new ResourceLocation("minecraft","entities/rabbit"),
            field_241882_a,
            rabbit_veinSize,
            rabbit_maxHeight,
            rabbit_spawnChances),
    SQUID(0,
            new ResourceLocation("minecraft","entities/squid"),
            field_241882_a,
            squid_veinSize,
            squid_maxHeight,
            squid_spawnChances),
    //TODO TURTLE(),
    //TODO WANDERING_TRADER(),

    //nether hostile
    BLAZE(2,
            new ResourceLocation("minecraft","entities/blaze"),
            field_241883_b,
            blaze_veinSize,
            blaze_maxHeight,
            blaze_spawnChances),
    GHAST(2,
            new ResourceLocation("minecraft","entities/ghast"),
            field_241883_b,
            ghast_veinSize,
            ghast_maxHeight,
            ghast_spawnChances),
    WITHER_SKELETON(2,
            new ResourceLocation("minecraft","entities/wither_skeleton"),
            field_241883_b,
            wither_skeleton_veinSize,
            wither_skeleton_maxHeight,
            wither_skeleton_spawnChances);

    public final String name;
    public final int harvestLevel;
    public final ResourceLocation lootTable;
    public final RuleTest fillerBlockType;
    public final ForgeConfigSpec.IntValue veinSize;
    public final ForgeConfigSpec.IntValue maxHeight;
    public final ForgeConfigSpec.IntValue spawnChances;
    EnumMob (int harvestLevel, ResourceLocation lootTable, RuleTest fillerBlockType, ForgeConfigSpec.IntValue veinSize, ForgeConfigSpec.IntValue maxHeight, ForgeConfigSpec.IntValue spawnChances) {
        this.name = name().toLowerCase();
        this.harvestLevel = harvestLevel;
        this.lootTable = lootTable;
        this.fillerBlockType = fillerBlockType;
        this.veinSize = veinSize;
        this.maxHeight = maxHeight;
        this.spawnChances = spawnChances;
    }
}
