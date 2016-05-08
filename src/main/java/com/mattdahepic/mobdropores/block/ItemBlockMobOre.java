package com.mattdahepic.mobdropores.block;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMobOre extends ItemBlock {
    public ItemBlockMobOre (Block block) {
        super(block);
        this.setUnlocalizedName(BlockMobOre.NAME);
        this.setRegistryName(BlockMobOre.NAME);
        this.setCreativeTab(CreativeTabs.SEARCH);
        this.setHasSubtypes(true);
    }
    @Override
    public int getMetadata(int damage) {
        return damage;
    }
    @Override
    public String getUnlocalizedName (ItemStack stack) {
        return "tile.mobore."+MobUtils.mobFromMeta(stack.getMetadata()).getName();
    }
}
