package couk.rob4001.robocraft;

import couk.rob4001.robocraft.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RCCreativeTab extends CreativeTabs{

	public RCCreativeTab() {
		super("RoboCraft");
	}
	
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(ModItems.journal);
	}

}
