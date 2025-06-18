package net.mcreator.hud.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.hud.network.HudModVariables;

public class IsBeingRevivedProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HudModVariables.PlayerVariables())).isBeingRevived == true;
	}
}
