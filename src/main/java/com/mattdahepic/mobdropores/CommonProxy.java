package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.BlockMobOre;
import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.block.ItemBlockMobOre;
import com.mattdahepic.mobdropores.block.MobUtils;
import com.mattdahepic.mobdropores.world.MobOreWorldGen;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
    public void registerRenderers () {}
    public void registerBlocks () {
        MobDropOres.logger.info("Registering Blocks");
        MobDropOres.mob_ore = new BlockMobOre();
        MobDropOres.item_mob_ore = new ItemBlockMobOre(MobDropOres.mob_ore);
        GameRegistry.registerBlock(MobDropOres.mob_ore,ItemBlockMobOre.class,BlockMobOre.NAME);
    }
    public void registerOreDict () {
        MobDropOres.logger.info("Registering Ore Dictionary Entries");
        for (int i = 0; i < EnumMob.values().length; i++) {
            String oreName = "ore" + MobUtils.mobFromMeta(i).getName().substring(0, 1).toUpperCase() + MobUtils.mobFromMeta(i).getName().substring(1);
            OreDictionary.registerOre(oreName,new ItemStack(MobDropOres.mob_ore,1,i));
        }
    }
    public void registerWorldGen () {
        MobDropOres.logger.info("Registering World Generator");
        GameRegistry.registerWorldGenerator(new MobOreWorldGen(),1);
    }
}
