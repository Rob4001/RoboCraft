package couk.rob4001.robocraft.item;

import net.minecraft.item.Item;
import couk.rob4001.robocraft.CommonProxy;
import couk.rob4001.robocraft.RoboCraft;

public class RCItem extends Item {

	public RCItem(int id) {
		super(id + RoboCraft.idShift);
		this.setIconIndex(id);
		this.setCreativeTab(RoboCraft.creativeTab);
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}

}
