package com.enderdevelopment.plugin;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobListener implements Listener {

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.ZOMBIE) {
            // Customize the zombie as needed
            ((Mob) event.getEntity()).setCustomName("Mobile Mob");
            ((Mob) event.getEntity()).setCustomNameVisible(true);
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
            LivingEntity target = (LivingEntity) event.getEntity();
            if (isHostile(target) || isVillager(target) || isIronGolem(target)) {
                // Logic to handle the attack
                // For example, you can set the target for the mob to attack
                ((Mob) event.getDamager()).setTarget(target);
            }
        }
    }

    private boolean isHostile(LivingEntity entity) {
        // Check if the entity is a hostile mob
        return entity instanceof Mob && ((Mob) entity).getTarget() != null; // Temporary workaround
    }

    private boolean isVillager(LivingEntity entity) {
        // Check if the entity is a villager
        return entity.getType() == EntityType.VILLAGER;
    }

    private boolean isIronGolem(LivingEntity entity) {
        // Check if the entity is an iron golem
        return entity.getType() == EntityType.IRON_GOLEM;
    }
}