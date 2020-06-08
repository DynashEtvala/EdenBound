
package net.dynashetvala.edenbound.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.dynashetvala.edenbound.itemgroup.EdenboundItemsItemGroup;
import net.dynashetvala.edenbound.EdenboundModElements;

@EdenboundModElements.ModElement.Tag
public class PerfectlyGenericObjectItem extends EdenboundModElements.ModElement {
	@ObjectHolder("edenbound:perfectly_generic_object")
	public static final Item block = null;
	public PerfectlyGenericObjectItem(EdenboundModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(EdenboundItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("perfectly_generic_object");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
