package com.bconlon.greathunger.common.registry;

import com.bconlon.greathunger.GreatHunger;
import com.bconlon.greathunger.common.entity.MuncherEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = GreatHunger.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypeRegistry
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, GreatHunger.MOD_ID);

    public static final EntityType<MuncherEntity> MUNCHER_TYPE = EntityType.Builder.<MuncherEntity>of(MuncherEntity::new, EntityClassification.MONSTER).sized(2.4F, 2.4F).build("muncher");
    public static final RegistryObject<EntityType<MuncherEntity>> MUNCHER = ENTITIES.register("muncher", () -> MUNCHER_TYPE);

    public static void registerSpawnPlacements() {

    }

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityTypeRegistry.MUNCHER.get(), MuncherEntity.createMobAttributes().build());
    }
}
