package com.mattdahepic.mobdropores.blocks.ores;

import com.mattdahepic.mobdropores.blocks.MobOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Random;

public class OreString extends MobOre {
    public static final String NAME = "oreString";
    public OreString () {
        super(1);
        this.setBlockName(NAME);
        this.setBlockTextureName("mobdropores:" + NAME);
    }
    @Override
    public Item getItemDropped(int metadata,Random random,int fortune) {
        return Items.string;
    }
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(this);
    }
}
