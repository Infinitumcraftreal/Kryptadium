package net.infinitumcraft.kryptadium.block.custom;

import net.infinitumcraft.kryptadium.block.custom.RadarBlockEntity;
import net.infinitumcraft.kryptadium.entity.ModBlockEntities;
import net.infinitumcraft.kryptadium.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RadarBlock extends Block implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    private static final int COOLDOWN_TICKS = 1200; // 60 seconds
    private static final double RADAR_RADIUS = 20.0;

    public RadarBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RadarBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof RadarBlockEntity radar) {

                if (radar.isCoolingDown(world)) {
                    int secondsRemaining = radar.getRemainingSeconds(world);

                    player.sendMessage(
                            Text.literal("In cooldown: " + secondsRemaining + "s remaining")
                                    .formatted(Formatting.RED),
                            true
                    );
                    return ActionResult.CONSUME;
                }

                world.playSound(null, pos, ModSounds.RADAR_ONUSE, SoundCategory.BLOCKS, 1.0f, 1.0f);

                Box searchArea = new Box(pos).expand(RADAR_RADIUS);
                List<PlayerEntity> nearbyPlayers = world.getEntitiesByClass(PlayerEntity.class, searchArea, p -> true);

                int localizedTargetsFound = 0;
                for (PlayerEntity targetPlayer : nearbyPlayers) {
                    if (targetPlayer.getUuid().equals(player.getUuid())) {
                        continue;
                    }

                    targetPlayer.addStatusEffect(new StatusEffectInstance(
                            StatusEffects.GLOWING, 200, 0, false, true
                    ));
                    localizedTargetsFound++;
                }

                if (localizedTargetsFound > 0) {
                    player.sendMessage(Text.literal("Radar pinged " + localizedTargetsFound + " targets nearby!").formatted(Formatting.GREEN), true);
                } else {
                    player.sendMessage(Text.literal("No nearby targets detected.").formatted(Formatting.GRAY), true);
                }

                radar.startGlobalCooldown(world, COOLDOWN_TICKS);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}