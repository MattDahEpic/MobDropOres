package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.blocks.ores.*;
import com.mattdahepic.mobdropores.utils.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
    public void registerRenderers() {}
    public void registerBlocksItems() {
        GameRegistry.registerBlock(MobDropOres.oreRottenFlesh, OreRottenFlesh.NAME);
        GameRegistry.registerBlock(MobDropOres.oreGunpowder, OreGunpowder.NAME);
        GameRegistry.registerBlock(MobDropOres.oreEnderpearl, OreEnderpearl.NAME);
        GameRegistry.registerBlock(MobDropOres.oreBlazeRod, OreBlazeRod.NAME);
        GameRegistry.registerBlock(MobDropOres.oreString, OreString.NAME);
        GameRegistry.registerBlock(MobDropOres.oreSpiderEye,OreSpiderEye.NAME);
        GameRegistry.registerBlock(MobDropOres.oreGhastTear,OreGhastTear.NAME);
        GameRegistry.registerBlock(MobDropOres.oreArrow,OreArrow.NAME);
        GameRegistry.registerBlock(MobDropOres.oreBone,OreBone.NAME);
        GameRegistry.registerBlock(MobDropOres.oreSlimeball,OreSlimeball.NAME);
        GameRegistry.registerBlock(MobDropOres.oreNetherStar,OreNetherStar.NAME);
        LogHelper.info("Ores registered!");
    }
    public void registerOreDict() {
        OreDictionary.registerOre(OreRottenFlesh.NAME,MobDropOres.oreRottenFlesh);
        OreDictionary.registerOre(OreGunpowder.NAME,MobDropOres.oreGunpowder);
        OreDictionary.registerOre(OreEnderpearl.NAME,MobDropOres.oreEnderpearl);
        OreDictionary.registerOre(OreBlazeRod.NAME,MobDropOres.oreBlazeRod);
        OreDictionary.registerOre(OreString.NAME,MobDropOres.oreString);
        OreDictionary.registerOre(OreSpiderEye.NAME,MobDropOres.oreSpiderEye);
        OreDictionary.registerOre(OreGhastTear.NAME,MobDropOres.oreGhastTear);
        OreDictionary.registerOre(OreArrow.NAME,MobDropOres.oreArrow);
        OreDictionary.registerOre(OreBone.NAME,MobDropOres.oreBone);
        OreDictionary.registerOre(OreSlimeball.NAME,MobDropOres.oreSlimeball);
        OreDictionary.registerOre(OreNetherStar.NAME,MobDropOres.oreNetherStar);
    }
}
