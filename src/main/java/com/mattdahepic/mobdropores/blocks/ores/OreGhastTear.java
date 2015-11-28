package com.mattdahepic.mobdropores.blocks.ores;

import com.mattdahepic.mobdropores.blocks.MobOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Random;

public class OreGhastTear extends MobOre {
    public static final String NAME = "oreGhastTear";
    public OreGhastTear () {
        super(2);
        this.setBlockName(NAME);
        this.setBlockTextureName("mobdropores:" + NAME);
    }
    @Override
    public Item getItemDropped(int metadata,Random random,int fortune) {
        return Items.ghast_tear;
    }
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(this);
    }
}
