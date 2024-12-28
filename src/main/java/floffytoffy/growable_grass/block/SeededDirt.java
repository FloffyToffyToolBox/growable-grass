package floffytoffy.growable_grass.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;


public class SeededDirt extends Block{

    private final Block BLOCK;
    private final int LEVEL;
    public SeededDirt(Block blockOut, Settings settings) {
        super(settings);
        BLOCK = blockOut;
        LEVEL = 9;
    }
    public SeededDirt(Block blockOut, int requiredLightLevel, Settings settings) {
        super(settings);
        BLOCK = blockOut;
        LEVEL = requiredLightLevel;
    }
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            if (world.getLightLevel(pos.up()) >= LEVEL) {
                world.setBlockState(pos, BLOCK.getDefaultState());
            }
    }
}
