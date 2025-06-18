package net.mcreator.hud.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.hud.network.HudModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class DownEntityProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "down")) {
				{
					boolean _setval = true;
					entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.isDown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
