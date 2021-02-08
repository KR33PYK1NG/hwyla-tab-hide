package rmc.mixins.hwyla_tab_hide;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import mcp.mobius.waila.WailaClient;
import mcp.mobius.waila.overlay.OverlayRenderer;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Developed by RMC Team, 2021
 */
@Mixin(value = WailaClient.class)
public abstract class WailaClientMixin {

    @Overwrite @SubscribeEvent
    public static void onRenderTick(TickEvent.RenderTickEvent event) {
        if (event.phase == TickEvent.Phase.END
         && !Minecraft.getInstance().gameSettings.keyBindPlayerList.isKeyDown())
            OverlayRenderer.renderOverlay();
    }

}