package com.mattdahepic.mobdropores.blocks.ores;

import com.mattdahepic.mobdropores.blocks.MobOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Random;

public class OreBlazeRod extends MobOre {
    public static final String NAME = "oreBlazeRod";
    public OreBlazeRod () {
        super(2);
        this.setBlockName(NAME);
        this.setBlockTextureName("mobdropores:" + NAME);
    }
    @Override
    public Item getItemDropped(int metadata,Random random,int fortune) {
        return Items.blaze_rod;
    }
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(this);
    }
}
