package com.bconlon.greathunger.common.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class AbstractMuncherEntity extends CreatureEntity
{
    protected AbstractMuncherEntity(EntityType<? extends CreatureEntity> entityType, World level) {
        super(entityType, level);
    }

    //TODO: Enchantment module handling can mainly be put in here.

}
