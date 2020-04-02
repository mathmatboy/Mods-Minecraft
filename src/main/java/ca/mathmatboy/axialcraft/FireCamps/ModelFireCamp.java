package ca.mathmatboy.axialcraft.FireCamps;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelFireCamp extends ModelBase
{
    ModelRenderer Shape1;
  
  public ModelFireCamp()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 12, 2, 12);
      Shape1.setRotationPoint(-6F, 22F, -6F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = false;
      setRotation(Shape1, 0F, 0F, 0F);
  }
  
  public void renderAll()
  {
    Shape1.render(0.0625F);

  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  


}
