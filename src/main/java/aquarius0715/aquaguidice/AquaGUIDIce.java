package aquarius0715.aquaguidice;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class AquaGUIDIce extends JavaPlugin implements Listener {


    public Inventory inv;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        createInv();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("diceg")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
            }
            Player player = (Player) sender;
            // GUIを開く
            player.openInventory(inv);
            return true;
        }
        return false;
    }

    @EventHandler()
    public void onClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv)) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();

        if (event.getSlot() == 10) {
            int r1 = new Random().nextInt(6 + 1);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "6面サイコロを振って" + (r1 + 1) + "が出ました");
            player.closeInventory();
        }
        if (event.getSlot() == 8) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "==================AquaDiceHelp==================");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "/dice : 通常サイコロを振ります");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "/dice 振りたい番号 : 自分が振りたい面サイコロを振ります");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "/dice help : AquaDicePluginのヘルプを表示します");
            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "==================AquaDiceHelp==================");
            player.closeInventory();
        }

        if (event.getSlot() == 12) {
            int r1 = new Random().nextInt(10 + 1);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "10面サイコロを振って" + (r1 + 1) + "が出ました");
            player.closeInventory();
        }

        if (event.getSlot() == 14) {
            int r1 = new Random().nextInt(100 + 1);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "100面サイコロを振って" + (r1 + 1) + "が出ました");
            player.closeInventory();
        }

        if (event.getSlot() == 16) {
            int r1 = new Random().nextInt(2 + 1);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "2面サイコロを振って" + (r1 + 1) + "が出ました");
            player.closeInventory();
        }

        if (event.getSlot() == 26) {
            player.closeInventory();
        }
        return;
    }

    public void createInv() {

        //新しいインベントリを作成
        inv = Bukkit.createInventory(null, 27, ChatColor.AQUA + "" + ChatColor.BOLD + "AquaDice");

        //GUIの根幹変数

        ItemStack item = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta meta = item.getItemMeta();
        ItemStack item1 = new ItemStack(Material.BOOK);
        ItemMeta meta1 = item1.getItemMeta();
        ItemStack item2 = new ItemStack(Material.BARRIER);
        ItemMeta meta2 = item2.getItemMeta();
        ItemStack item3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
        ItemMeta meta3 = item3.getItemMeta();


        //6面サイコロの作成

        meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "ここをクリックして6面サイコロを振る");
        item.setItemMeta(meta);
        inv.setItem(10, item);

        //10面さいころの作成

        meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "ここのクリックして10面サイコロを振る");
        item.setItemMeta(meta);
        inv.setItem(12, item);

        //100面サイコロの作成

        meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "ここのクリックして100面サイコロを振る");
        item.setItemMeta(meta);
        inv.setItem(14, item);

        //2面サイコロの作成

        meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "ここのクリックして2面サイコロを振る");
        item.setItemMeta(meta);
        inv.setItem(16, item);

        //helpの作成
        meta1.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "プラグインの使い方を見る");
        item1.setItemMeta(meta1);
        inv.setItem(8, item1);

        //GUIを閉じるボタンの作成
        meta2.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "GUIを閉じる");
        item2.setItemMeta(meta2);
        inv.setItem(26, item2);

        meta3.setDisplayName("-");
        item3.setItemMeta(meta3);
        inv.setItem(0, item3);
        inv.setItem(1, item3);
        inv.setItem(2, item3);
        inv.setItem(3, item3);
        inv.setItem(4, item3);
        inv.setItem(5, item3);
        inv.setItem(6, item3);
        inv.setItem(7, item3);
        inv.setItem(9, item3);
        inv.setItem(11, item3);
        inv.setItem(13, item3);
        inv.setItem(15, item3);
        inv.setItem(17, item3);
        inv.setItem(18, item3);
        inv.setItem(19, item3);
        inv.setItem(20, item3);
        inv.setItem(21, item3);
        inv.setItem(22, item3);
        inv.setItem(23, item3);
        inv.setItem(24, item3);
        inv.setItem(25, item3);
    }
}

