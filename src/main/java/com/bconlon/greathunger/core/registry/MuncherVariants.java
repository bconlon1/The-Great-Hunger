package com.bconlon.greathunger.core.registry;

import com.bconlon.greathunger.GreatHunger;
import com.bconlon.greathunger.common.spawning.setup.IMuncherSpawnSetup;
import com.bconlon.greathunger.common.spawning.MuncherSpawnInfo;
import com.bconlon.greathunger.core.api.MuncherVariant;

import javax.annotation.Nullable;
import java.util.*;

public class MuncherVariants
{
    public static Map<String, MuncherVariant> MUNCHER_VARIANTS = new HashMap<>();
    public static Map<String, IMuncherSpawnSetup> MUNCHER_SPAWNING = new HashMap<>();

    public static final MuncherVariant DEFAULT_STONE = register("default_stone", GreatHunger.MOD_ID,
            "textures/entity/muncher/stone/muncher.png", "textures/entity/muncher/stone/muncher_hiding.png",
            null, null);

    public static MuncherVariant register(String registryName, String modId, String defaultTextureLocation, String hidingTextureLocation, @Nullable MuncherSpawnInfo spawningInfo, @Nullable IMuncherSpawnSetup spawningSetup) {
        MuncherVariant muncherVariant = new MuncherVariant(registryName, modId, defaultTextureLocation, hidingTextureLocation);
        MUNCHER_VARIANTS.put(registryName, muncherVariant);
        if (spawningInfo != null && spawningSetup != null) {
            MUNCHER_SPAWNING.put(spawningInfo.toString(), spawningSetup);
        }
        return muncherVariant;
    }
}
