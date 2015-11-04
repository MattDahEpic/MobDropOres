package com.mattdahepic.mobdropores.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockMobOre extends Block {
    public static final PropertyEnum MOB = PropertyEnum.create("mob",EnumMob.class);
    public static final String NAME = "mob_ore";
    public BlockMobOre () {
        super(Material.rock);
        this.setUnlocalizedName(NAME);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.setDefaultState(this.blockState.getBaseState().withProperty(MOB, EnumMob.ZOMBIE));
        this.setHardness(2.0F);
    }
    @Override
    public boolean canSilkHarvest (World world, BlockPos pos, IBlockState state, EntityPlayer breaker) {
        //return state.getValue(MOB) != state.withProperty(MOB,EnumMob.WITHER); //TODO: check for forge fix on this shit
        return false;
    }
    @Override
    public int getHarvestLevel (IBlockState state) {
        //0=wood,gold;1=stone;2=iron;3=diamond
        return ((EnumMob)state.getValue(MOB)).getHarvestLevel();
    }
    @Override
    public String getHarvestTool (IBlockState state) {
        return "pickaxe";
    }
    @Override
    public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune) {
        return fortune+1;
    }
    @Override
    public List<ItemStack> getDrops (IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        Random rand = new Random();
        List<ItemStack> ret = new ArrayList<ItemStack>();
        ItemStackWithChance[] possiblities = ((EnumMob) state.getValue(MOB)).getDrops();
        for (ItemStackWithChance possible : possiblities) { //for all item types
            ItemStack item = possible.getStack();
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
    public BlockState createBlockState () {
        return new BlockState(this,MOB);
    }
    @Override
    public IBlockState getStateFromMeta (int meta) {
        return this.getDefaultState().withProperty(MOB, MobUtils.mobFromMeta(meta));
    }
    @Override
    public int getMetaFromState (IBlockState state) {
        return MobUtils.metaFromMob((EnumMob) state.getValue(MOB));
    }
    @Override
    public ItemStack getPickBlock (MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this,1,MobUtils.metaFromMob(((EnumMob)world.getBlockState(pos).getValue(MOB))));
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks (Item item, CreativeTabs tab, List list) {
        for (EnumMob mob : EnumMob.values()) {
            list.add(new ItemStack(item,1,MobUtils.metaFromMob(mob)));
        }
    }
}
