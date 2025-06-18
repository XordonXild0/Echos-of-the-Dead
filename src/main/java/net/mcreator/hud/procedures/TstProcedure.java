package net.mcreator.hud.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class TstProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double amount = 0;
		return new java.text.DecimalFormat("##").format(entity instanceof Player _plr ? _plr.experienceLevel : 0);
	}
}
