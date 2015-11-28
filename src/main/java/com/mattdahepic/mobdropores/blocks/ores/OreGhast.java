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

public class OreGhast extends MobOre {
    public static final String NAME = "oreGhast";
    public OreGhast () {
        super(2);
        this.setUnlocalizedName(NAME);
    }
    @Override
    public List<ItemStack> getDrops (IBlockAccess world,BlockPos pos,IBlockState state,int fortune) {
        List<ItemStack> ret = new ArrayList<ItemStack>();
        Random rand = new Random();
        float tearChance = rand.nextFloat();
        if (tearChance < Config.tearChance) {
            ret.add(new ItemStack(Items.ghast_tear,super.getAmountDrops(rand,Config.maxTearBase,Config.maxTearBonus,fortune)));
        }
        return ret;
    }
}
