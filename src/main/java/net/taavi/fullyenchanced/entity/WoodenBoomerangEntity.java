package net.taavi.fullyenchanced.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.taavi.fullyenchanced.init.ModEntities;
import net.taavi.fullyenchanced.init.ModItems;
import net.taavi.fullyenchanced.init.ModSounds;

public class WoodenBoomerangEntity extends PersistentProjectileEntity {
    private static final TrackedData<Boolean> HIT =
            DataTracker.registerData(WoodenBoomerangEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private ItemStack boomerangStack = new ItemStack(ModItems.WOODEN_BOOMERANG);
    private boolean dealtDamage;
    public int returnTimer;
    private static final TrackedData<Boolean> ENCHANTED = DataTracker.registerData(WoodenBoomerangEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();

    public AnimationState getIdleAnimationState() {
        return idleAnimationState;
    }


    public WoodenBoomerangEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public WoodenBoomerangEntity(World world, LivingEntity user, ItemStack stack) {
        super(ModEntities.BOOMERANG, world);
        this.boomerangStack = stack.copy();
        setOwner(user);
        BlockPos blockpos = user.getBlockPos();
        double d0 = (double)blockpos.getX() + 0.0D;
        double d1 = (double)blockpos.getY() + 1.50D;
        double d2 = (double)blockpos.getZ() + 0.2D;
        this.refreshPositionAndAngles(d0, d1, d2, this.getYaw(), this.getPitch());
    }


    @Override
    public void tick() {
        if (this.inGroundTime > 0 || this.age>=40) {
            this.dealtDamage = true;
        }
        Entity entity = this.getOwner();
        if ((this.dealtDamage || this.isNoClip()) && entity != null){
            if (!this.isOwnerAlive()) {
                if (!this.getWorld().isClient && this.pickupType == PersistentProjectileEntity.PickupPermission.ALLOWED) {
                    this.dropStack(this.asItemStack(), 0.1f);
                }
                this.discard();
            } else {
                returnToUser(entity);
            }
        }
        super.tick();
    }

    public void returnToUser(Entity entity) {
        this.setVelocity(0,0,0);
        this.setNoClip(true);
        Vec3d vec3d = entity.getEyePos().subtract(this.getPos());
        this.setPos(this.getX(), this.getY(), this.getZ());
        this.setVelocity(this.getVelocity().add(vec3d.normalize().multiply(1.4)));
        ++this.returnTimer;
        this.getWorld().playSound(null, this.getBlockPos(), ModSounds.BOOMERANG_FLYING, SoundCategory.NEUTRAL, 1f, 1f);
    }

    private boolean isOwnerAlive() {
        Entity entity = this.getOwner();
        if (entity == null || !entity.isAlive()) {
            return false;
        }
        return !(entity instanceof ServerPlayerEntity) || !entity.isSpectator();
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        float f = 8.0f;
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            f += EnchantmentHelper.getAttackDamage(this.boomerangStack, livingEntity.getGroup());
        }
        Entity entity2 = this.getOwner();
        DamageSource damageSource = this.getDamageSources().create(DamageTypes.THROWN, this, this.getOwner());
        this.dealtDamage = true;
        SoundEvent soundEvent = SoundEvents.ENTITY_ARMOR_STAND_HIT;
        if (entity.damage(damageSource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity2 = (LivingEntity)entity;
                if (entity2 instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged(livingEntity2, entity2);
                    EnchantmentHelper.onTargetDamaged((LivingEntity)entity2, livingEntity2);
                }
                this.onHit(livingEntity2);
            }
        }
        returnToUser(entity);
    }

    @Override
    protected boolean tryPickup(PlayerEntity player) {
        return super.tryPickup(player) || this.isNoClip() && this.isOwner(player) && player.getInventory().insertStack(this.asItemStack());
    }

    @Override
    protected ItemStack asItemStack() {
        return this.boomerangStack.copy();
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(HIT, false);
    }
    public boolean isEnchanted() {
        return this.dataTracker.get(ENCHANTED);
    }
}
