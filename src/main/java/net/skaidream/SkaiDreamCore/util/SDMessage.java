package net.skaidream.SkaiDreamCore.util;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public abstract interface SDMessage
{	
	public abstract MessageType sendMessage(Player arg0, String arg1);
	public abstract MessageType sendMessage(CommandSender arg0, String arg1);
	public abstract MessageType sendMessage(ConsoleCommandSender arg0, String arg1);
	public abstract MessageType sendMessage(Player arg0, String arg1, Object... args);
	public abstract MessageType sendMessage(CommandSender arg0, String arg1, Object... args);
	public abstract MessageType sendMessage(ConsoleCommandSender arg0, String arg1, Object... args);
	public abstract MessageType sendFixedMessage(Object arg0, String arg1);
	public abstract MessageType sendFixedMessage(Object arg0, String arg1, Object... args);
}
