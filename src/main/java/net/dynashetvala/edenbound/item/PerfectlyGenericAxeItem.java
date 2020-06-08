
package net.dynashetvala.edenbound.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.dynashetvala.edenbound.itemgroup.EdenboundToolsItemGroup;
import net.dynashetvala.edenbound.EdenboundModElements;

@EdenboundModElements.ModElement.Tag
public class PerfectlyGenericAxeItem extends EdenboundModElements.ModElement {
	@ObjectHolder("edenbound:perfectly_generic_axe")
	public static final Item block = null;
	public PerfectlyGenericAxeItem(EdenboundModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 50;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PerfectlyGenericObjectItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(EdenboundToolsItemGroup.tab)) {
		}.setRegistryName("perfectly_generic_axe"));
	}
}
