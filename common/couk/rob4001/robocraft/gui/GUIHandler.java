package couk.rob4001.robocraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		//TODO
		//if (tileEntity instanceof TileEntityTinkerTable) {
			//return new ContainerTinkerTable(player.inventory, (TileEntityTinkerTable) tileEntity);
		//}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		//TODO
		//if(tileEntity instanceof TileEntityTinkerTable){
            //return new GuiTT(player.inventory, (TileEntityTinkerTable) tileEntity);
		//}
		return null;
	}

}
