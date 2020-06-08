
package net.dynashetvala.edenbound.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.dynashetvala.edenbound.item.PerfectlyGenericArmorItem;
import net.dynashetvala.edenbound.EdenboundModElements;

@EdenboundModElements.ModElement.Tag
public class EdenboundArmorItemGroup extends EdenboundModElements.ModElement {
	public EdenboundArmorItemGroup(EdenboundModElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabedenbound_armor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PerfectlyGenericArmorItem.helmet, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
