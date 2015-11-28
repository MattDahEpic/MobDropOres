package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.blocks.ores.*;
import com.mattdahepic.mobdropores.utils.LogHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
    public void registerRenderers() {}
    public void registerBlocksItems() {
        GameRegistry.registerBlock(MobDropOres.oreSkeleton,OreSkeleton.NAME);
        GameRegistry.registerBlock(MobDropOres.oreSpider,OreSpider.NAME);
        GameRegistry.registerBlock(MobDropOres.oreGuardian,OreGuardian.NAME);
        GameRegistry.registerBlock(MobDropOres.oreZombie,OreZombie.NAME);
        GameRegistry.registerBlock(MobDropOres.oreCreeper, OreCreeper.NAME);
        GameRegistry.registerBlock(MobDropOres.oreEnderman,OreEnderman.NAME);
        GameRegistry.registerBlock(MobDropOres.oreBlaze,OreBlaze.NAME);
        GameRegistry.registerBlock(MobDropOres.oreSlime,OreSlime.NAME);
        GameRegistry.registerBlock(MobDropOres.oreWither,OreWither.NAME);
        GameRegistry.registerBlock(MobDropOres.oreGhast,OreGhast.NAME);
        GameRegistry.registerBlock(MobDropOres.oreWitch,OreWitch.NAME);
        LogHelper.info("Blocks registered!");
    }
    public void registerOreDict() {
        OreDictionary.registerOre(OreSkeleton.NAME,MobDropOres.oreSkeleton);
        OreDictionary.registerOre(OreSpider.NAME,MobDropOres.oreSpider);
        OreDictionary.registerOre(OreGuardian.NAME,MobDropOres.oreGuardian);
        OreDictionary.registerOre(OreZombie.NAME,MobDropOres.oreZombie);
        OreDictionary.registerOre(OreCreeper.NAME,MobDropOres.oreCreeper);
        OreDictionary.registerOre(OreEnderman.NAME,MobDropOres.oreEnderman);
        OreDictionary.registerOre(OreBlaze.NAME,MobDropOres.oreBlaze);
        OreDictionary.registerOre(OreSlime.NAME,MobDropOres.oreSlime);
        OreDictionary.registerOre(OreWither.NAME,MobDropOres.oreWither);
        OreDictionary.registerOre(OreGhast.NAME,MobDropOres.oreGhast);
        OreDictionary.registerOre(OreWitch.NAME,MobDropOres.oreWitch);
        LogHelper.info("Ores Added to Ore Dictionary!");
    }
}
