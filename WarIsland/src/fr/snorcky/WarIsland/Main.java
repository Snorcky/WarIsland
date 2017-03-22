package fr.snorcky.WarIsland;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin{
	
	@Override
	public void onEnable(){
		
		//Création d'un fichier de configuration si ce dernier n'existe pas
		File config = new File(getConfig().getCurrentPath());
        if (!config.exists())
        {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
        
        getCommand("wi").setExecutor(new Commandes(this));
	}
	
	public void onDisable(){
		System.out.println("Plugin disable");
	}
	
	
}
