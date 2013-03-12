package couk.rob4001.robocraft.client.renderers;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import couk.rob4001.robocraft.client.models.ModelTinkerTable;
import couk.rob4001.robocraft.statics.Sprites;
import couk.rob4001.robocraft.tileentities.TileEntityTinkerTable;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class TileTinkerTableRenderer<TileAlchemicalChest> extends
        TileEntitySpecialRenderer {

    private ModelTinkerTable modelTinkerTable = new ModelTinkerTable(1/16F);

    public void renderTinkerTable(TileEntityTinkerTable tileAlchemicalChest, double x, double y, double z, float tick) {

        ForgeDirection direction = null;

        if (tileAlchemicalChest.getWorldObj() != null) {
            direction = ForgeDirection.getOrientation(tileAlchemicalChest.getBlockMetadata());
        }

        FMLClientHandler.instance().getClient().renderEngine.getTexture(Sprites.Model_TinkerTable);
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
            }
            else if (direction == ForgeDirection.SOUTH) {
                angle = 0;
            }
            else if (direction == ForgeDirection.WEST) {
                angle = 90;
            }
            else if (direction == ForgeDirection.EAST) {
                angle = -90;
            }
        }
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        modelTinkerTable.render(1/16F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {

        renderTinkerTable((TileEntityTinkerTable) tileEntity, x, y, z, tick);
    }
}
