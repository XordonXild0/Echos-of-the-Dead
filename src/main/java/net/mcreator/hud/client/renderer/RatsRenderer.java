
package net.mcreator.hud.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.hud.entity.RatsEntity;

public class RatsRenderer extends HumanoidMobRenderer<RatsEntity, HumanoidModel<RatsEntity>> {
	public RatsRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<RatsEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(RatsEntity entity) {
		return new ResourceLocation("hud:textures/entities/aesthetic-duck.png");
	}
}
