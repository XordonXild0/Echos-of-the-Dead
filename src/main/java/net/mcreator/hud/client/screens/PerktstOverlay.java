
package net.mcreator.hud.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.hud.procedures.IsrevingProcedure;
import net.mcreator.hud.procedures.IsdownedProcedure;
import net.mcreator.hud.procedures.IsBeingRevivedProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class PerktstOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (IsdownedProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("hud:textures/screens/downedicon.png"), 73, h - 46, 0, 0, 16, 16, 16, 16);
			}
			if (IsrevingProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("hud:textures/screens/resingicon.png"), w / 2 + -15, h / 2 + -86, 0, 0, 32, 32, 32, 32);
			}
			if (IsBeingRevivedProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("hud:textures/screens/resingicon.png"), 73, h - 46, 0, 0, 16, 16, 16, 16);
			}
			if (IsdownedProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("hud:textures/screens/downedhighlight.png"), 9, h - 46, 0, 0, 64, 16, 64, 16);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
