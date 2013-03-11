package couk.rob4001.robocraft.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelTinkerTable extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer BaseInner;
    ModelRenderer Column;
    ModelRenderer Shape1;
    
	private float scale;
  
  public ModelTinkerTable(float scale)
  {
	  
	  this.scale = scale;
    textureWidth = 128;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 52, 0);
      Base.addBox(-6F, -2F, -6F, 12, 4, 12,scale);
      Base.setRotationPoint(0F, 22F, 0F);
      Base.setTextureSize(128, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      BaseInner = new ModelRenderer(this, 64, 16);
      BaseInner.addBox(-5F, 0F, -4F, 10, 1, 8,scale);
      BaseInner.setRotationPoint(0F, 19F, 0F);
      BaseInner.setTextureSize(128, 64);
      BaseInner.mirror = true;
      setRotation(BaseInner, 0F, 0F, 0F);
      Column = new ModelRenderer(this, 40, 16);
      Column.addBox(-4F, 0F, -2F, 8, 5, 4,scale);
      Column.setRotationPoint(0F, 14F, 0F);
      Column.setTextureSize(128, 64);
      Column.mirror = true;
      setRotation(Column, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(-8F, 0F, -5F, 16, 6, 10,scale);
      Shape1.setRotationPoint(0F, 8F, 0F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
  }
  
  public void render(float scale)
  {
    Base.render(scale);
    BaseInner.render(scale);
    Column.render(scale);
    Shape1.render(scale);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  


}
