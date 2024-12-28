package floffytoffy.growable_grass;

import floffytoffy.growable_grass.register.ModBlocks;
import floffytoffy.growable_grass.register.ModItems;
import floffytoffy.growable_grass.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrowableGrass implements ModInitializer {
	public static final String MOD_ID = "growable_grass";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.register();
		ModBlocks.register();
		ModLootTableModifiers.modifyLootTables();

		LOGGER.info("Hello Fabric world!");
	}
}