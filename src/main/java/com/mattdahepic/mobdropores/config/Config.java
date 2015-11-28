package com.mattdahepic.mobdropores.config;

import com.mattdahepic.mobdropores.MobDropOres;
import com.mattdahepic.mobdropores.utils.LogHelper;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config {
    public static final String LIMIT_COMMENT = " Ores will drop a maximum of 64 of a single item.";
    public static final String FORTUNE_COMMENT = " Fortune drops will be calculated then added to the value determined as if the ore was mined without fortune.";
    //defaults
    public static boolean superCheatyDebugLogs = false;

    public static final String CATEGORY_SKELETON = "skeleton";
    public static OreGenConfigOption skeleton = new OreGenConfigOption(MobDropOres.oreSkeleton);
    public static float arrowChance = 0.5F;
    public static int maxArrowsBase = 2;
    public static int maxArrowsBonus = 3;
    public static float boneChance = 0.5F;
    public static int  maxBonesBase = 2;
    public static int maxBonesBonus = 3;
    public static float bowChance = 0.10F;

    public static final String CATEGORY_SPIDER = "spider";
    public static OreGenConfigOption spider = new OreGenConfigOption(MobDropOres.oreSpider);
    public static float stringChance = 0.5F;
    public static int maxStringBase = 2;
    public static int maxStringBonus = 3;
    public static float spiderEyeChance = 0.5F;
    public static int maxSpiderEyeBase = 1;
    public static int maxSpiderEyeBonus = 2;

    public static final String CATEGORY_GUARDIAN = "guardian";
    public static OreGenConfigOption guardian = new OreGenConfigOption(MobDropOres.oreGuardian);
    public static float shardChance = 0.5F;
    public static int maxShardBase = 1;
    public static int maxShardBonus = 1;
    public static float crystalChance = 0.5F;
    public static int maxCrystalBase = 1;
    public static int maxCrystalBonus = 1;

    public static final String CATEGORY_ZOMBIE = "zombie";
    public static OreGenConfigOption zombie = new OreGenConfigOption(MobDropOres.oreZombie);
    public static float fleshChance = 1.0F;
    public static int maxFleshBase = 2;
    public static int maxFleshBonus = 5;

    public static final String CATEGORY_CREEPER = "creeper";
    public static OreGenConfigOption creeper = new OreGenConfigOption(MobDropOres.oreCreeper);
    public static float gunpowderChance = 0.75F;
    public static int maxGunpowderBase = 1;
    public static int maxGunpowderBonus = 2;

    public static final String CATEGORY_ENDERMAN = "enderman";
    public static OreGenConfigOption enderman = new OreGenConfigOption(MobDropOres.oreEnderman);
    public static float pearlChance = 0.5F;
    public static int maxPearlBase = 1;
    public static int maxPearlBonus = 1;

    public static final String CATEGORY_BLAZE = "blaze";
    public static OreGenConfigOption blaze = new OreGenConfigOption(MobDropOres.oreBlaze);
    public static float blazeRodChance = 0.45F;
    public static int maxBlazeRodBase = 1;
    public static int maxBlazeRodBonus = 1;

    public static final String CATEGORY_SLIME = "slime";
    public static OreGenConfigOption slime = new OreGenConfigOption(MobDropOres.oreSlime);
    public static float slimeBallChance = 0.5F;
    public static int maxSlimeBallBase = 3;
    public static int maxSlimeBallBonus = 2;

    public static final String CATEGORY_WITHER = "wither";
    public static OreGenConfigOption wither = new OreGenConfigOption(MobDropOres.oreWither);
    public static float starChance = 0.01F;

    public static final String CATEGORY_GHAST = "ghast";
    public static OreGenConfigOption ghast = new OreGenConfigOption(MobDropOres.oreGhast);
    public static float tearChance = 0.483F;
    public static int maxTearBase = 1;
    public static int maxTearBonus = 1;

    public static final String CATEGORY_WITCH = "witch";
    public static OreGenConfigOption witch = new OreGenConfigOption(MobDropOres.oreWitch);
    public static float bottleChance = 0.125F;
    public static int maxBottleBase = 2;
    public static int maxBottleBonus = 3;
    public static float glowstoneChance = 0.125F;
    public static int maxGlowstoneBase = 1;
    public static int maxGlowstoneBonus = 2;
    public static float gunpowderChanceWitch = 0.125F;
    public static int maxGunpowderBaseWitch = 1;
    public static int maxGunpowderBonusWitch = 2;
    public static float redstoneChance = 0.125F;
    public static int maxRedstoneBase = 1;
    public static int maxRadstoneBonus = 2;
    public static float spiderEyeChanceWitch = 0.125F;
    public static int maxSpiderEyeBaseWitch = 1;
    public static int maxSpiderEyeBonusWitch = 2;
    public static float sugarChance = 0.125F;
    public static int maxSugarBase = 1;
    public static int maxSugarBonus = 2;
    public static float stickChance = 0.125F;
    public static int maxStickBase = 1;
    public static int maxStickBonus = 2;

    public static void load (FMLPreInitializationEvent event) {
        MobDropOres.configFile = new Configuration(event.getSuggestedConfigurationFile());
        syncConfig();
    }
    public static void syncConfig () {
        try {
            Config.processConfig(MobDropOres.configFile);
        } catch (Exception e) {
            LogHelper.error("Error loading config!");
        } finally {
            if (MobDropOres.configFile.hasChanged()) {
                MobDropOres.configFile.save();
            }
        }
    }
    @SubscribeEvent
    public void onConfigChanged (ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals(MobDropOres.MODID)) {
            LogHelper.info("Saving Config...");
            syncConfig();
        }
    }
    public static void processConfig (Configuration c) {
        superCheatyDebugLogs = c.getBoolean("superCheatyDebugLogs",Configuration.CATEGORY_GENERAL,superCheatyDebugLogs,"Enable logs that show where every ore is trying to be generated in the world? It's cheaty!");

        skeleton.enabled = true;
        skeleton.veinAmount = 2;
        skeleton.veinSize = 3;
        skeleton.minY = 0;
        skeleton.maxY = 128;
        skeleton.rarity = 3;
        skeleton.loadValue(c,CATEGORY_SKELETON);
        arrowChance = c.getFloat("arrowChance",CATEGORY_SKELETON,arrowChance,0.0F,1.0F,"Chance out of 1.0 to get 1 or more arrows from a skeleton ore.");
        boneChance = c.getFloat("boneChance",CATEGORY_SKELETON,boneChance,0.0F,1.0F,"Chance out of 1.0 to get 1 or more bones from a skeleton ore.");
        bowChance = c.getFloat("bowChance",CATEGORY_SKELETON,bowChance,0.0F,1.0F,"Chance out of 1.0 to get a bow from a skeleton ore.");
        maxArrowsBase = c.getInt("maxArrowsBase",CATEGORY_SKELETON,maxArrowsBase,1,64,"The maximum amount of arrows obtainable from a skeleton ore without fortune."+LIMIT_COMMENT);
        maxArrowsBonus = c.getInt("maxArrowsBonus",CATEGORY_SKELETON,maxArrowsBonus,1,64,"The maximum amount of arrows obtainable from a skeleton ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);
        maxBonesBase = c.getInt("maxBonesBase",CATEGORY_SKELETON,maxBonesBase,1,64,"The maximum amount of bones obtainable from a skeleton ore without fortune."+LIMIT_COMMENT);
        maxBonesBonus = c.getInt("maxBonesBonus",CATEGORY_SKELETON,maxBonesBonus,1,64,"The maximum amount of bones obtainable from a skeleton ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);

        spider.enabled = true;
        spider.veinAmount = 2;
        spider.veinSize = 3;
        spider.minY = 0;
        spider.maxY = 100;
        spider.rarity = 3;
        spider.loadValue(c,CATEGORY_SPIDER);
        stringChance = c.getFloat("stringChance",CATEGORY_SPIDER,stringChance,0.0F,1.0F,"Chance out of 1.0 to get one or more string from a spider ore.");
        maxStringBase = c.getInt("maxStringBase",CATEGORY_SPIDER,maxStringBase,1,64,"The maximum amount of sting obtainable from a single spider ore without fortune."+LIMIT_COMMENT);
        maxStringBonus = c.getInt("maxStringBonus",CATEGORY_SPIDER,maxStringBonus,1,64,"The maximum amount of string obtianable from a single spider PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);
        spiderEyeChance = c.getFloat("spiderEyeChance",CATEGORY_SPIDER,spiderEyeChance,0.0F,1.0F,"Chance out of 1.0 to get one or more spider eyes from a spider ore.");
        maxSpiderEyeBase = c.getInt("maxSpiderEyeBase",CATEGORY_SPIDER,maxSpiderEyeBase,1,64,"The maximum amount of spider eyes obtainable from a single spider ore without fortune."+LIMIT_COMMENT);
        maxSpiderEyeBonus = c.getInt("maxSpiderEyeBonus",CATEGORY_SPIDER,maxSpiderEyeBonus,1,64,"The maximum amount of spider eyes obtainable from a single spider ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);

        guardian.enabled = true;
        guardian.veinAmount = 2;
        guardian.veinSize = 1;
        guardian.minY = 10;
        guardian.maxY = 64;
        guardian.rarity = 3;
        guardian.loadValue(c,CATEGORY_GUARDIAN);
        shardChance = c.getFloat("shardChance",CATEGORY_GUARDIAN,shardChance,0.0F,1.0F,"Chance out of 1.0 to get one or more prismarine shards from a guardian ore.");
        maxShardBase = c.getInt("maxShardBase",CATEGORY_GUARDIAN,maxShardBase,1,64,"The maximum amount of prismarine shards obtainable from a single guardian ore without fortune."+LIMIT_COMMENT);
        maxShardBonus = c.getInt("maxShardBonus",CATEGORY_GUARDIAN,maxShardBonus,1,64,"The maximum amount of prismarine obtainable from a single guardian ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);
        crystalChance = c.getFloat("crystalChance",CATEGORY_GUARDIAN,crystalChance,0.0F,1.0F,"Chance out of 1.0 to get one or more prismarine crystals from a guardian ore.");
        maxCrystalBase = c.getInt("maxCrystalBase",CATEGORY_GUARDIAN,maxCrystalBase,1,64,"The maximum amount prismarine crystals obtainable from a single guardian ore without fortune."+LIMIT_COMMENT);
        maxCrystalBonus = c.getInt("maxCrystalBonus",CATEGORY_GUARDIAN,maxCrystalBonus,1,64,"The maximum amount of prismarine crystals obtainable from a single guardian ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);

        zombie.enabled = true;
        zombie.veinAmount = 2;
        zombie.veinSize = 3;
        zombie.minY = 0;
        zombie.maxY = 255;
        zombie.rarity = 2;
        zombie.loadValue(c,CATEGORY_ZOMBIE);
        fleshChance = c.getFloat("fleshChance",CATEGORY_ZOMBIE,fleshChance,0.0F,1.0F,"Chance out of 1.0 to get one or more rotten flesh from a zombie ore.");
        maxFleshBase = c.getInt("maxFleshBase",CATEGORY_ZOMBIE,maxFleshBase,1,64,"The maximum amount of rotten flesh obtainable from a single zombie ore without fortune."+LIMIT_COMMENT);
        maxFleshBonus = c.getInt("maxFleshBonus",CATEGORY_ZOMBIE,maxFleshBonus,1,64,"The maximum amount of rotten flesh obtainable from a single zombie ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);

        creeper.enabled = true;
        creeper.veinAmount = 2;
        creeper.veinSize = 1;
        creeper.minY = 16;
        creeper.maxY = 64;
        creeper.rarity = 2;
        creeper.loadValue(c,CATEGORY_CREEPER);
        gunpowderChance = c.getFloat("gunpowderChance",CATEGORY_CREEPER,gunpowderChance,0.0F,1.0F,"Chance out of 1.0 to get one or more gunpowder from a creeper ore.");
        maxGunpowderBase = c.getInt("maxGunpowderBase",CATEGORY_CREEPER,maxGunpowderBase,1,64,"The maximum amount of gunpowder obtainable from a single creeper ore without fortune."+LIMIT_COMMENT);
        maxGunpowderBonus = c.getInt("maxGunpowderBonus",CATEGORY_CREEPER,maxGunpowderBonus,1,64,"The maximum amount of gunpowder obtainable from a single creeper ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);

        enderman.enabled = true;
        enderman.veinAmount = 1;
        enderman.veinSize = 2;
        enderman.minY = 0;
        enderman.maxY = 64;
        enderman.rarity = 3;
        enderman.loadValue(c,CATEGORY_ENDERMAN);
        pearlChance = c.getFloat("pearlChance",CATEGORY_ENDERMAN,pearlChance,0.0F,1.0F,"Chance out of 1.0 to get one or more ender pearls from a enderman ore.");
        maxPearlBase = c.getInt("maxPearlBase",CATEGORY_ENDERMAN,maxPearlBase,1,64,"The maximum amount of ender pearls obtainable from a single enderman ore without fortune."+LIMIT_COMMENT);
        maxPearlBonus = c.getInt("maxPearlBonus",CATEGORY_ENDERMAN,maxPearlBonus,1,64,"The maximum amount of enderpearls obtainable from a single enderman ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);

        blaze.enabled = true;
        blaze.veinAmount = 2;
        blaze.veinSize = 2;
        blaze.minY = 16;
        blaze.maxY = 128;
        blaze.rarity = 2;
        blaze.loadValue(c,CATEGORY_BLAZE);
        blazeRodChance = c.getFloat("blazeRodChance",CATEGORY_BLAZE,blazeRodChance,0.0F,1.0F,"Chance out of 1.0 to get one or more blaze rods from a blaze rod.");
        maxBlazeRodBase = c.getInt("maxBlazeRodBase",CATEGORY_BLAZE,maxBlazeRodBase,1,64,"The maximum amount or blaze rods obtainable from a single blaze ore without fortune."+LIMIT_COMMENT);
        maxBlazeRodBonus = c.getInt("maxBlazeRodBonus",CATEGORY_BLAZE,maxBlazeRodBonus,1,64,"The maximum amount of blaze rods obtainable from a single blaze rod ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);

        slime.enabled = true;
        slime.veinAmount = 2;
        slime.veinSize = 2;
        slime.minY = 16;
        slime.maxY = 64;
        slime.rarity = 2;
        slime.loadValue(c,CATEGORY_SLIME);
        slimeBallChance = c.getFloat("slimeBallChance",CATEGORY_SLIME,slimeBallChance,0.0F,1.0F,"Chance out fo 1.0 to get one or more slime balls from a slime ore.");
        maxSlimeBallBase = c.getInt("maxSlimeBallBase",CATEGORY_SLIME,maxSlimeBallBase,1,64,"The maximum amount of slime balls obtainable from a single slime ore without fortune."+LIMIT_COMMENT);
        maxSlimeBallBonus = c.getInt("maxSlimeBallBonus",CATEGORY_SLIME,maxSlimeBallBonus,1,64,"The maximum amount of slime balls obtainable from a single slime ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);

        wither.enabled = true;
        wither.veinAmount = 1;
        wither.veinSize = 1;
        wither.minY = 0;
        wither.maxY = 5;
        wither.rarity = 10;
        wither.loadValue(c,CATEGORY_WITHER);
        starChance = c.getFloat("starChance",CATEGORY_WITHER,starChance,0.0F,1.0F,"Chance out of 1.0 to get a nether star from a wither ore.");

        ghast.enabled = true;
        ghast.veinAmount = 2;
        ghast.veinSize = 2;
        ghast.minY = 16;
        ghast.maxY = 128;
        ghast.rarity = 2;
        ghast.loadValue(c,CATEGORY_GHAST);
        tearChance = c.getFloat("tearChance",CATEGORY_GHAST,tearChance,0.0F,1.0F,"Chance out of 1.0 to get one or more ghast tears from a ghast ore.");
        maxTearBase = c.getInt("maxTearBase",CATEGORY_GHAST,maxTearBase,1,64,"The maximum amount of ghast tears obtainable from a single ghast ore without fortune."+LIMIT_COMMENT);
        maxTearBonus = c.getInt("maxTearBonus",CATEGORY_GHAST,maxTearBonus,1,64,"The maximum amount of ghast tear obtainable from a single ghast ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);

        witch.enabled = true;
        witch.veinAmount = 2;
        witch.veinSize = 1;
        witch.minY = 16;
        witch.maxY = 64;
        witch.rarity = 2;
        witch.loadValue(c,CATEGORY_WITCH);
        bottleChance = c.getFloat("bottleChance",CATEGORY_WITCH,bottleChance,0.0F,1.0F,"Chance out of 1.0 to get one or more glass bottles from a witch ore.");
        maxBottleBase = c.getInt("maxBottleBase",CATEGORY_WITCH,maxBottleBase,1,64,"The maximum amount of glass bottles obtainable from a single witch ore without fortune."+LIMIT_COMMENT);
        maxBottleBonus = c.getInt("maxBottleBonus",CATEGORY_WITCH,maxBottleBonus,1,64,"The maximum amount of glass bottles obtainable from a single witch ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);
        glowstoneChance = c.getFloat("glowstoneChance",CATEGORY_WITCH,glowstoneChance,0.0F,1.0F,"Chance out of 1.0 to get one or more glowstone dusteses from a witch ore.");
        maxGlowstoneBase = c.getInt("maxGlowstoneBase",CATEGORY_WITCH,maxGlowstoneBase,1,64,"The maximum amount of glowstone dusteses obtainable from a single witch ore without fortune."+LIMIT_COMMENT);
        maxGlowstoneBonus = c.getInt("maxGlowstoneBonus",CATEGORY_WITCH,maxGlowstoneBonus,1,64,"The maximum amount of glowstone dusteses obtainable from a single witch ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);
        gunpowderChanceWitch = c.getFloat("gunpowderChanceWitch",CATEGORY_WITCH,gunpowderChanceWitch,0.0F,1.0F,"Chance out of 1.0 to get one or more gunpowder from a witch ore.");
        maxGunpowderBaseWitch = c.getInt("maxGunpowderBaseWitch",CATEGORY_WITCH,maxGunpowderBaseWitch,1,64,"The maximum amount of gunpowder obtainable from a single witch ore without fortune."+LIMIT_COMMENT);
        maxGunpowderBonusWitch = c.getInt("maxGunpowderBonusWitch",CATEGORY_WITCH,maxGunpowderBonusWitch,1,64,"The maximum amount of gunpowder obtainable from a single witch ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);
        redstoneChance = c.getFloat("redstoneChance",CATEGORY_WITCH,redstoneChance,0.0F,1.0F,"Chance out of 1.0 to get one or more redstone from a witch ore.");
        maxRedstoneBase = c.getInt("maxRedstoneBase",CATEGORY_WITCH,maxRedstoneBase,1,64,"The maximum amount of redstone obtainable from a single witch ore without fortune."+LIMIT_COMMENT);
        maxRadstoneBonus = c.getInt("maxRedstoneBonus",CATEGORY_WITCH,maxRadstoneBonus,1,64,"The maximum amount of redstone obtainable frm a witch ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);
        spiderEyeChanceWitch = c.getFloat("spiderEyeChanceWitch",CATEGORY_WITCH,spiderEyeChanceWitch,0.0F,1.0F,"Chance out of 1.0 to get one or more spder eyes from a witch ore.");
        maxSpiderEyeBaseWitch = c.getInt("maxSpiderEyeBaseWitch",CATEGORY_WITCH,maxSpiderEyeBaseWitch,1,64,"The maximum amount of spider eyes obtainable from a single witch ore without fortune."+LIMIT_COMMENT);
        maxSpiderEyeBonusWitch = c.getInt("maxSpiderEyeBonusWitch",CATEGORY_WITCH,maxSpiderEyeBonusWitch,1,64,"The maximum amount of spider eyes obtainable from a single witch ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);
        sugarChance = c.getFloat("sugarChance",CATEGORY_WITCH,sugarChance,0.0F,1.0F,"Chance out of 1.0 to get one or more sugar from a witch ore.");
        maxSugarBase = c.getInt("maxSugarBase",CATEGORY_WITCH,maxSugarBase,1,64,"The maximum amount of sugar obtainable from a single witch ore without fortune."+LIMIT_COMMENT);
        maxSugarBonus = c.getInt("maxSugarBonus",CATEGORY_WITCH,maxSugarBonus,1,64,"The maximum amount or sugar obtainable from a single witch ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);
        stickChance = c.getFloat("stickChance",CATEGORY_WITCH,stickChance,0.0F,1.0F,"Chance out of 1.0 to get one or more sticks from a witch ore.");
        maxStickBase = c.getInt("maxStickBase",CATEGORY_WITCH,maxStickBase,1,64,"The maximum amount of sticks obtainable from a single witch ore without fortune."+LIMIT_COMMENT);
        maxStickBonus = c.getInt("maxStickBonus",CATEGORY_WITCH,maxStickBonus,1,64,"The maximum amount of sticks obtainable from a single witch ore PER LEVEL OF FORTUNE."+FORTUNE_COMMENT+LIMIT_COMMENT);
    }
    private Config() {}
}
