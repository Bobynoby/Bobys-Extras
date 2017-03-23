package com.bobynoby.blocks;

import com.bobynoby.main.MainRegistry;
import com.bobynoby.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockObbySmooth extends Block {

	public BlockObbySmooth() {
		super(Material.ROCK);
		setHardness(50.0F);
		setResistance(2000.0F);
		setCreativeTab(MainRegistry.CREATIVE_TAB_MAIN);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 3);
		setUnlocalizedName(Reference.BobyEXblocks.OBBYSMOOTH.getUnlocalizedName());
		setRegistryName(Reference.BobyEXblocks.OBBYSMOOTH.getRegistryName());

	}

}
