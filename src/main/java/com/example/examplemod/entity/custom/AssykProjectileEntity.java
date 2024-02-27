package com.example.examplemod.entity.custom;

import com.example.examplemod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import static com.example.examplemod.entity.ModEntities.ASSYK_PROJECTILE;
import static com.example.examplemod.entity.ModEntities.ENTITY_TYPES;

public class AssykProjectileEntity extends AbstractArrow {

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
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.ASSYK.get());
    }
    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        // Implement bounce behavior

        // Bounce off walls (if hit side is not null)
        if (blockHitResult.getDirection() != null) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(-1, 1, -1)); // Reverse X and Z velocity
        } else {
            // Bounce off floor (if hit side is null)
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, -1, 1)); // Reverse Y velocity
        }

    }
    public boolean isFoil() {
        return this.entityData.get(ID_FOIL);
    }

}
