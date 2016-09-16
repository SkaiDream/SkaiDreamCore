package net.skaidream.SkaiDreamCore.util;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public abstract class SDAbstractSender implements SDMessage
{
	@Override
	public MessageType sendMessage(Player sender, String message, Object... args)
	{
		return this.sendFixedMessage(sender, message, args);
	}
	@Override
	public MessageType sendMessage(CommandSender sender, String message, Object... args)
	{
		return this.sendFixedMessage(sender, message, args);
	}
	
	@Override
	public MessageType sendMessage(ConsoleCommandSender sender, String message, Object... args)
	{
		return this.sendFixedMessage(sender, message, args);
	}
	
	@Override
	public MessageType sendGeneralMessage(Player sender, String message, Object... args)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public MessageType sendGeneralMessage(CommandSender sender, String message, Object... args)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public MessageType sendGeneralMessage(ConsoleCommandSender sender, String message, Object... args)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override public abstract MessageType sendFixedMessage(Object obj, String message);
	@Override public abstract MessageType sendFixedMessage(Object obj, String message, Object... args);
	@Override public abstract MessageType sendGeneralFixedMessage(Object obj, String message);
	@Override public abstract MessageType sendGeneralFixedMessage(Object obj, String message, Object... args);
}
