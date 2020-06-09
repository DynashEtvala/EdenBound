package net.dynashetvala.edenbound.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.dynashetvala.edenbound.item.DynashArmorItem;
import net.dynashetvala.edenbound.EdenboundModElements;

@EdenboundModElements.ModElement.Tag
public class DynashArmorLeggingsTickEventProcedure extends EdenboundModElements.ModElement {
	public DynashArmorLeggingsTickEventProcedure(EdenboundModElements instance) {
		super(instance, 41);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DynashArmorLeggingsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Cooldown = 0;
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(DynashArmorItem.helmet, (int) (1)).getItem())) {
			if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
					.getItem() == new ItemStack(DynashArmorItem.body, (int) (1)).getItem())) {
				if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(DynashArmorItem.legs, (int) (1)).getItem())) {
					if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
							.getItem() == new ItemStack(DynashArmorItem.boots, (int) (1)).getItem())) {
						if (((Cooldown) <= 0)) {
							if ((entity.isSneaking())) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 6000, (int) 5, (false), (false)));
								Cooldown = (double) 12000;
							}
						} else {
							Cooldown = (double) ((Cooldown) - 1);
						}
					}
				}
			}
		}
	}
}
