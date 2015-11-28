package com.mattdahepic.mobdropores.blocks.ores;

import com.mattdahepic.mobdropores.blocks.MobOre;
import com.mattdahepic.mobdropores.config.Config;
import com.mattdahepic.mobdropores.utils.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Random;

public class OreNetherStar extends MobOre {
    public static final String NAME = "oreNetherStar";
    public OreNetherStar () {
        super(3);
        this.setBlockName(NAME);
        this.setBlockTextureName("mobdropores:" + NAME);
    }
    @Override
    public Item getItemDropped(int metadata,Random random,int fortune) {
        Random rand = new Random();
        float getLucky = rand.nextFloat();
        LogHelper.info("Are you lucky? Value must be under "+Config.netherStarChance+" to recieve a nether star! Your lucky number is: " + getLucky);
        if (getLucky < Config.netherStarChance) {
            LogHelper.info("You win! Have your god damn nether star.");
            return Items.nether_star;
        } else {
            LogHelper.info("I win! Get lost sucker!");
            return null;
        }
    }
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(this);
    }
    @Override
    protected boolean canSilkHarvest() {
        return false;
    }
    @Override
    public int quantityDropped (Random random) {
        return 1;
    }
    @Override
    public int quantityDroppedWithBonus (int fortune, Random random) {
        return 1;
    }
}
