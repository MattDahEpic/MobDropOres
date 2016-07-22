package com.mattdahepic.mobdropores.block;

import com.mattdahepic.mobdropores.MobDropOres;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMobOre extends ItemBlock {
    public ItemBlockMobOre (Block block) {
        super(block);
        this.setUnlocalizedName(block.getUnlocalizedName());
        this.setRegistryName(block.getUnlocalizedName());
        this.setCreativeTab(CreativeTabs.SEARCH);
        this.setHasSubtypes(true);
    }
    @Override
    public int getMetadata(int damage) {
        return damage;
    }
    @Override
    public String getUnlocalizedName (ItemStack stack) {
        return "tile.mobore."+EnumMob.META_TO_MOB.get((MobDropOres.item_mob_ores.indexOf(stack.getItem())*16)+stack.getMetadata()).getName();
    }
}
