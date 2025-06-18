
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hud.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.hud.HudMod;

public class HudModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, HudMod.MODID);
	public static final RegistryObject<Item> RATS_SPAWN_EGG = REGISTRY.register("rats_spawn_egg", () -> new ForgeSpawnEggItem(HudModEntities.RATS, -26113, -26215, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
