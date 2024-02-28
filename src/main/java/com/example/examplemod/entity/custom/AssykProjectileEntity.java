package com.example.examplemod.entity.custom;

import com.example.examplemod.item.ModItems;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Arrays;

import static com.example.examplemod.entity.ModEntities.ASSYK_PROJECTILE;
import static com.example.examplemod.entity.ModEntities.ENTITY_TYPES;

public class AssykProjectileEntity extends AbstractArrow {
    @Override
    public boolean canBeHitByProjectile() {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return super.canCollideWith(pEntity);
    }

    private static final EntityDataAccessor<Byte> ID_LOYALTY = SynchedEntityData.defineId(AssykProjectileEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(AssykProjectileEntity.class, EntityDataSerializers.BOOLEAN);
    private ItemStack assyk = new ItemStack(ModItems.ASSYK.get());
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_LOYALTY, (byte)0);
        this.entityData.define(ID_FOIL, false);
    }

    public AssykProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public AssykProjectileEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ASSYK_PROJECTILE.get(), pShooter, pLevel);
        this.assyk = pStack.copy();
        this.entityData.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(pStack));
        this.entityData.set(ID_FOIL, pStack.hasFoil());
    }


    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (!pSource.is(DamageTypeTags.IS_PROJECTILE)) {
            this.setDeltaMovement(pSource.getDirectEntity().getDeltaMovement());
            return false;
        }
        return false;
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.ASSYK.get());
    }
    @Override
    protected void onHitBlock(BlockHitResult pResult) {

        BlockState blockstate = this.level().getBlockState(pResult.getBlockPos());
        blockstate.onProjectileHit(this.level(), blockstate, pResult, this);
        Direction d = pResult.getDirection();
        Vec3 mot = this.getDeltaMovement();
        double x = mot.x();
        double y = mot.y();
        double z = mot.z();
        if (d.getStepX() != 0) {
            x *= -1.0;
        } else if (d.getStepY() != 0) {
            y *= -1.0;
        } else if (d.getStepZ() != 0) {
            z *= -1.0;
        }
        if (this.getDeltaMovement().get(Direction.Axis.X) >= 0.2 || this.getDeltaMovement().get(Direction.Axis.Y) >= 0.2 || this.getDeltaMovement().get(Direction.Axis.Z) >= 0.2){
            Vec3 newMot = new Vec3(x, y, z).multiply(0.8,0.5,0.8);
            this.setPos(pResult.getLocation());
            this.setDeltaMovement(newMot);
        } else {
            Vec3 vec31 = mot.normalize().scale((double)0.05F);
            this.setPosRaw(this.getX() - vec31.x, this.getY() - vec31.y, this.getZ() - vec31.z);
        }



        this.setCritArrow(false);
        this.setPierceLevel((byte)0);
        this.setSoundEvent(SoundEvents.ARROW_HIT);
        this.setShotFromCrossbow(false);


    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {

        if (pResult.getEntity() instanceof AssykProjectileEntity){
            pResult.getEntity().setPos(pResult.getLocation());
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.4,0.4,0.4));
        }


    }

    public boolean isFoil() {
        return this.entityData.get(ID_FOIL);
    }

}
