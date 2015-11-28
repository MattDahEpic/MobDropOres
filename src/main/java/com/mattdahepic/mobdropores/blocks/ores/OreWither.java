package com.mattdahepic.mobdropores.blocks.ores;

import com.mattdahepic.mobdropores.blocks.MobOre;
import com.mattdahepic.mobdropores.config.Config;
import com.mattdahepic.mobdropores.utils.LogHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OreWither extends MobOre {
    public static final String NAME = "oreWither";
    public OreWither () {
        super(3);
        this.setUnlocalizedName(NAME);
    }
    @Override
    public List<ItemStack> getDrops (IBlockAccess world,BlockPos pos,IBlockState state,int fortune) {
        List<ItemStack> ret = new ArrayList<ItemStack>();
        Random rand = new Random();
        float starChance = rand.nextFloat();
        LogHelper.info("Your magic number is: "+starChance+" and it must be lower than "+Config.starChance+" to get a star.");
        if (starChance < Config.starChance) {
            ret.add(new ItemStack(Items.nether_star,1));
            LogHelper.info("You win a star!");
        } else {
            LogHelper.info("You lose.");
        }
        return ret;
    }
}
