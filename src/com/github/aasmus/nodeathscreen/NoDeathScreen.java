package com.github.aasmus.nodeathscreen;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class NoDeathScreen extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}

    @Override
    public void onDisable() {
    	
    }
    
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (p.hasPermission("nodeathscreen.use")) {
            this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                @Override
                public void run() {
                    p.spigot().respawn();
                }
            }, 1L);
        }
    }

}
