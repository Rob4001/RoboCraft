package couk.rob4001.robocraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IngotCopper extends Item {

	public IngotCopper(int id) {
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		//TODO: Split icons setIconIndex(1);
		this.setUnlocalizedName("copperIngot");
	}
	
	public String getTextureFile() {
        return "/textures/items.png";
	}

}
