package net.mcreator.hud.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class CreateGroupProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("team add Group".replace("Group", entity.getDisplayName().getString())));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("team join Group @s".replace("Group", entity.getDisplayName().getString())));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("team modify Group friendlyFire false".replace("Group", entity.getDisplayName().getString())));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("team modify Group seeFriendlyInvisibles false".replace("Group", entity.getDisplayName().getString())));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("team modify Group collisionRule always".replace("Group", entity.getDisplayName().getString())));
		if (Math.random() < 0.7) {
			if (Math.random() < 0.1428571428571429) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("team modify Group color aqua".replace("Group", entity.getDisplayName().getString() + " color aqua" + "aqua".replace("aqua", "dark_red"))));
			}
			if (Math.random() < 0.1428571428571429) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("team modify Group color aqua".replace("Group", entity.getDisplayName().getString() + " color aqua" + "aqua".replace("aqua", "red"))));
			}
			if (Math.random() < 0.1428571428571429) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("team modify Group color aqua".replace("Group", entity.getDisplayName().getString() + " color aqua" + "aqua".replace("aqua", "gold"))));
			}
			if (Math.random() < 0.1428571428571429) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("team modify Group color aqua".replace("Group", entity.getDisplayName().getString() + " color aqua" + "aqua".replace("aqua", "green"))));
			}
			if (Math.random() < 0.1428571428571429) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("team modify Group color aqua".replace("Group", entity.getDisplayName().getString() + " color aqua" + "aqua".replace("aqua", "dark_blue"))));
			}
			if (Math.random() < 0.1428571428571429) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("team modify Group color aqua".replace("Group", entity.getDisplayName().getString() + " color aqua" + "aqua".replace("aqua", "light_purple"))));
			}
			if (Math.random() < 0.1428571428571429) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("team modify Group color aqua".replace("Group", entity.getDisplayName().getString() + " color aqua" + "aqua".replace("aqua", "dark_purple"))));
			}
		}
	}
}
