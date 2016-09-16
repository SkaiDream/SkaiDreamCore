package net.skaidream.SkaiDreamCore.util;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public abstract class SDAbstractSender implements SDMessage
{
	@Override
	public MessageType sendMessage(Player arg0, String arg1, Object... args)
	{
		return this.sendFixedMessage(arg0, arg1, args);
	}
	@Override
	public MessageType sendMessage(CommandSender arg0, String arg1, Object... args)
	{
		return this.sendFixedMessage(arg0, arg1, args);
	}
	
	@Override
	public MessageType sendMessage(ConsoleCommandSender arg0, String arg1, Object... args)
	{
		return this.sendFixedMessage(arg0, arg1, args);
	}
}
