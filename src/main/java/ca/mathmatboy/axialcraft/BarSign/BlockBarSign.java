package ca.mathmatboy.axialcraft.BarSign;

import ca.mathmatboy.axialcraft.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockBarSign extends Block{

	public BlockBarSign(Material material)
	{
		super(material);
	}
	   public boolean hasTileEntity(int metadata)
	    {
	        return true;
	    }
	   
	    public TileEntity createTileEntity(World world, int metadata)
	    {
	        return new TileEntityBlockBarSign();
	    }
	    
	    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	    {
	        if(stack.getItemDamage() == 0)
	        {
	            TileEntity tile = world.getTileEntity(x, y, z);
	            if(tile instanceof TileEntityBlockBarSign)
	            {
	                int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
	                ((TileEntityBlockBarSign)tile).setDirection((byte)direction);
	            }
	        }
	    }
	    
	    @Override
	    public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis)
	    {
	        if((axis == ForgeDirection.UP || axis == ForgeDirection.DOWN) && !world.isRemote && world.getBlockMetadata(x, y, z) == 0)
	        {
	            TileEntity tile = world.getTileEntity(x, y, z);
	            if(tile instanceof TileEntityBlockBarSign)
	            {
	            	TileEntityBlockBarSign tileDirectional = (TileEntityBlockBarSign)tile;
	                byte direction = tileDirectional.getDirection();
	                direction++;
	                if(direction > 3)
	                {
	                    direction = 0;
	                }
	                tileDirectional.setDirection(direction);
	                return true;
	            }
	        }
	        return false;
	    }

	    public ForgeDirection[] getValidRotations(World world, int x, int y, int z)
	    {
	        return world.getBlockMetadata(x, y, z) == 0 ? new ForgeDirection[] {ForgeDirection.UP, ForgeDirection.DOWN} : ForgeDirection.VALID_DIRECTIONS;
	    }
	
	    
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }
	    
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
	    
	    public int getRenderType()
	    {
	        return ClientProxy.tesrRenderId;
	    }



}
