package com.bconlon.greathunger.common.entity;

import com.bconlon.greathunger.GreatHunger;
import com.bconlon.greathunger.common.registry.GHTagsRegistry;
import com.bconlon.greathunger.common.spawning.MuncherSpawnInfo;
import com.bconlon.greathunger.common.spawning.setup.IMuncherSpawnSetup;
import com.bconlon.greathunger.core.api.MuncherVariant;
import com.bconlon.greathunger.core.registry.MuncherVariants;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Random;

//TODO: Enchantment module handling can mainly be put in here, as well as variant spawn parameters.
public abstract class AbstractMuncherEntity extends CreatureEntity
{
    public static final DataParameter<String> DATA_VARIANT_ID = EntityDataManager.defineId(AbstractMuncherEntity.class, DataSerializers.STRING);
    public static final DataParameter<Boolean> DATA_HIDING_ID = EntityDataManager.defineId(AbstractMuncherEntity.class, DataSerializers.BOOLEAN); //TODO: Might switch to an enum since the entity will have a couple different states.

    protected AbstractMuncherEntity(EntityType<? extends CreatureEntity> entityType, World level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VARIANT_ID, MuncherVariants.DEFAULT_STONE.getRegistryName());
        this.entityData.define(DATA_HIDING_ID, true);
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld level, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        spawnData = super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
        BlockState blockStandingOn = level.getBlockState(this.blockPosition().below());
        String spawnInfo = new MuncherSpawnInfo(blockStandingOn).toString();
        Map<String, IMuncherSpawnSetup> muncherSpawning = MuncherVariants.MUNCHER_SPAWNING;
        if (muncherSpawning.containsKey(spawnInfo)) {
            muncherSpawning.get(spawnInfo).setupSpawn(this, level, difficulty, reason, spawnData, dataTag);
        }
        GreatHunger.LOGGER.info(this.blockPosition().below() + ": " + blockStandingOn);
        return spawnData;
    }

    public MuncherVariant getMuncherVariant() {
        return MuncherVariants.MUNCHER_VARIANTS.get(this.entityData.get(DATA_VARIANT_ID));
    }

    public void setMuncherVariant(MuncherVariant muncherVariant) {
        this.entityData.set(DATA_VARIANT_ID, muncherVariant.getRegistryName());
    }

    public boolean getHiding() {
        return this.entityData.get(DATA_HIDING_ID);
    }

    public void setHiding(boolean hiding) {
        this.entityData.set(DATA_HIDING_ID, hiding);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.setMuncherVariant(MuncherVariants.MUNCHER_VARIANTS.get(compound.getString("MuncherVariant")));
        this.setHiding(compound.getBoolean("Hiding"));
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("MuncherVariant", this.getMuncherVariant().getRegistryName());
        compound.putBoolean("Hiding", this.getHiding());
    }

    public static boolean canSpawn(EntityType<? extends AbstractMuncherEntity> muncher, IServerWorld level, SpawnReason reason, BlockPos pos, Random random) {
        return level.getDifficulty() != Difficulty.PEACEFUL
                && level.getBlockState(pos.below()).getBlock().is(GHTagsRegistry.Blocks.MUNCHER_SPAWNING_BLOCKS)
                && pos.getY() <= 30
                && MonsterEntity.isDarkEnoughToSpawn(level, pos, random)
                && MonsterEntity.checkMobSpawnRules(muncher, level, reason, pos, random);
    }
}
