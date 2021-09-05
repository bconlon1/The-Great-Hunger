package com.bconlon.greathunger.common.spawning.setup;

import com.bconlon.greathunger.common.entity.AbstractMuncherEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;

import javax.annotation.Nullable;

public interface IMuncherSpawnSetup
{
    void setupSpawn(AbstractMuncherEntity muncher, IServerWorld level, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag);
}
