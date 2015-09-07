package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.BlockMobOre;
import com.mattdahepic.mobdropores.block.ItemBlockMobOre;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void registerRenderers () {}
    public void registerBlocks () {
        MobDropOres.mob_ore = new BlockMobOre();
        MobDropOres.item_mob_ore = new ItemBlockMobOre();
        GameRegistry.registerBlock(MobDropOres.mob_ore,ItemBlockMobOre.class,MobDropOres.NAME);
    }
}
