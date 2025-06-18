package net.mcreator.hud.procedures;

import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.client.Minecraft;

import net.mcreator.hud.network.HudModVariables;
import net.mcreator.hud.HudMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Iterator;

@Mod.EventBusSubscriber
public class PlayerTicksProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HudModVariables.PlayerVariables())).ResetAnims == true) {
			if (world.isClientSide()) {
				SetupAnimationProcedure.setAnimationClientside((Player) entity, "player.revived", true);
			}
			if (!world.isClientSide()) {
				if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
					List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
					synchronized (connections) {
						Iterator<Connection> iterator = connections.iterator();
						while (iterator.hasNext()) {
							Connection connection = iterator.next();
							if (!connection.isConnecting() && connection.isConnected())
								HudMod.PACKET_HANDLER.sendTo(new SetupAnimationProcedure.HudModAnimationMessage(Component.literal("player.revived"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
						}
					}
				}
			}
		}
		if ((entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HudModVariables.PlayerVariables())).isReviving == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 21, 999, false, false));
		}
		if ((entity.getCapability(HudModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new HudModVariables.PlayerVariables())).isDown == true) {
			if ((new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity)) == (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
					}
					return false;
				}
			}.checkGamemode(entity) || true)) {
				if (entity instanceof Player _player) {
					_player.getAbilities().invulnerable = true;
					_player.onUpdateAbilities();
				}
			}
			if (entity.getDeltaMovement().x() < 1 && entity.getDeltaMovement().y() < 1 && entity.getDeltaMovement().z() < 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 21, 5, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 21, 128, false, false));
				if (world.isClientSide()) {
					SetupAnimationProcedure.setAnimationClientside((Player) entity, "player.downed", false);
				}
				if (!world.isClientSide()) {
					if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
						List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
						synchronized (connections) {
							Iterator<Connection> iterator = connections.iterator();
							while (iterator.hasNext()) {
								Connection connection = iterator.next();
								if (!connection.isConnecting() && connection.isConnected())
									HudMod.PACKET_HANDLER.sendTo(new SetupAnimationProcedure.HudModAnimationMessage(Component.literal("player.downed"), entity.getId(), false), connection, NetworkDirection.PLAY_TO_CLIENT);
							}
						}
					}
				}
			}
		} else {
			if ((new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity)) == (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
					}
					return false;
				}
			}.checkGamemode(entity) || true)) {
				if (entity instanceof Player _player) {
					_player.getAbilities().invulnerable = false;
					_player.onUpdateAbilities();
				}
			}
		}
	}
}
