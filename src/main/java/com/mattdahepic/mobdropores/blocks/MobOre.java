package com.mattdahepic.mobdropores.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class MobOre extends Block {
    public MobOre (int harvestLevel) {
        super(Material.rock);
        this.setHarvestLevel("pickaxe",harvestLevel);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(Block.soundTypePiston);
        this.setHardness(3.0F);
    }
    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return true;
    }
    public int getAmountDrops (Random rand,int maxBase,int maxBonus,int fortuneLevel) {
        int ret = 0;
        if (fortuneLevel > 0) {
            ret = (rand.nextInt(maxBase)+1)+(rand.nextInt(maxBonus*fortuneLevel));
        } else {
            ret = (rand.nextInt(maxBase)+1);
        }
        return MathHelper.clamp_int(ret, 0, 64);
    }
}
