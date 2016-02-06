package de.Fabian996.AdminInv.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ReNameCMD implements CommandExecutor {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	private String Not_Player = "You must be a player!";
	private String Wrong_Use = "To Use: §3/rename §7<ItemName>";
	private String Not_Item_In_The_Hand = "§cYou must hold an item in your hand.";
	private String Need_Permission = "§4You do have not permission to do that";
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("rename")){
			if((cs instanceof Player)){
				Player p = (Player)cs;
				if(p.hasPermission("AdminInv.RenameItem") || p.hasPermission("AdminInv.*")){
					if((p.getItemInHand() != null) && (!p.getItemInHand().getType().equals(Material.AIR))){
						if(args.length == 1){
							ItemStack Item = p.getItemInHand();
						
							String string = args[0];
							String SpeaceString = string.replaceAll("_", " ");
							String ColorString = ChatColor.translateAlternateColorCodes('&', SpeaceString);
						
							ItemMeta Itemmeta = Item.getItemMeta();
							Itemmeta.setDisplayName(ColorString);
							Item.setItemMeta(Itemmeta);
						
							p.sendMessage(Prefix + "Succesfully renamed the item in hand to: §r" + ColorString);
						}else{
							cs.sendMessage(Prefix + Wrong_Use);
						}
					}else{
						cs.sendMessage(Prefix + Not_Item_In_The_Hand);
					}
				}else{
					cs.sendMessage(Prefix + Need_Permission);
				}
			}else{
				cs.sendMessage(Prefix + Not_Player);
			}
		}
		return true;
	}
}
