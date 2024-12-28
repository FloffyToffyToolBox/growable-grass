//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package floffytoffy.growable_grass.item;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.GameEvent.Emitter;

import java.util.Optional;

public class SeedItem extends Item {
    private Block BLOCK;
    private Block BLOCK2;
    public final com.google.common.base.Supplier<ImmutableBiMap<Object, Object>> SEEDLESS_TO_SEEDED = Suppliers.memoize(() -> {
        return ImmutableBiMap.builder().put(BLOCK, BLOCK2).build();
    });
    public SeedItem(Block inBlock, Block outBlock, Settings settings) {
        super(settings);
        BLOCK = inBlock;
        BLOCK2 = outBlock;
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        return (ActionResult)getSeededState(blockState).map((state) -> {
            PlayerEntity playerEntity = context.getPlayer();
            ItemStack itemStack = context.getStack();
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos, itemStack);
            }

            itemStack.decrement(1);
            world.setBlockState(blockPos, state, 11);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, Emitter.of(playerEntity, state));
            world.syncWorldEvent(playerEntity, 1500, blockPos, 0);
            return ActionResult.success(world.isClient);
        }).orElse(ActionResult.PASS);
    }

    public SoundEvent getBreakSound() {
        return SoundEvents.BLOCK_WOOL_BREAK;
    }
    public Optional<BlockState> getSeededState(BlockState state) {
        return Optional.ofNullable((Block)((BiMap)SEEDLESS_TO_SEEDED.get()).get(state.getBlock())).map((block) -> {
            return block.getStateWithProperties(state);
        });
    }
}
