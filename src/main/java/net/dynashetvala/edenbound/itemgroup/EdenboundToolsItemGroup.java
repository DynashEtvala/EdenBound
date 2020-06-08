
package net.dynashetvala.edenbound.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.dynashetvala.edenbound.item.PerfectlyGenericPickaxeItem;
import net.dynashetvala.edenbound.EdenboundModElements;

@EdenboundModElements.ModElement.Tag
public class EdenboundToolsItemGroup extends EdenboundModElements.ModElement {
	public EdenboundToolsItemGroup(EdenboundModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabedenbound_tools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PerfectlyGenericPickaxeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
