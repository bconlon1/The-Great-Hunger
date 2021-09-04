package com.bconlon.greathunger.common.entity;

import com.bconlon.greathunger.common.registry.EntityTypeRegistry;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class MuncherEntity extends AbstractMuncherEntity
{
    public MuncherEntity(EntityType<? extends CreatureEntity> entityType, World level) {
        super(entityType, level);
    }

    public MuncherEntity(World level) {
        super(EntityTypeRegistry.MUNCHER.get(), level);
    }

    public static AttributeModifierMap.MutableAttribute createMobAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }
}
