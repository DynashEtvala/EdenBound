
package net.dynashetvala.edenbound.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.dynashetvala.edenbound.itemgroup.EdenboundToolsItemGroup;
import net.dynashetvala.edenbound.EdenboundModElements;

@EdenboundModElements.ModElement.Tag
public class PerfectlyGenericSwordItem extends EdenboundModElements.ModElement {
	@ObjectHolder("edenbound:perfectly_generic_sword")
	public static final Item block = null;
	public PerfectlyGenericSwordItem(EdenboundModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
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
		}, 3, -3f, new Item.Properties().group(EdenboundToolsItemGroup.tab)) {
		}.setRegistryName("perfectly_generic_sword"));
	}
}
