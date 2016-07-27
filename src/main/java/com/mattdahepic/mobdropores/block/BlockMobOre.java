package com.mattdahepic.mobdropores.block;

import com.mattdahepic.mdecore.helpers.RandomHelper;
import com.mattdahepic.mobdropores.MobDropOres;
import com.mattdahepic.mobdropores.config.MDOConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockMobOre extends Block {
    private final String unlocName;
    public PropertyEnum MOB;
    public BlockMobOre (String name, int blockNum) {
        super(Material.ROCK);
        unlocName = name;
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.SEARCH);
        this.setDefaultState(this.blockState.getBaseState().withProperty(MOB, EnumMob.META_TO_MOB.get(blockNum*16)));
        this.setHardness(2.0F);
    }
    @Override
    public String getUnlocalizedName () {
        return this.unlocName;
    }
    @Override
    public boolean canSilkHarvest (World world, BlockPos pos, IBlockState state, EntityPlayer breaker) {
        return state.getValue(MOB) != EnumMob.WITHER;
    }
    @Override
    public int getHarvestLevel (IBlockState state) {
        return ((EnumMob)state.getValue(MOB)).getHarvestLevel();
    }
    @Override
    public String getHarvestTool (IBlockState state) {
        return "pickaxe";
    }
    @Override
    public int getExpDrop (IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        return ((EnumMob)state.getValue(MOB)).getHarvestLevel()+fortune;
    }
    @Override
    public List<ItemStack> getDrops (IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        Random rand = RandomHelper.RAND;
        List<ItemStack> ret = new ArrayList<ItemStack>();
        ItemStackWithChance[] possiblities = ((EnumMob) state.getValue(MOB)).getDrops();
        for (ItemStackWithChance possible : possiblities) { //for all item types
            ItemStack item = possible.getStack();
            if (MDOConfig.alwaysDropItems) {
                ret.add(item.copy());
                continue;
            }
            float chance = possible.getChance();
            for (int i = 0; i < possible.getTries() + fortune; i++) { //and as many tries, including fortune
                if (rand.nextFloat() <= chance) {
                    ret.add(item.copy());
                }
            }
        }
        return ret;
    }
    @Override
    public BlockStateContainer createBlockState () {
        if (MOB == null) MOB = new PropertyMob();
        return new BlockStateContainer(this,MOB);
    }
    @Override
    public IBlockState getStateFromMeta (int meta) {
        int blockNum = MobDropOres.mob_ores.indexOf(this);
        return getDefaultState().withProperty(MOB,EnumMob.META_TO_MOB.get((blockNum*16)+meta));
    }
    @Override
    public int getMetaFromState (IBlockState state) {
        return ((EnumMob)state.getValue(MOB)).getMeta();
    }
    @Override
    public ItemStack getPickBlock (IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        EnumMob mob = (EnumMob)state.getValue(MOB);
        return new ItemStack(mob.getBlock(),1,mob.getMeta());
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks (Item item, CreativeTabs tab, List list) {
        for (EnumMob mob : EnumMob.values()) {
            if (item.equals(Item.getItemFromBlock(mob.getBlock()))) {
                list.add(new ItemStack(item, 1, mob.getMeta()));
            }
        }
    }
}
