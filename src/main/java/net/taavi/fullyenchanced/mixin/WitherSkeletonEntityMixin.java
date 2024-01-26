package net.taavi.fullyenchanced.mixin;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.taavi.fullyenchanced.init.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherSkeletonEntity.class)
public abstract class WitherSkeletonEntityMixin extends AbstractSkeletonEntity {
    public WitherSkeletonEntityMixin(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    private ItemStack makeInitialWeapon() {
        if ((double)this.random.nextFloat() < 0.2) {
            return new ItemStack(ModItems.STONE_SCYTHE);
        }
        return new ItemStack(Items.STONE_SWORD);
    }

    @Inject(method = "initEquipment", at = @At("TAIL"))
    private void modifyEquipment(Random random, LocalDifficulty localDifficulty, CallbackInfo info) {
        this.equipStack(EquipmentSlot.MAINHAND, makeInitialWeapon());
    }
}
