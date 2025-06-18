package net.mcreator.hud.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.hud.network.HudModVariables;
import net.mcreator.hud.entity.RatsEntity;

public class RatsOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.isDown = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof RatsEntity _datEntSetL)
			_datEntSetL.getEntityData().set(RatsEntity.DATA_IsDown, true);
	}
}
