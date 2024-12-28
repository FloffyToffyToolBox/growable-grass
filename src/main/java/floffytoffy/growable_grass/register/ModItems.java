package floffytoffy.growable_grass.register;

import floffytoffy.growable_grass.GrowableGrass;
import floffytoffy.growable_grass.item.SeedItem;
import floffytoffy.growable_grass.item.SeedPacketItem;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GrowableGrass.MOD_ID, name), item);
    }
    public static void register() {

        GrowableGrass.LOGGER.debug("Registering items for " + GrowableGrass.MOD_ID);
    }

    public static final Item MYCELIUM_FIBRE_PACKET = registerItem("mycelium_fibre_packet", new SeedPacketItem(Blocks.DIRT, ModBlocks.FIBROUS_DIRT, new Item.Settings().maxDamage(64)));
    public static final Item MYCELIUM_FIBRES = registerItem("mycelium_fibres", new SeedItem(Blocks.DIRT, ModBlocks.FIBROUS_DIRT, new Item.Settings()));

    public static final Item SEED_PACKET = registerItem("grass_seed_packet", new SeedPacketItem(Blocks.DIRT, ModBlocks.SEEDED_DIRT, new Item.Settings().maxDamage(64)));
    public static final Item GRASS_SEEDS = registerItem("grass_seeds", new SeedItem(Blocks.DIRT, ModBlocks.SEEDED_DIRT, new Item.Settings()));

    public static final Item WARPED_FIBRE_PACKET = registerItem("warped_fibre_packet", new SeedPacketItem(Blocks.NETHERRACK, ModBlocks.WARPED_FIBROUS_NETHERRACK,new Item.Settings().maxDamage(64)));
    public static final Item WARPED_FIBRES = registerItem("warped_fibres", new SeedItem(Blocks.NETHERRACK, ModBlocks.WARPED_FIBROUS_NETHERRACK,new Item.Settings()));

    public static final Item CRIMSON_FIBRE_PACKET = registerItem("crimson_fibre_packet", new SeedPacketItem(Blocks.NETHERRACK, ModBlocks.CRIMSON_FIBROUS_NETHERRACK,new Item.Settings().maxDamage(64)));
    public static final Item CRIMSON_FIBRES = registerItem("crimson_fibres", new SeedItem(Blocks.NETHERRACK, ModBlocks.CRIMSON_FIBROUS_NETHERRACK,new Item.Settings()));

    public static final Item PODZOL_FIBRE_PACKET = registerItem("podzol_fibre_packet", new SeedPacketItem(Blocks.DIRT, ModBlocks.FIBROUS_PODZOL_DIRT,new Item.Settings().maxDamage(64)));
    public static final Item PODZOL_FIBRES = registerItem("podzol_fibres", new SeedItem(Blocks.DIRT, ModBlocks.FIBROUS_PODZOL_DIRT, new Item.Settings()));
}
