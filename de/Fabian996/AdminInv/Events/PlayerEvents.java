package com.jimdo.Fabian996.AdminInv2.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class PlayerEvents implements Listener{

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        String msg = e.getMessage();
        for (String word : AdminInv.Blacklist) {
            msg = msg.replaceAll("(?i)" + word, "§cLeider dürfen sie das Wort nicht schreiben!");
        }
        e.setMessage(msg);
        
		Player p = e.getPlayer();
		if(p.hasPermission("adminInv.admin") || p.hasPermission("admininv.*")){
			String msg1 = e.getMessage();
			for(Player OPlayers : Bukkit.getOnlinePlayers()) {
				if(OPlayers.getWorld() == p.getWorld()) {
					OPlayers.sendMessage(p.getName() + " §f>> " + ChatColor.translateAlternateColorCodes('&', msg1));
					e.setCancelled(true);
				}
			}
		}
    }
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onJoin(PlayerJoinEvent e){
		if(AdminInv.wartungs){
			if(e.getPlayer().hasPermission("admininv.wartung") || (e.getPlayer().hasPermission("admininv.*"))){
				e.setJoinMessage(AdminInv.WartungsPrefix + e.getPlayer().getName() + " §7ist gejoint");
			}else{
				String config = AdminInv.cfg.getString("Wartung.Message");
				e.getPlayer().kickPlayer(config);
				e.setJoinMessage("§cWartung §4>> §eDer Server befindet sich im Wartungsmodus");
			}
		}
		Player p = (Player)e.getPlayer();
		
		if(AdminInv.bancfg.getBoolean("Ban." +  p.getName() + ".Enable")){
			String Grund = AdminInv.bancfg.getString("Ban." + p.getName() + ".Grund");
			String Forum = AdminInv.cfg.getString("serverinfo.forum");
			String TeamSpeak = AdminInv.cfg.getString("serverinfo.teamspeak");
			p.kickPlayer("§4§lDu bist permanent vom Server gebannt\n \n§r§4§lGrund: §r§2" +  Grund + "\n\n§6Bitte melde dich im Forum oder im TS \n§4§lForum:§r§8" + Forum + "\n§4§lTeamSpeak:§r§8" + TeamSpeak);
		}
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent e){
		if(AdminInv.wartungs){
			if(e.getPlayer().hasPermission("admininv.wartung") || (e.getPlayer().hasPermission("admininv.*"))){
				e.setLeaveMessage(AdminInv.WartungsPrefix + e.getPlayer().getName() + " §7wurde gekickt");
			}else{
				e.setLeaveMessage("§cWartung §4>> §eDer Server befindet sich im Wartungsmodus");
			}
		}
	}
}
