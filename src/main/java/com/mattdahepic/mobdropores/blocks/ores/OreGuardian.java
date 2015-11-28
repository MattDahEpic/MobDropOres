package com.mattdahepic.mobdropores.blocks.ores;

import com.mattdahepic.mobdropores.blocks.MobOre;
import com.mattdahepic.mobdropores.config.Config;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OreGuardian extends MobOre {
    public static final String NAME = "oreGuardian";
    public OreGuardian () {
        super(2);
        this.setUnlocalizedName(NAME);
    }
    @Override
    public List<ItemStack> getDrops (IBlockAccess world,BlockPos pos,IBlockState state,int fortune) {
        List<ItemStack> ret = new ArrayList<ItemStack>();
        Random rand = new Random();
        float shardChance = rand.nextFloat();
        float crystalChance = rand.nextFloat();
        if (shardChance < Config.shardChance) {
            ret.add(new ItemStack(Items.prismarine_shard,super.getAmountDrops(rand,Config.maxShardBase,Config.maxShardBonus,fortune)));
        }
        if (crystalChance < Config.crystalChance) {
            ret.add(new ItemStack(Items.prismarine_crystals,super.getAmountDrops(rand,Config.maxCrystalBase,Config.maxCrystalBonus,fortune)));
        }
        return ret;
    }
}
