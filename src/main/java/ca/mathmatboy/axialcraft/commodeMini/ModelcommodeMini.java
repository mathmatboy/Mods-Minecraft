package ca.mathmatboy.axialcraft.commodeMini;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelcommodeMini extends ModelBase
{
  //fields
    ModelRenderer Counter;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Case;
    ModelRenderer Drawer1;
    ModelRenderer Handle1;
    ModelRenderer Drawer2;
    ModelRenderer Handle2;
  
  public ModelcommodeMini()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Counter = new ModelRenderer(this, 0, 0);
      Counter.addBox(-8F, -1F, -8F, 16, 1, 16);
      Counter.setRotationPoint(0F, 9F, 0F);
      Counter.setTextureSize(128, 64);
      Counter.mirror = true;
      setRotation(Counter, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 64, 0);
      Leg1.addBox(-0.5F, 0F, -0.5F, 2, 15, 2);
      Leg1.setRotationPoint(-7F, 9F, -7F);
      Leg1.setTextureSize(128, 64);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 64, 0);
      Leg2.addBox(-1.5F, 0F, -0.5F, 2, 15, 2);
      Leg2.setRotationPoint(7F, 9F, -7F);
      Leg2.setTextureSize(128, 64);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 64, 0);
      Leg3.addBox(-1.5F, 0F, -1.5F, 2, 15, 2);
      Leg3.setRotationPoint(7F, 9F, 7F);
      Leg3.setTextureSize(128, 64);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 64, 0);
      Leg4.addBox(-0.5F, 0F, -1.5F, 2, 15, 2);
      Leg4.setRotationPoint(-7F, 9F, 7F);
      Leg4.setTextureSize(128, 64);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      Case = new ModelRenderer(this, 0, 17);
      Case.addBox(-7F, 0F, -7F, 14, 12, 14);
      Case.setRotationPoint(0F, 9F, 0F);
      Case.setTextureSize(128, 64);
      Case.mirror = true;
      setRotation(Case, 0F, 0F, 0F);
      Drawer1 = new ModelRenderer(this, 0, 43);
      Drawer1.addBox(-5F, -2F, -1F, 10, 4, 1);
      Drawer1.setRotationPoint(0F, 12F, -7F);
      Drawer1.setTextureSize(128, 64);
      Drawer1.mirror = true;
      setRotation(Drawer1, 0F, 0F, 0F);
      Handle1 = new ModelRenderer(this, 0, 48);
      Handle1.addBox(-0.5F, -0.5F, -1F, 1, 1, 1);
      Handle1.setRotationPoint(0F, 12F, -8F);
      Handle1.setTextureSize(128, 64);
      Handle1.mirror = true;
      setRotation(Handle1, 0F, 0F, 0F);
      Drawer2 = new ModelRenderer(this, 0, 43);
      Drawer2.addBox(-5F, -2F, -1F, 10, 4, 1);
      Drawer2.setRotationPoint(0F, 18F, -7F);
      Drawer2.setTextureSize(128, 64);
      Drawer2.mirror = true;
      setRotation(Drawer2, 0F, 0F, 0F);
      Handle2 = new ModelRenderer(this, 0, 48);
      Handle2.addBox(-0.5F, -0.5F, -1F, 1, 1, 1);
      Handle2.setRotationPoint(0F, 18F, -8F);
      Handle2.setTextureSize(128, 64);
      Handle2.mirror = true;
      setRotation(Handle2, 0F, 0F, 0F);
  }
  
  public void renderAll()
  {
    Counter.render(0.0625F);
    Leg1.render(0.0625F);
    Leg2.render(0.0625F);
    Leg3.render(0.0625F);
    Leg4.render(0.0625F);
    Case.render(0.0625F);
    Drawer1.render(0.0625F);
    Handle1.render(0.0625F);
    Drawer2.render(0.0625F);
    Handle2.render(0.0625F);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
