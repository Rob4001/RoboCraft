package couk.rob4001.robocraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import couk.rob4001.robocraft.RoboCraft;
import couk.rob4001.robocraft.statics.Sprites;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RCItem extends Item {

	public RCItem(int id) {
		super(id + RoboCraft.idShift);
		//TODO Split items this.setIconIndex(id);
		this.setCreativeTab(RoboCraft.creativeTab);
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {
String name = "robo:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1);
System.out.println("Regestered icon for " + name);
        iconIndex = iconRegister.registerIcon(name);
    }

}
