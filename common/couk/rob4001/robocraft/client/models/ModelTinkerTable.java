package couk.rob4001.robocraft.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelTinkerTable extends ModelBase {
	// fields
	ModelRenderer Base;
	ModelRenderer BaseInner;
	ModelRenderer Column;
	ModelRenderer Shape1;

	public ModelTinkerTable(float scale) {

		this.textureWidth = 128;
		this.textureHeight = 64;

		this.Base = new ModelRenderer(this, 52, 0);
		this.Base.addBox(-6F, 4F, -6F, 12, 4, 12, scale);
		this.Base.setRotationPoint(0F, 16F, 0F);
		this.Base.setTextureSize(128, 64);
		this.Base.mirror = true;
		this.setRotation(this.Base, 0F, 0F, 0F);
		this.BaseInner = new ModelRenderer(this, 64, 16);
		this.BaseInner.addBox(-5F, 3F, -4F, 10, 1, 8, scale);
		this.BaseInner.setRotationPoint(0F, 16F, 0F);
		this.BaseInner.setTextureSize(128, 64);
		this.BaseInner.mirror = true;
		this.setRotation(this.BaseInner, 0F, 0F, 0F);
		this.Column = new ModelRenderer(this, 40, 16);
		this.Column.addBox(-4F, -2F, -2F, 8, 5, 4, scale);
		this.Column.setRotationPoint(0F, 16F, 0F);
		this.Column.setTextureSize(128, 64);
		this.Column.mirror = true;
		this.setRotation(this.Column, 0F, 0F, 0F);
		this.Shape1 = new ModelRenderer(this, 0, 0);
		this.Shape1.addBox(-8F, -8F, -5F, 16, 6, 10, scale);
		this.Shape1.setRotationPoint(0F, 16F, 0F);
		this.Shape1.setTextureSize(128, 64);
		this.Shape1.mirror = true;
		this.setRotation(this.Shape1, 0F, 0F, 0F);
	}

	public void render(float scale) {
		this.Base.render(scale);
		this.BaseInner.render(scale);
		this.Column.render(scale);
		this.Shape1.render(scale);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
