package couk.rob4001.robocraft.client.renderers;

import org.lwjgl.opengl.GL11;

import couk.rob4001.robocraft.client.models.ModelTinkerTable;
import couk.rob4001.robocraft.statics.Sprites;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelChest;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemTinkerTableRenderer implements IItemRenderer {
	
	private ModelTinkerTable tinkerTableModel;

	public ItemTinkerTableRenderer(){
		tinkerTableModel = new ModelTinkerTable(1/16F);
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
             renderTinkerTable(0.5F, 0.5F, 0.5F);
             break;
         }
         case EQUIPPED: {
             renderTinkerTable(0.5F, 1F, 0.5F);
             break;
         }
         case INVENTORY: {
             renderTinkerTable(0F, 1F, 0F);
             break;
         }
         default:
             break;
     }

	}
	
	private void renderTinkerTable(float x, float y, float z) {

        FMLClientHandler.instance().getClient().renderEngine.getTexture("/textures/chest.png");
        
        GL11.glPushMatrix(); //start
        GL11.glTranslatef(x, y, z); //size
        GL11.glRotatef(-180, 1, 0, 0);
        GL11.glRotatef(90, 0, 1, 0);
        tinkerTableModel.render(1/16F);
        GL11.glPopMatrix(); //end
    }

}
