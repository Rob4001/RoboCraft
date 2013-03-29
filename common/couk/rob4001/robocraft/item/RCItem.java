package couk.rob4001.robocraft.item;

import net.minecraft.item.Item;
import couk.rob4001.robocraft.RoboCraft;
import couk.rob4001.robocraft.statics.Sprites;

public class RCItem extends Item {

	public RCItem(int id) {
		super(id + RoboCraft.idShift);
		//TODO Split items this.setIconIndex(id);
		this.setCreativeTab(RoboCraft.creativeTab);
	}

}
