package fr.snorcky.WarIsland;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Commandes implements CommandExecutor {
	
	private FileConfiguration config;
	private Main plugin;

	public Commandes(Main pl) {
		this.plugin = pl;
		this.config = pl.getConfig();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player p = (Player)sender;
		
		if(sender instanceof Player){
			if(cmd.getName().equalsIgnoreCase("wi")){
				if(args[0].equalsIgnoreCase("create")){
					Random random = new Random();
					String colortp = config.getString("messages.teleport-message");
					String colormsgtp = ChatColor.translateAlternateColorCodes('&', colortp);
					
					int x = p.getLocation().getBlockX() + random.nextInt(config.getInt("coords.x"));
					int y = p.getLocation().getBlockY() + random.nextInt(config.getInt("coords.y"));
					int z = p.getLocation().getBlockZ() + random.nextInt(config.getInt("coords.z"));
					Location aleatoire = new Location(Bukkit.getWorld(config.getString("world.world-name")), x,y,z);
					p.teleport(aleatoire);
					
					
					p.sendMessage(colormsgtp);
					
				}
			}
		}
		
		return false;
	}

}
