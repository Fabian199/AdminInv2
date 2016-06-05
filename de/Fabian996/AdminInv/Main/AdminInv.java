package com.jimdo.Fabian996.AdminInv2.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import com.jimdo.Fabian996.AdminInv2.Commands.AdminInv_Help;
import com.jimdo.Fabian996.AdminInv2.Commands.Ban;
import com.jimdo.Fabian996.AdminInv2.Commands.Broadcast;
import com.jimdo.Fabian996.AdminInv2.Commands.ClearChat;
import com.jimdo.Fabian996.AdminInv2.Commands.GMute;
import com.jimdo.Fabian996.AdminInv2.Commands.Gamemode;
import com.jimdo.Fabian996.AdminInv2.Commands.Heal;
import com.jimdo.Fabian996.AdminInv2.Commands.Invsee;
import com.jimdo.Fabian996.AdminInv2.Commands.Kick;
import com.jimdo.Fabian996.AdminInv2.Commands.Ping;
import com.jimdo.Fabian996.AdminInv2.Commands.ServerInfo;
import com.jimdo.Fabian996.AdminInv2.Commands.SpielerInfo;
import com.jimdo.Fabian996.AdminInv2.Commands.TeamChat;
import com.jimdo.Fabian996.AdminInv2.Commands.Vote;
import com.jimdo.Fabian996.AdminInv2.Commands.msg;
import com.jimdo.Fabian996.AdminInv2.Commands.remsg;
import com.jimdo.Fabian996.AdminInv2.Commands.renameItem;
import com.jimdo.Fabian996.AdminInv2.Commands.unban;
import com.jimdo.Fabian996.AdminInv2.Events.PlayerChatEvents;
import com.jimdo.Fabian996.AdminInv2.Events.PlayerCommandPreprocessEvents;
import com.jimdo.Fabian996.AdminInv2.Events.PlayerEvents;
import com.jimdo.Fabian996.AdminInv2.Library.ConfigGenerator;
import com.jimdo.Fabian996.AdminInv2.Library.MySQL;
import com.jimdo.Fabian996.AdminInv2.Listeners.Block;
import com.jimdo.Fabian996.AdminInv2.Listeners.Reload;

public class AdminInv extends JavaPlugin implements Listener,CommandExecutor{
	
	public static AdminInv instance;
	
	AdminInv Main;
	
	public Server Server = getServer();
	public ConsoleCommandSender Console = this.Server.getConsoleSender();
	
	//ArryListen
	public static final ArrayList<String> Team = new ArrayList<String>();
	public static final ArrayList<String> Blacklist = new ArrayList<String>();
	
	//HashMap´s
	public static final HashMap<String, String> Last_msg_Send_To = new HashMap<>();
	
	//Boolean
	public static boolean mute = false;
	public static boolean wartungs = false;

	//CommandSpy
	public static final ArrayList<String> CommandSpy = new ArrayList<String>();
			
	//Prefix´s
	public static final String AdminPrefix = "§8[§4AdminInv§8]§r ";
	public static final String SpyPrefix = "§8[§3AdminSpy§8]§r ";
	public static final String TeamChatPrefix = "§8[§9TeamChat§8]§r ";
	public static final String SystemPrefix = "§8[§6§lSystem§8]§r ";
	public static final String WartungsPrefix = "§c§lWartung §r";
	public static final String BanPrefix = "§8[§c§lBanSystem§8]§r ";
	public static final String MySQlPrefix = "§8[§eMySQL§8]§r ";
	
	//Fehlermeldung
	public static final String NoPerm = "§cSie haben nicht die Erlaubnis, diesen Befehl zu nutzen!";
	public static final String NoPlayer = "§cDu musst ein Spieler sein";
	
	//Spy Command
	public String Spy = "§7>> §aNow you can see Commands";
	public String NoSpy = "§7>> §cNow you didn't can see Commands";
	public String Correct_Use = "Use: §3/aspy ";
	
