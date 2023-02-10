package cg.creamgod45;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Event implements Listener {
    Map<Integer, String> materialList = new HashMap<>();

    Event() {
        List<String> ml = Utils.getMaterialList();
        int i = 1;
        for (String s : ml) {
            materialList.put(i, s);
            i++;
        }
    }

    private void randitem(Location location, World world) {
        String s = materialList.get((int) Math.floor(Math.random() * (materialList.size() - 1 + 1) + 1));
        Material material = Material.valueOf(s);
        ItemStack itemStack = new ItemStack(material);
        itemStack.setAmount((int) Math.floor(Math.random() * (64 - 1 + 1) + 1));
        CGRandomDrop.plugin.getServer().getWorld(world.getUID()).dropItem(location, itemStack);
    }

    @EventHandler
    public void EntityDropItemEvent(EntityDropItemEvent e) {
        Entity entity = e.getEntity();
        Location location = entity.getLocation();
        World world = entity.getWorld();
        e.setCancelled(true);
        randitem(location, world);
    }

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Location location = e.getBlock().getLocation();
        World world = player.getWorld();
        e.setDropItems(false);
        randitem(location, world);
    }
}
