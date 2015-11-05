package com.mattdahepic.mobdropores.world;

import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.config.Config;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class MobOreWorldGen implements IWorldGenerator {
    private WorldGenMobOre gen_zombie;
    private WorldGenMobOre gen_blaze;
    private WorldGenMobOre gen_creeper;
    private WorldGenMobOre gen_enderman;
    private WorldGenMobOre gen_ghast;
    private WorldGenMobOre gen_guardian;
    private WorldGenMobOre gen_skeleton;
    private WorldGenMobOre gen_slime;
    private WorldGenMobOre gen_spider;
    private WorldGenMobOre gen_witch;
    private WorldGenMobOre gen_wither;
    private WorldGenMobOre gen_wither_skeleton;
    public MobOreWorldGen () {
        //WorldGenMobOre(EnumMob,targetBlock,veinSize,spawnChances,minHeight,maxHeight);
        gen_zombie = new WorldGenMobOre(EnumMob.ZOMBIE, Blocks.stone,Config.zombie.maxVeinSize,Config.zombie.spawnChances,Config.zombie.minY,Config.zombie.maxY);
        gen_blaze = new WorldGenMobOre(EnumMob.BLAZE,Blocks.netherrack,Config.blaze.maxVeinSize,Config.blaze.spawnChances,Config.blaze.minY,Config.blaze.maxY);
        gen_creeper = new WorldGenMobOre(EnumMob.CREEPER,Blocks.stone,Config.creeper.maxVeinSize,Config.creeper.spawnChances,Config.creeper.minY,Config.creeper.maxY);
        gen_enderman = new WorldGenMobOre(EnumMob.ENDERMAN,Blocks.stone,Config.enderman.maxVeinSize,Config.enderman.spawnChances,Config.enderman.minY,Config.enderman.maxY);
        gen_ghast = new WorldGenMobOre(EnumMob.GHAST,Blocks.netherrack,Config.ghast.maxVeinSize,Config.ghast.spawnChances,Config.ghast.minY,Config.ghast.maxY);
        gen_guardian = new WorldGenMobOre(EnumMob.GUARDIAN,Blocks.stone,Config.guardian.maxVeinSize,Config.guardian.spawnChances,Config.guardian.minY,Config.guardian.maxY);
        gen_skeleton = new WorldGenMobOre(EnumMob.SKELETON,Blocks.stone,Config.skeleton.maxVeinSize,Config.skeleton.spawnChances,Config.skeleton.minY,Config.skeleton.maxY);
        gen_slime = new WorldGenMobOre(EnumMob.SLIME,Blocks.stone,Config.slime.maxVeinSize,Config.slime.spawnChances,Config.slime.minY,Config.slime.maxY);
        gen_spider = new WorldGenMobOre(EnumMob.SPIDER,Blocks.stone,Config.spider.maxVeinSize,Config.spider.spawnChances,Config.spider.minY,Config.spider.maxY);
        gen_witch = new WorldGenMobOre(EnumMob.WITCH,Blocks.stone,Config.witch.maxVeinSize,Config.witch.spawnChances,Config.witch.minY,Config.witch.maxY);
        gen_wither = new WorldGenMobOre(EnumMob.WITHER,Blocks.stone,Config.wither.maxVeinSize,Config.wither.spawnChances,Config.wither.minY,Config.wither.maxY);
        gen_wither_skeleton = new WorldGenMobOre(EnumMob.WITHER_SKELETON,Blocks.stone,Config.wither_skeleton.maxVeinSize,Config.wither_skeleton.spawnChances,Config.wither_skeleton.minY,Config.wither_skeleton.maxY);
    }
    @Override
    public void generate (Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionId()) {
            case 0: //overworld
                runGenerator(gen_zombie,world,rand,chunkX,chunkZ,gen_zombie.spawnChances,gen_zombie.minHeight,gen_zombie.maxHeight);
                runGenerator(gen_creeper,world,rand,chunkX,chunkZ,gen_creeper.spawnChances,gen_creeper.minHeight,gen_creeper.maxHeight);
                runGenerator(gen_enderman,world,rand,chunkX,chunkZ,gen_enderman.spawnChances,gen_enderman.minHeight,gen_enderman.maxHeight);
                runGenerator(gen_guardian,world,rand,chunkX,chunkZ,gen_guardian.spawnChances,gen_guardian.minHeight,gen_guardian.maxHeight);
                runGenerator(gen_skeleton,world,rand,chunkX,chunkZ,gen_skeleton.spawnChances,gen_skeleton.minHeight,gen_skeleton.maxHeight);
                runGenerator(gen_slime,world,rand,chunkX,chunkZ,gen_slime.spawnChances,gen_slime.minHeight,gen_slime.maxHeight);
                runGenerator(gen_spider,world,rand,chunkX,chunkZ,gen_spider.spawnChances,gen_spider.minHeight,gen_spider.maxHeight);
                runGenerator(gen_witch,world,rand,chunkX,chunkZ,gen_witch.spawnChances,gen_witch.minHeight,gen_witch.maxHeight);
                runGenerator(gen_wither,world,rand,chunkX,chunkZ,gen_wither.spawnChances,gen_wither.minHeight,gen_wither.maxHeight);
                runGenerator(gen_wither_skeleton,world,rand,chunkX,chunkZ,gen_wither_skeleton.spawnChances,gen_wither_skeleton.minHeight,gen_wither_skeleton.maxHeight);
                break;
            case -1: //nether
                runGenerator(gen_blaze,world,rand,chunkX,chunkZ,gen_blaze.spawnChances,gen_blaze.minHeight,gen_blaze.maxHeight);
                runGenerator(gen_ghast,world,rand,chunkX,chunkZ,gen_ghast.spawnChances,gen_ghast.minHeight,gen_ghast.maxHeight);
                break;
        }
    }
    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + 8 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + 8 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x,y,z));
        }
    }
}
