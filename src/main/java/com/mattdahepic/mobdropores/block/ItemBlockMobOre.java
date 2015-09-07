package com.mattdahepic.mobdropores.block;

import com.mattdahepic.mobdropores.MobDropOres;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMobOre extends ItemBlock {
    public ItemBlockMobOre () {
        super(MobDropOres.mob_ore);
        this.setUnlocalizedName(BlockMobOre.NAME);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
    }
    @Override
    public String getUnlocalizedName (ItemStack stack) {
        return "tile."+MobUtils.mobFromMeta(stack.getMetadata()).getName()+".name";
    }
}
