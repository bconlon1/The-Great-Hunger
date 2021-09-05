package com.bconlon.greathunger.common.spawning.setup;

import com.bconlon.greathunger.common.entity.AbstractMuncherEntity;
import com.bconlon.greathunger.common.spawning.MuncherSpawnInfo;
import com.bconlon.greathunger.core.api.MuncherVariant;
import com.bconlon.greathunger.core.registry.MuncherVariants;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;

import javax.annotation.Nullable;

public class MuncherBlockSpawnSetup implements IMuncherSpawnSetup
{
    private final String variantName;
    private final MuncherSpawnInfo spawnInfo;

    public MuncherBlockSpawnSetup(String variantName, MuncherSpawnInfo spawnInfo) {
        this.variantName = variantName;
        this.spawnInfo = spawnInfo;
    }

    @Override
    public void setupSpawn(AbstractMuncherEntity muncher, IServerWorld level, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        BlockState blockStandingOn = level.getBlockState(muncher.blockPosition().below());
        MuncherVariant muncherVariant = MuncherVariants.MUNCHER_VARIANTS.get(this.variantName);
        BlockState spawnInfoBlock = this.spawnInfo.getSpawnBlock();
        if (spawnInfoBlock != null && blockStandingOn.getBlock() == spawnInfoBlock.getBlock()) {
            muncher.setMuncherVariant(muncherVariant);
        }
    }
}
