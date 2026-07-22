package org.lin114514.plugin.serverTool;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class gift implements Listener{
    public gift(ServerTool plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if(!p.hasPlayedBefore()){
            p.sendMessage("§6[新手系统] §a欢迎来到服务器！你将获得一份新手礼包！");
            ItemStack i1 = new ItemStack(Material.DIAMOND,5);
            ItemStack i2 = new ItemStack(Material.IRON_SWORD,1);
            ItemStack i3 = new ItemStack(Material.COOKED_BEEF,16);
            ItemStack i4 = new ItemStack(Material.IRON_HELMET,1);
            ItemStack i5 = new ItemStack(Material.IRON_CHESTPLATE,1);
            ItemStack i6 = new ItemStack(Material.IRON_LEGGINGS,1);
            ItemStack i7 = new ItemStack(Material.IRON_BOOTS,1);
            ItemStack i8 = new ItemStack(Material.IRON_PICKAXE,1);
            ItemStack i9 = new ItemStack(Material.IRON_AXE,1);
            p.getInventory().addItem(i1,i2,i3,i8,i9);
            p.getInventory().setHelmet(i4);
            p.getInventory().setChestplate(i5);
            p.getInventory().setLeggings(i6);
            p.getInventory().setBoots(i7);
        }
    }
}
