package net.mcreator.hud.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.hud.network.HudModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DownvardtstProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 6) {
			{
				boolean _setval = true;
				entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isDown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isDown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
