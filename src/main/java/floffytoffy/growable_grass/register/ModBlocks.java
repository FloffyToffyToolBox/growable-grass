package floffytoffy.growable_grass.register;

import floffytoffy.growable_grass.GrowableGrass;
import floffytoffy.growable_grass.block.SeededDirt;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {
    public static net.minecraft.block.Block registerBlock(String id, net.minecraft.block.Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(GrowableGrass.MOD_ID, id), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(GrowableGrass.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void register() {

    GrowableGrass.LOGGER.debug("Registering items for " + GrowableGrass.MOD_ID);
}
    public static final Block SEEDED_DIRT = registerBlock("seeded_dirt", new SeededDirt(Blocks.GRASS_BLOCK, AbstractBlock.Settings.copy(DIRT)));
    public static final Block FIBROUS_DIRT = registerBlock("fibrous_dirt", new SeededDirt(Blocks.MYCELIUM, AbstractBlock.Settings.copy(DIRT)));
    public static final Block FIBROUS_PODZOL_DIRT = registerBlock("fibrous_podzol_dirt", new SeededDirt(Blocks.PODZOL,AbstractBlock.Settings.copy(DIRT)));
    public static final Block CRIMSON_FIBROUS_NETHERRACK = registerBlock("crimson_fibrous_netherrack", new SeededDirt(CRIMSON_NYLIUM,1,AbstractBlock.Settings.copy(NETHERRACK)));
    public static final Block WARPED_FIBROUS_NETHERRACK = registerBlock("warped_fibrous_netherrack", new SeededDirt(WARPED_NYLIUM,1,AbstractBlock.Settings.copy(NETHERRACK)));

}
