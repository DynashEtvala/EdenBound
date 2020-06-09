package net.dynashetvala.edenbound.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.dynashetvala.edenbound.item.SaveSlotItem;
import net.dynashetvala.edenbound.EdenboundModVariables;
import net.dynashetvala.edenbound.EdenboundModElements;

@EdenboundModElements.ModElement.Tag
public class EdenboundPlayerInitProcedure extends EdenboundModElements.ModElement {
	public EdenboundPlayerInitProcedure(EdenboundModElements instance) {
		super(instance, 44);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EdenboundPlayerInit!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure EdenboundPlayerInit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((!(entity.getPersistentData().getBoolean("playerInitEB")))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(SaveSlotItem.block, (int) (1));
				_setstack.setCount((int) (EdenboundModVariables.WorldVariables.get(world).InitialSaveSlotCount));
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			entity.getPersistentData().putBoolean("playerInitEB", (true));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.getPlayer();
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", (int) entity.getPosX());
		dependencies.put("y", (int) entity.getPosY());
		dependencies.put("z", (int) entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
