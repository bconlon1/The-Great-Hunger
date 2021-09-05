package com.bconlon.greathunger.common.registry;

import com.bconlon.greathunger.GreatHunger;
import com.bconlon.greathunger.common.entity.AbstractMuncherEntity;
import com.bconlon.greathunger.common.entity.MuncherEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
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
        EntitySpawnPlacementRegistry.register(EntityTypeRegistry.MUNCHER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractMuncherEntity::canSpawn);
    }

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityTypeRegistry.MUNCHER.get(), MuncherEntity.createMobAttributes().build());
    }

    @Mod.EventBusSubscriber
    public static class BiomeSpawning
    {
        @SubscribeEvent
        public static void registerBiomeSpawns(BiomeLoadingEvent event) {
            if (event.getName() != null) {
                ResourceLocation name = event.getName();
                RegistryKey<Biome> biome = RegistryKey.create(Registry.BIOME_REGISTRY, name);
                if (BiomeDictionary.getTypes(biome).contains(BiomeDictionary.Type.OVERWORLD)) {
                    event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(EntityTypeRegistry.MUNCHER.get(), 50, 1, 1)); //TODO: Weight might need balancing later.
                }
            }
        }
    }
}
