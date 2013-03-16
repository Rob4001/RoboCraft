package couk.rob4001.robocraft.client.renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import couk.rob4001.robocraft.client.models.ModelTinkerTable;
import couk.rob4001.robocraft.statics.Sprites;
import couk.rob4001.robocraft.tileentities.TileEntityTinkerTable;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileTinkerTableRenderer<TileAlchemicalChest> extends
		TileEntitySpecialRenderer {

	private ModelTinkerTable modelTinkerTable = new ModelTinkerTable(1 / 16F);

	public void renderTinkerTable(TileEntityTinkerTable tileTinkerTable,
			double x, double y, double z, float tick) {

		ForgeDirection direction = null;

		if (tileTinkerTable.getWorldObj() != null) {
			direction = ForgeDirection.getOrientation(tileTinkerTable
					.getBlockMetadata());
		}

		int id = FMLClientHandler.instance().getClient().renderEngine
				.getTexture(Sprites.Model_TinkerTable);
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		short angle = 0;

		if (direction != null) {
			if (direction == ForgeDirection.NORTH) {
				angle = 180;
			} else if (direction == ForgeDirection.SOUTH) {
				angle = 0;
			} else if (direction == ForgeDirection.WEST) {
				angle = 90;
			} else if (direction == ForgeDirection.EAST) {
				angle = -90;
			}
		}
		GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0, -1F, 0);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(id);
		this.modelTinkerTable.render(1 / 16F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y,
			double z, float tick) {

		this.renderTinkerTable((TileEntityTinkerTable) tileEntity, x, y, z,
				tick);
	}
}
