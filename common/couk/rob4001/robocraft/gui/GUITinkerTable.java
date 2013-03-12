package couk.rob4001.robocraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import couk.rob4001.robocraft.containers.ContainerTinkerTable;
import couk.rob4001.robocraft.tileentities.TileEntityTinkerTable;

public class GUITinkerTable extends GuiContainer {

	public GUITinkerTable(InventoryPlayer player, TileEntityTinkerTable te) {
		//Container created and passed to super for handling
		super(new ContainerTinkerTable(player, te));		
	}
	
	@Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
            //draw text and stuff here
            //the parameters for drawString are: string, x, y, color
            fontRenderer.drawString("Tinker Table", 8, 6, 4210752);
            //draws "Inventory" or your regional equivalent
            fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		//draw your Gui here, only thing you need to change is the path
        int texture = mc.renderEngine.getTexture("/gui/tt.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(texture);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
	}

}
