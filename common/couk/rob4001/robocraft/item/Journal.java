package couk.rob4001.robocraft.item;

import couk.rob4001.robocraft.RoboCraft;
import couk.rob4001.robocraft.statics.GuiIds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Journal extends RCItem {

	public Journal(int id) {
		super(id);
		this.setItemName("Scientific Journal");
	}
	
	public boolean onItemUse(ItemStack par1ItemStack,
            EntityPlayer entityPlayer,
            World world,
            int x,
            int y,
            int z,
            int par7,
            float par8,
            float par9,
            float par10){
		
		entityPlayer.openGui(RoboCraft.instance, GuiIds.Journal, world, x, y, z);
		return true;
	}

}
