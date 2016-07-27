package com.mattdahepic.mobdropores.block;

import net.minecraft.block.properties.PropertyEnum;

import java.util.Collection;
import java.util.HashSet;


public class PropertyMob extends PropertyEnum<EnumMob> {
    private static int totalStates = 0;
    private final int block;
    public PropertyMob () {
        super("mob",EnumMob.class,getAllowedValuesForBlock(totalStates));
        block = totalStates;
        totalStates++;
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
