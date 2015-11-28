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

public class OreSkeleton extends MobOre {
    public static final String NAME = "oreSkeleton";
    public OreSkeleton () {
        super(1);
        this.setUnlocalizedName(NAME);
    }
    @Override
    public List<ItemStack> getDrops (IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        List<ItemStack> ret = new ArrayList<ItemStack>();
        Random rand = new Random();
        float arrowChance = rand.nextFloat();
        float boneChance = rand.nextFloat();
        float bowChance = rand.nextFloat();
        if (arrowChance < Config.arrowChance) {
            ret.add(new ItemStack(Items.arrow,super.getAmountDrops(rand, Config.maxArrowsBase, Config.maxArrowsBonus, fortune)));
        }
        if (boneChance < Config.boneChance) {
            ret.add(new ItemStack(Items.bone,super.getAmountDrops(rand, Config.maxBonesBase, Config.maxBonesBonus, fortune)));
        }
        if (bowChance < Config.bowChance) {
            ret.add(new ItemStack(Items.bow)); //TODO: enchants
        }
        return ret;
    }
}
