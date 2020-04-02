package ca.mathmatboy.axialcraft.BarSign;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelbarSign extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
  
  public ModelbarSign()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 18, 22);
      Shape1.addBox(-1F, 0F, 0F, 6, 1, 1);
      Shape1.setRotationPoint(-4F, 19F, 0F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 14, 18);
      Shape2.addBox(0F, 0F, 0F, 10, 3, 1);
      Shape2.setRotationPoint(-7F, 16F, 0F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 12, 15);
      Shape3.addBox(0F, 0F, 0F, 12, 2, 1);
      Shape3.setRotationPoint(-8F, 14F, 0F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 14, 13);
      Shape4.addBox(0F, 0F, 0F, 10, 1, 1);
      Shape4.setRotationPoint(-7F, 13F, 0F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 20, 26);
      Shape5.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape5.setRotationPoint(0F, 12F, 0F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 27, 26);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape6.setRotationPoint(-5F, 12F, 0F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 11, 28);
      Shape7.addBox(0F, 0F, 0F, 15, 1, 1);
      Shape7.setRotationPoint(-8F, 11F, 0F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 2, 25);
      Shape8.addBox(0F, 0F, 0F, 1, 3, 3);
      Shape8.setRotationPoint(7F, 10F, -1F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
  }
  
  public void renderAll()
  {
    Shape1.render(0.0625F);
    Shape2.render(0.0625F);
    Shape3.render(0.0625F);
    Shape4.render(0.0625F);
    Shape5.render(0.0625F);
    Shape6.render(0.0625F);
    Shape7.render(0.0625F);
    Shape8.render(0.0625F);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }


}
