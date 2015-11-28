package com.mattdahepic.mobdropores.blocks;

import com.mattdahepic.mobdropores.config.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.MathHelper;

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
    protected boolean canSilkHarvest() {
        return true;
    }
    @Override
    public int quantityDropped(Random random) {
        if (Config.multipleDropsEnabled) {
            return 1 + random.nextInt(Config.maximumDropsNoFortune);
        } else {
            return 1;
        }
    }
    @Override
    public int quantityDroppedWithBonus(int fortune,Random random) {
        if (Config.multipleDropsEnabled) {
            return MathHelper.clamp_int(quantityDropped(random) + random.nextInt(Config.maximumDropsPerFortuneLevel), 0, Integer.MAX_VALUE);
        } else {
            return 1;
        }
    }
}