	//Config´s
	public static File file = new File("plugins/AdminInv2", "config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static File banfile = new File("plugins/AdminInv2", "banlist.yml");
	public static FileConfiguration bancfg = YamlConfiguration.loadConfiguration(banfile);
	
	public static File mysqlfile = new File("plugins/AdminInv2", "MySQL.yml");
	public static FileConfiguration mysqlcfg = YamlConfiguration.loadConfiguration(mysqlfile);
	
	public boolean mysql = AdminInv.mysqlcfg.getBoolean("AdminInv.MySQL.Enabled");
	MySQL sql;
	
	Logger log = getLogger();
	
	public void onEnable() {
		
	    instance = this;
	    Metrics();
		
	    registerCommands();
	    registerListener();
	    registerBlacklist();
		
	    saveConfig();
	    registerConfig();

	    StartMySQL();
	    
	    wartungs = (getConfig().get("Wartung.Status") != null ? getConfig().getBoolean("Wartung.Status") : false);
	}

	@Override
	public void onDisable() {
		try {
			bancfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		saveDefaultConfig();
	}
	
	public void registerCommands(){
		getCommand("aspy").setExecutor(this);
		getCommand("ahelp").setExecutor(new AdminInv_Help());
		getCommand("pinfo").setExecutor(new SpielerInfo());
		getCommand("br").setExecutor(new Broadcast());
		getCommand("cc").setExecutor(new ClearChat());
		getCommand("glmute").setExecutor(new GMute());
		getCommand("heal").setExecutor(new Heal());
		getCommand("ping").setExecutor(new Ping());
		getCommand("tc").setExecutor(new TeamChat());
		getCommand("wartung").setExecutor(this);
		getCommand("egm").setExecutor(new Gamemode());
		getCommand("sinfo").setExecutor(new ServerInfo());
		getCommand("vote").setExecutor(new Vote());
		getCommand("invsee").setExecutor(new Invsee());
		getCommand("kick").setExecutor(new Kick());
		getCommand("aban").setExecutor(new Ban());
		getCommand("uban").setExecutor(new unban());
		getCommand("setinfo").setExecutor(new ServerInfo());
		
		getCommand("msg").setExecutor(new msg());
		getCommand("r").setExecutor(new remsg());
		getCommand("rename").setExecutor(new renameItem());
	
	}
	
	public void registerListener(){
		getServer().getPluginManager().registerEvents(new Block(), this);
		getServer().getPluginManager().registerEvents(new Reload(), this);
		getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
		getServer().getPluginManager().registerEvents(new PlayerChatEvents(this), this);
		getServer().getPluginManager().registerEvents(new PlayerCommandPreprocessEvents(this), this);
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void registerConfig(){
		saveConfig();
		ConfigGenerator.CreateConfigs();
		registerExtrenConfig();
		
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public MySQL getMySQL(){
		return this.sql;
	}
	
	private void StartMySQL(){
		if(this.mysql){
			try{
				this.sql = new MySQL();
				Bukkit.getConsoleSender().sendMessage(MySQlPrefix + "§aErfolgreich §eMySQl-Service §agestarte");
			}catch(Exception e){
				Bukkit.getConsoleSender().sendMessage(MySQlPrefix + "§8Fehlgeschlagen §eMySQl-Service §8zu starten(" + e.getMessage() + ")§c!");
			}
		} else {
			Bukkit.getConsoleSender().sendMessage(MySQlPrefix +  "§eMySQl-Service §cDeaktiviert!");
		}
	}
	
	public void  Metrics(){
		if (getConfig().getString("Metrics.Status") != null) {
            try {
                Metrics metrics = new Metrics(this);
                metrics.start();
                getLogger().info("Metrics succesfull" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
                log.severe("[AdminInv 2] Metrics Failed to Start!");
            }
        } else {
            getLogger().info("Metrics wasn't started because it is disabled in the config!" + "\n");
        }
    }
	
	public void registerBlacklist(){
		 File file = new File(this.getDataFolder(), "Blacklist.txt");
		 if (!file.exists()) {
	            try {
	                getDataFolder().mkdir();
	                file.createNewFile();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        try {
	            Scanner s;
	            s = new Scanner(file);
	            while (s.hasNextLine())
	            	Blacklist.add(s.nextLine());
	 
	 
	            System.out.println("Es wurden " + Blacklist.size() + "  Worter auf der Blacklist geladen.");
	            s.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	}
	
	public void registerExtrenConfig(){
		try {
			bancfg.load(banfile);
			Bukkit.getConsoleSender().sendMessage(BanPrefix + "Banliste wurde Erfolgreich geladen");
		} catch (IOException | InvalidConfigurationException e) {
			Bukkit.getConsoleSender().sendMessage(BanPrefix + "Banliste wurde nicht Erfolgreich geladen");
		}
		
		try {
			mysqlcfg.load(mysqlfile);
		} catch (IOException | InvalidConfigurationException e) {
			Bukkit.getConsoleSender().sendMessage(MySQlPrefix + "MySQL wurde nicht Erfolgreich geladen");
		}
		
		try {
			cfg.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			Bukkit.getConsoleSender().sendMessage(AdminPrefix + "Config wurde nicht Erfolgreich geladen");
		}
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;	
		if(cmd.getName().equalsIgnoreCase("areload")){
			if(cs.hasPermission("admininv.admin") || cs.hasPermission("admininv.*")){
				saveDefaultConfig();
				reloadConfig();
				p.sendMessage(AdminPrefix + "§aConfig würde neugeladen");
			}else{
				cs.sendMessage(AdminPrefix + NoPerm);
			}
		}else if(cmd.getName().equalsIgnoreCase("aspy")){
			if(cs instanceof Player){
				if(cs.hasPermission("admininv.admin") || cs.hasPermission("admininv.*")){
					if(!CommandSpy.contains(p.getName())){
						CommandSpy.add(p.getName());
						p.sendMessage(SpyPrefix + Spy);
					}else{
						CommandSpy.remove(p.getName());
						p.sendMessage(SpyPrefix + NoSpy);
					}
				}else{
					cs.sendMessage(SpyPrefix + NoPerm);
				}
			}else{
				cs.sendMessage(SpyPrefix + NoPlayer);
			}
		}else if(cmd.getName().equalsIgnoreCase("wartung")){
			if((cs.hasPermission("admininv.wartung") || (cs.hasPermission("admininv.*")) || (p.isOp()))){
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("on")){
						for(Player pp : Bukkit.getOnlinePlayers()){
							if(!pp.hasPermission("admininv.wartung") || (!pp.hasPermission("admininv.*"))){
								String WartungMessage = cfg.getString("Wartung.Message");
								pp.kickPlayer(WartungMessage);
							}
						}
						AdminInv.wartungs = true;
						Bukkit.broadcastMessage(AdminInv.WartungsPrefix + "§4>> §eDer Server ist nun im Wartungsmodus!");
					}
					if(args[0].equalsIgnoreCase("off")){
						AdminInv.wartungs = false;
						Bukkit.broadcastMessage(AdminInv.WartungsPrefix + "§4>> §aDer Server ist nun nicht mehr im Wartungsmodus!");
					}
					getConfig().set("Wartung.Status", Boolean.valueOf(wartungs));
					saveConfig();
					return true;
				}else if(args.length == 0){
					p.sendMessage(AdminPrefix + "Nutze: §3/wartung §7<§5on§6/§5off§7>");
				}
				return false;
			}
			return false;
		}
		return true;
	}

	@EventHandler
	public void onSpy(PlayerCommandPreprocessEvent e){
		Player p = (Player)e.getPlayer();
		String cmd = e.getMessage();
		for(Player pl : Bukkit.getOnlinePlayers()){
			if((!CommandSpy.contains(pl.getName()))  || (p == pl)) continue;
			pl.sendMessage(SpyPrefix + "§7>> " + p.getName() + "§c:§6 " + cmd);
		}
		
	}
	
	@EventHandler
	public void onPing(ServerListPingEvent e){
		if(AdminInv.wartungs){
			e.setMaxPlayers(0);
			e.setMotd("§cWartung §4>> §eDer Server ist im Wartungsmodus");
		}
	}
	
	public static AdminInv get() {
		return instance;
	}
}
