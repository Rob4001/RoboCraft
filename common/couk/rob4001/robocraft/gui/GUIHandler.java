package couk.rob4001.robocraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import couk.rob4001.robocraft.containers.ContainerTinkerTable;
import couk.rob4001.robocraft.statics.GuiIds;
import couk.rob4001.robocraft.tileentities.TileEntityTinkerTable;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		switch (ID) {
		case GuiIds.TinkerTable:
			return new ContainerTinkerTable(world, player.inventory,
					(TileEntityTinkerTable) world.getBlockTileEntity(x, y, z));

		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		switch (ID) {
		case GuiIds.TinkerTable:
			return new GUITinkerTable(world, player.inventory,
					(TileEntityTinkerTable) world.getBlockTileEntity(x, y, z));
		case GuiIds.Journal:
			return new GUIJournalRedo();
		}
		return null;
	}

}
