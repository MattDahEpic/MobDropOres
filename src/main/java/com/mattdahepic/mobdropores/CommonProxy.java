package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.block.MobUtils;
import com.mattdahepic.mobdropores.world.MobOreWorldGen;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
    public void registerRenderers () {}
    public void registerBlocks () {
        GameRegistry.register(MobDropOres.mob_ore);
        GameRegistry.register(MobDropOres.item_mob_ore);
    }
    public void registerOreDict () {
        for (int i = 0; i < EnumMob.values().length; i++) {
            String oreName = "ore" + MobUtils.mobFromMeta(i).getName().substring(0, 1).toUpperCase() + MobUtils.mobFromMeta(i).getName().substring(1);
            OreDictionary.registerOre(oreName,new ItemStack(MobDropOres.mob_ore,1,i));
        }
    }
    public void registerWorldGen () {
        GameRegistry.registerWorldGenerator(new MobOreWorldGen(),1);
    }
}
