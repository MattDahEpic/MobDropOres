package com.mattdahepic.mobdropores.world;

import com.mattdahepic.mobdropores.MobDropOres;
import com.mattdahepic.mobdropores.block.EnumMob;
import com.mattdahepic.mobdropores.block.MobUtils;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.block.Block;

import java.util.Random;
import com.google.common.base.Predicate;

public class WorldGenMobOre extends WorldGenerator {
    private Block block = MobDropOres.mob_ore;
    private int meta;
    private Predicate target;
    private int veinSize;
    int spawnChances;
    int minHeight;
    int maxHeight;

    public WorldGenMobOre(EnumMob mob, Block target, int veinSize, int spawnChances, int minHeight, int maxHeight) {
        this.meta = MobUtils.metaFromMob(mob);
        this.target = BlockHelper.forBlock(target);
        this.veinSize = veinSize+1;
        this.spawnChances = spawnChances;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }
    @Override
    public boolean generate (World world, Random rand, BlockPos pos) {
        for (int i = veinSize; i > 0; i--) { //for all possible blocks
            if (rand.nextInt(veinSize+1) <= i) { //randomness with always at least one block
                switch (rand.nextInt(6)) { //make snake-like vein shapes
                    case 0:
                        pos = pos.up();
                        break;
                    case 1:
                        pos = pos.down();
                        break;
                    case 2:
                        pos = pos.north();
                        break;
                    case 3:
                        pos = pos.south();
                        break;
                    case 4:
                        pos = pos.east();
                        break;
                    case 5:
                        pos = pos.west();
                        break;
                }
                if (world.getBlockState(pos).getBlock().isReplaceableOreGen(world,pos,target) && world.isBlockLoaded(pos)) {
                    world.setBlockState(pos,block.getStateFromMeta(meta));
                }
            }
        }
        return true;
    }
}
