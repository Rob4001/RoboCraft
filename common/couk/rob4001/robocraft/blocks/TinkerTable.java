package couk.rob4001.robocraft.blocks;
import couk.rob4001.robocraft.CommonProxy;
import couk.rob4001.robocraft.statics.RenderIDs;
import couk.rob4001.robocraft.statics.Sprites;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TinkerTable extends Block {

        public TinkerTable (int id, int texture, Material material) {
                super(id, texture, material);
        }
        
        @Override
        public String getTextureFile () {
        	return Sprites.Model_TinkerTable;
        }
        
        @Override
        public boolean renderAsNormalBlock() {

            return false;
        }

        @Override
        public boolean isOpaqueCube() {

            return false;
        }

        @Override
        public int getRenderType() {

            return RenderIDs.TinkerTable;
        }

}