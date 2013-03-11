package couk.rob4001.robocraft.item;

import couk.rob4001.robocraft.CommonProxy;
import couk.rob4001.robocraft.RoboCraft;
import net.minecraft.item.Item;

public class RCItem extends Item{

	public RCItem(int id) {
		super(id + RoboCraft.idShift);
		this.setIconIndex(id);
	}
	
	@Override
	public String getTextureFile () {
        return CommonProxy.ITEMS_PNG;
}

}
