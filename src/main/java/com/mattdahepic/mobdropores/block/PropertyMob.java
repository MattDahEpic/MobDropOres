package com.mattdahepic.mobdropores.block;

import net.minecraft.block.properties.PropertyEnum;

import java.util.Collection;
import java.util.HashSet;


public class PropertyMob extends PropertyEnum<EnumMob> {
    private final int block;
    public PropertyMob (int blockNum) {
        super("mob",EnumMob.class,getAllowedValuesForBlock(blockNum));
        block = blockNum;
    }
    private static Collection<EnumMob> getAllowedValuesForBlock (int blockNum) {
        Collection ret = new HashSet();
        for (EnumMob mob : EnumMob.values()) {
            if (mob.ordinal()/16 == blockNum) {
                ret.add(mob);
            }
        }
        return ret;
    }
    @Override
    public Collection<EnumMob> getAllowedValues() {
        return getAllowedValuesForBlock(block);
    }
}
