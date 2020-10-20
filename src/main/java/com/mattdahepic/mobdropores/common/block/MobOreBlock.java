package com.mattdahepic.mobdropores.common.block;

import com.mattdahepic.mdecore.common.helpers.EnchantmentHelper;
import com.mattdahepic.mobdropores.common.EnumMob;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Collections;
import java.util.List;

public class MobOreBlock extends Block {
    public final EnumMob MOB;
    public MobOreBlock(EnumMob mob) {
        super(Properties.create(Material.ROCK).hardnessAndResistance(2f));
        this.MOB = mob;
    }
    @Override
    public int getHarvestLevel (BlockState state) {
        return MOB.harvestLevel;
    }

    @Override
    public ToolType getHarvestTool (BlockState state) {
        return ToolType.PICKAXE;
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? MOB.harvestLevel+fortune : 0;
    }


    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH,builder.get(LootParameters.TOOL)) != 0) return Collections.singletonList(new ItemStack(this));

        PlayerEntity playerThatWillTakeTheBlameForKillingTheEnity = builder.getWorld().getRandomPlayer(); //only needed to trigger "killed_by_player" loot table entries
        LootContext lootcontext = new LootContext.Builder(builder.getWorld())
                .withRandom(builder.getWorld().rand)
                .withParameter(LootParameters.LAST_DAMAGE_PLAYER,playerThatWillTakeTheBlameForKillingTheEnity)
                .withParameter(LootParameters.DAMAGE_SOURCE, DamageSource.causePlayerDamage(playerThatWillTakeTheBlameForKillingTheEnity))
                .withParameter(LootParameters.THIS_ENTITY,playerThatWillTakeTheBlameForKillingTheEnity)
                .withParameter(LootParameters.field_237457_g_, Vector3d.ZERO)
                .build(LootParameterSets.ENTITY);
        ServerWorld serverworld = lootcontext.getWorld();
        LootTable loottable = serverworld.getServer().getLootTableManager().getLootTableFromLocation(MOB.lootTable);
        return loottable.generate(lootcontext);
    }

    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        return new ItemStack(this);
    }
}
