package de.Fabian996.AdminInv.Main;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import de.Fabian996.AdminInv.Commands.AdminHelp;
import de.Fabian996.AdminInv.Commands.BroadcastCMD;
import de.Fabian996.AdminInv.Commands.InvseeCMD;
import de.Fabian996.AdminInv.Commands.KickCMD;
import de.Fabian996.AdminInv.Commands.PingCMD;
import de.Fabian996.AdminInv.Commands.PlayerInfoCMD;
import de.Fabian996.AdminInv.Commands.SpawnCMD;
import de.Fabian996.AdminInv.Commands.VoteCMD;
import de.Fabian996.AdminInv.Commands.WarpCMD;
import de.Fabian996.AdminInv.Commands.afkCMD;
//import de.Fabian996.AdminInv.Commands.msgCMD;
import de.Fabian996.AdminInv.Function.AdminFunction;
import de.Fabian996.AdminInv.Function.DifficultyFunction;
import de.Fabian996.AdminInv.Function.GamemodeFunction;
import de.Fabian996.AdminInv.Function.ServerFunction;
import de.Fabian996.AdminInv.Function.WeatherFunction;
import de.Fabian996.AdminInv.GUI.AdminInventory;
import de.Fabian996.AdminInv.GUI.DiffiInv;
import de.Fabian996.AdminInv.GUI.GamemodeInv;
import de.Fabian996.AdminInv.GUI.ServerInventory;
import de.Fabian996.AdminInv.GUI.WeatherInv;
import de.Fabian996.AdminInv.Handler.AdminItem;
import de.Fabian996.AdminInv.Handler.Ghast;
import de.Fabian996.AdminInv.Listener.Blocken;

public class AdminMain extends JavaPlugin{

	private static AdminMain instance;
	
	Logger log = getLogger();
	
	public void onEnable(){
		System.out.println("[AdminInv] =================================");
		System.out.println("[AdminInv] Author: " + getDescription().getAuthors());
	    System.out.println("[AdminInv] Version: v" + getDescription().getVersion());
	    System.out.println("[AdminInv] Website: " + getDescription().getWebsite());
	    System.out.println("[AdminInv] Status: Aktiviert");
	    System.out.println("[AdminInv] =================================");
	    
	    
	    Metrics();
	    
	    registerCommands();
	    registerConfig();
	    registerListener();
	    //registerGUI(); 	  | coming soon
	    //registerLibrary();  | coming soon
	    //registerLanguage(); | coming soon
	}
	
	public void registerCommands(){
		getCommand("admin").setExecutor(new AdminInventory());
		getCommand("climate").setExecutor(new WeatherInv());
		getCommand("egm").setExecutor(new GamemodeInv());
		getCommand("diffis").setExecutor(new DiffiInv());
		getCommand("server").setExecutor(new ServerInventory());

		getCommand("adminhelp").setExecutor(new AdminHelp());
		getCommand("warp").setExecutor(new WarpCMD());

		getCommand("ghast").setExecutor(new AdminItem());
		getCommand("afk").setExecutor(new afkCMD());
		getCommand("ping").setExecutor(new PingCMD());
		getCommand("pinfo").setExecutor(new PlayerInfoCMD());
		getCommand("invsee").setExecutor(new InvseeCMD());
		getCommand("kick").setExecutor(new KickCMD());
		
		getCommand("br").setExecutor(new BroadcastCMD());
		getCommand("spawn").setExecutor(new SpawnCMD());
		getCommand("vote").setExecutor(new VoteCMD());
		
		//getCommand("home").setExecutor(new HomeCMD());
		//getCommand("msg").setExecutor(new msgCMD());
		//getCommand("report").setExecutor(new ReportCMD());
	}
	
	public void registerListener(){
		
		getServer().getPluginManager().registerEvents(new Ghast(), this);
		getServer().getPluginManager().registerEvents(new Blocken(), this);
		
		getServer().getPluginManager().registerEvents(new AdminFunction(), this);
		getServer().getPluginManager().registerEvents(new WeatherFunction(), this);
		getServer().getPluginManager().registerEvents(new GamemodeFunction(), this);
		getServer().getPluginManager().registerEvents(new DifficultyFunction(), this);
		getServer().getPluginManager().registerEvents(new ServerFunction(), this);
		
	}
	
	public void registerConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public void onDisable()	{
		System.out.println("[AdminInv] =================================");
		System.out.println("[AdminInv] Author: " + getDescription().getAuthors());
		System.out.println("[AdminInv] Version: v" + getDescription().getVersion());
		System.out.println("[AdminInv] Website: " + getDescription().getWebsite());
		System.out.println("[AdminInv] Status: Deaktiviert");
		System.out.println("[AdminInv] =================================");
	}

	public void  Metrics(){
		if (getConfig().getString("Metrics.enable") != null) {
            try {
                Metrics metrics = new Metrics(this);
                metrics.start();
                getLogger().info("Metrics succesfull" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
                log.severe("[AdminInv] Metrics Failed to Start!");
            }
        } else {
            getLogger().info("Metrics wasn't started because it is disabled in the config!" + "\n");
        }
    }
	
	public static AdminMain get() {
		return instance;
	}
}
