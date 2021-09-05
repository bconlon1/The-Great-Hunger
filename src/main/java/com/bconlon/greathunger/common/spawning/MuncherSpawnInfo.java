package com.bconlon.greathunger.common.spawning;

import net.minecraft.block.BlockState;

import javax.annotation.Nullable;

// In 1.17 and 1.18 I will add a biome parameter to this so biome is also accessible in the spawn info for cave biomes.
public class MuncherSpawnInfo
{
    private final BlockState spawnBlock;

    public MuncherSpawnInfo(@Nullable BlockState spawnBlock) {
        this.spawnBlock = spawnBlock;
    }

    @Nullable
    public BlockState getSpawnBlock() {
        return this.spawnBlock;
    }

    @Override
    public String toString() {
        return "MuncherSpawnInfo{" + "spawnBlock=" + this.getSpawnBlock() + '}';
    }
}
