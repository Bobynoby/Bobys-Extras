package com.bobynoby.items.tools;

import java.util.List;

import com.bobynoby.init.ConfigManager;
import com.bobynoby.main.MainRegistry;
import com.bobynoby.main.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import scala.util.Random;

public class ToolEnderAxe extends ItemAxe {

	public ToolEnderAxe(ToolMaterial material) {
		super(material, 12f, -2f);
		setCreativeTab(MainRegistry.CREATIVE_TAB_TOOL);
		setUnlocalizedName(Reference.BobyEXitems.ENDERAXE.getUnlocalizedName());
		setRegistryName(Reference.BobyEXitems.ENDERAXE.getRegistryName());
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		if (ConfigManager.enchantEnderToolsOnCraft == true) {
    	stack.addEnchantment(Enchantment.getEnchantmentByID(21), 5);
    	stack.addEnchantment(Enchantment.getEnchantmentByID(70), 1);
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		if (ConfigManager.generateParticlesOnEnderTools == true) {
			Random rand = new Random();
			double x = -0.7 + rand.nextFloat() * (0.7 - -0.7);
			double z = -0.7 + rand.nextFloat() * (0.7 - -0.7);
			double y = -0.7 + rand.nextFloat() * (0.7 - -0.7);
			if (entity instanceof EntityPlayer) {          
				EntityPlayer Player = (EntityPlayer) entity;
				if(Player.getHeldItemMainhand() != null && Player.getHeldItemMainhand().getItem() instanceof ToolEnderAxe) {
					if (world.isRemote) {
						world.spawnParticle(EnumParticleTypes.WATER_WAKE, entity.posX + x, (entity.posY + 1.0) + y, entity.posZ + z, 0.0D, 0.0D, 0.0D, new int[0]);
						
	        		}
				}
			}
		}
	}
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	par3List.add("�9Its made of water that is solid,");
    	par3List.add("�9But its not ice? Strange...");
    	
    }

}
