package net.skaidream.SkaiDreamCore.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageType
{
	protected final Object sender;
	public CommandSender getSender() { return (CommandSender) this.sender; };
	public boolean isPlayerType() { return sender instanceof Player; };
	public boolean isConsoleType() { return ! this.isConsoleType(); };
	
	protected final String message;
	public String getMessage() { return this.message; };
	public String getRawMessage() { return ChatColor.stripColor(message); };
	
	public MessageType(Object obj, String message)
	{
		this.sender = obj;
		this.message = message;
	}
}
