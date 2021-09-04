package com.bconlon.greathunger.client;

import com.bconlon.greathunger.client.renderer.entity.MuncherRenderer;
import com.bconlon.greathunger.common.registry.EntityTypeRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModRendering
{
    public static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeRegistry.MUNCHER.get(), MuncherRenderer::new);
    }
}
