package com.mattdahepic.mobdropores;

import com.mattdahepic.mobdropores.block.BlockMobOre;
import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.block.ItemBlockMobOre;
import com.mattdahepic.mobdropores.world.MobOreWorldGen;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
    public void registerRenderers () {}
    public void registerBlocks () {
        for (int i = 0; i <= Math.ceil(EnumMob.values().length / 16); i++) {
            String name = "mob_ore"+i;
            MobDropOres.mob_ores.add(i,new BlockMobOre(name));
            MobDropOres.item_mob_ores.add(i,new ItemBlockMobOre(MobDropOres.mob_ores.get(i)));
            GameRegistry.register(MobDropOres.mob_ores.get(i));
            GameRegistry.register(MobDropOres.item_mob_ores.get(i));
        }
    }
    public void registerOreDict () {
        for (EnumMob mob : EnumMob.values()) {
            String oreName = "ore" + mob.getName().substring(0, 1).toUpperCase() + mob.getName().substring(1);
            OreDictionary.registerOre(oreName,new ItemStack(mob.getBlock(),1,mob.getMeta()));
        }
    }
    public void registerWorldGen () {
        GameRegistry.registerWorldGenerator(new MobOreWorldGen(),1);
    }
}
