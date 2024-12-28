package floffytoffy.growable_grass;

import floffytoffy.growable_grass.register.ModBlocks;
import floffytoffy.growable_grass.register.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class GrowableGrassClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((content) -> {
			content.addBefore(Blocks.DIRT, ModBlocks.SEEDED_DIRT);
			content.addBefore(Blocks.DIRT, ModBlocks.FIBROUS_DIRT);
			content.addBefore(Blocks.DIRT, ModBlocks.FIBROUS_PODZOL_DIRT);
			content.addBefore(Blocks.NETHERRACK, ModBlocks.CRIMSON_FIBROUS_NETHERRACK);
			content.addBefore(Blocks.NETHERRACK, ModBlocks.WARPED_FIBROUS_NETHERRACK);

			content.addBefore(Items.COCOA_BEANS , ModItems.MYCELIUM_FIBRES);
			content.addBefore(Items.COCOA_BEANS, ModItems.GRASS_SEEDS);
			content.addBefore(Items.COCOA_BEANS , ModItems.WARPED_FIBRES);
			content.addBefore(Items.COCOA_BEANS, ModItems.CRIMSON_FIBRES);
			content.addBefore(Items.COCOA_BEANS , ModItems.PODZOL_FIBRES);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((content) -> {
			content.addBefore(Items.BONE_MEAL , ModItems.MYCELIUM_FIBRE_PACKET);
			content.addBefore(Items.BONE_MEAL, ModItems.SEED_PACKET);
			content.addBefore(Items.BONE_MEAL, ModItems.WARPED_FIBRE_PACKET);
			content.addBefore(Items.BONE_MEAL, ModItems.CRIMSON_FIBRE_PACKET);
			content.addBefore(Items.BONE_MEAL, ModItems.PODZOL_FIBRE_PACKET);
		});
	}
}