package com.bconlon.greathunger.common.entity;

import com.bconlon.greathunger.GreatHunger;
import com.bconlon.greathunger.common.registry.EntityTypeRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class MuncherEntity extends AbstractMuncherEntity
{
    public MuncherEntity(EntityType<? extends CreatureEntity> entityType, World level) {
        super(entityType, level);
    }

    public MuncherEntity(World level) {
        super(EntityTypeRegistry.MUNCHER.get(), level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

    }

    public static AttributeModifierMap.MutableAttribute createMobAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld level, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        spawnData = super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
        this.setSpawnFacing(this.random.nextInt(4));
        return spawnData;
    }

    private void setSpawnFacing(int num) {
        switch (num) {
            case 0:
                this.setRot(0, this.xRot);
            case 1:
                this.setRot(90, this.xRot);
            case 2:
                this.setRot(180, this.xRot);
            case 3:
                this.setRot(270, this.xRot);
        }
    }
}
