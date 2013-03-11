package couk.rob4001.robocraft.blocks;
import couk.rob4001.robocraft.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TinkerTable extends Block {

        public TinkerTable (int id, int texture, Material material) {
                super(id, texture, material);
        }
        
        @Override
        public String getTextureFile () {
        	return CommonProxy.BLOCK_PNG;
        }

}