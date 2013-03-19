package couk.rob4001.robocraft.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import couk.rob4001.robocraft.containers.ContainerTinkerTable;
import couk.rob4001.robocraft.tileentities.TileEntityTinkerTable;

public class GUITinkerTable extends GuiContainer {

	public GUITinkerTable(World world, InventoryPlayer player,
			TileEntityTinkerTable te) {
		// Container created and passed to super for handling
		super(new ContainerTinkerTable(world, player, te));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		// draw text and stuff here
		// the parameters for drawString are: string, x, y, color
		this.fontRenderer.drawString("Tinker Table", 8, 6, 4210752);
		// draws "Inventory" or your regional equivalent
		this.fontRenderer.drawString(
				StatCollector.translateToLocal("container.inventory"), 8,
				this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		// draw your Gui here, only thing you need to change is the path
		int texture = this.mc.renderEngine.getTexture("/gui/tt.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		super.initGui();
		// make buttons

		/** no longer needed (I hope)
		GuiButton research = new GuiButton(1,
				((this.width - this.xSize) / 2) + 8,
				((this.height - this.ySize) / 2) + (this.ySize / 2) - 35, 50,
				20, "Research");
		// id, x, y, width, height, text
		this.controlList.add(research);
		**/
	}

	@Override
	protected void actionPerformed(GuiButton guibutton) {
		// id is the id you give your button
		// switch(guibutton.id) { //Only needed if multiple buttons
		// case 1:
		// Do something
		// break;
		// }
	}

}
