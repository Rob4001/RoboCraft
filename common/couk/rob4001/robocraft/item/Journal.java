package couk.rob4001.robocraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import couk.rob4001.robocraft.RoboCraft;
import couk.rob4001.robocraft.statics.GuiIds;

public class Journal extends RCItem {

	public Journal(int id) {
		super(id);
		this.setUnlocalizedName("journal");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer entityPlayer) {

		entityPlayer.openGui(RoboCraft.instance, GuiIds.Journal, world,
				entityPlayer.serverPosX, entityPlayer.serverPosY,
				entityPlayer.serverPosZ);
		return itemStack;
	}

}
