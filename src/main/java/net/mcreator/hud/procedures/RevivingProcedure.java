package net.mcreator.hud.procedures;

import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.nbt.ListTag;

import net.mcreator.hud.network.HudModVariables;
import net.mcreator.hud.entity.RatsEntity;
import net.mcreator.hud.HudMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Iterator;

@Mod.EventBusSubscriber
public class RevivingProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ListTag rec;
		Entity kk = null;
		Entity AllPlayers = null;
		if (((entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HudModVariables.PlayerVariables())).isDown || entity instanceof RatsEntity _datEntL0 && _datEntL0.getEntityData().get(RatsEntity.DATA_IsDown)) == true) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Reviving"), false);
			if (world.isClientSide()) {
				SetupAnimationProcedure.setAnimationClientside((Player) sourceentity, "player.reviving", false);
			}
			if (!world.isClientSide()) {
				if (sourceentity instanceof Player && world instanceof ServerLevel srvLvl_) {
					List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
					synchronized (connections) {
						Iterator<Connection> iterator = connections.iterator();
						while (iterator.hasNext()) {
							Connection connection = iterator.next();
							if (!connection.isConnecting() && connection.isConnected())
								HudMod.PACKET_HANDLER.sendTo(new SetupAnimationProcedure.HudModAnimationMessage(Component.literal("player.reviving"), sourceentity.getId(), false), connection, NetworkDirection.PLAY_TO_CLIENT);
						}
					}
				}
			}
			{
				boolean _setval = true;
				sourceentity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isReviving = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			{
				boolean _setval = true;
				entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isBeingRevived = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " is reviving you")), true);
			HudMod.queueServerWork(80, () -> {
				if (((entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HudModVariables.PlayerVariables())).isDown
						|| entity instanceof RatsEntity _datEntL5 && _datEntL5.getEntityData().get(RatsEntity.DATA_IsDown)) == true) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " revived")), true);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(14);
					{
						boolean _setval = false;
						sourceentity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.isReviving = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						boolean _setval = true;
						entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ResetAnims = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			});
			HudMod.queueServerWork(90, () -> {
				{
					boolean _setval = false;
					entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ResetAnims = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
	}
}
