package net.mcreator.hud.procedures;

import net.minecraft.commands.CommandSourceStack;

import net.mcreator.hud.network.HudModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class ForceStartGameProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		HudModVariables.IsGameStarted = BoolArgumentType.getBool(arguments, "fgs");
	}
}
