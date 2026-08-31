package dev.limucc.brutaltyping.client.mixin;

import dev.limucc.brutaltyping.client.compat.Gfx;
import dev.limucc.brutaltyping.client.engine.OverlayHooks;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** MC 26.2+: the in-game HUD extraction entry point moved from Gui to Hud. */
@Mixin(Hud.class)
public class GuiMixin {

    @Inject(method = "extractRenderState", at = @At("RETURN"))
    private void brutaltyping$hudOverlay(GuiGraphicsExtractor g, DeltaTracker delta, CallbackInfo ci) {
        OverlayHooks.hud(new Gfx(g));
    }
}
