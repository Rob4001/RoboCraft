package couk.rob4001.robocraft.client.renderers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import couk.rob4001.robocraft.client.models.ModelTinkerTable;
import cpw.mods.fml.client.FMLClientHandler;

public class ItemTinkerTableRenderer implements IItemRenderer {

	private ModelTinkerTable tinkerTableModel;

	public ItemTinkerTableRenderer() {
		this.tinkerTableModel = new ModelTinkerTable(1 / 16F);
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		case ENTITY: {
			this.renderTinkerTable(0F, 1F, 0F);
			break;
		}
		case EQUIPPED: {
			this.renderTinkerTable(0.5F, 1F, 0.5F);
			break;
		}
		case INVENTORY: {
			this.renderTinkerTable(0F, 1F, 0F);
			break;
		}
		default:
			break;
		}

	}

	private void renderTinkerTable(float x, float y, float z) {

		FMLClientHandler.instance().getClient().renderEngine
				.getTexture("/textures/chest.png");

		GL11.glPushMatrix(); // start
		GL11.glTranslatef(x, y, z); // size
		GL11.glRotatef(-180, 1, 0, 0);
		GL11.glRotatef(90, 0, 1, 0);
		this.tinkerTableModel.render(1 / 16F);
		GL11.glPopMatrix(); // end
	}

}
