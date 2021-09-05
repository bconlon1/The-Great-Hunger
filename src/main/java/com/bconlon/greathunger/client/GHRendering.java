package com.bconlon.greathunger.client;

import com.bconlon.greathunger.client.renderer.entity.MuncherRenderer;
import com.bconlon.greathunger.common.registry.GHEntityTypeRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class GHRendering
{
    public static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(GHEntityTypeRegistry.MUNCHER.get(), MuncherRenderer::new);
    }
}
