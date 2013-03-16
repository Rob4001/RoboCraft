package couk.rob4001.robocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import couk.rob4001.robocraft.item.ModItems;

public class RCCreativeTab extends CreativeTabs {

	public RCCreativeTab() {
		super("RoboCraft");
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(ModItems.journal);
	}

}
