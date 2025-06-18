package net.mcreator.hud.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HealthvariProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "| " + (new java.text.DecimalFormat("##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 5));
	}
}
