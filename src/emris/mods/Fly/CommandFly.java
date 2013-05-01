/*
 *  Copyright (C) 2013  emris
 *  https://github.com/emris/Fly
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package emris.mods.Fly;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.packet.Packet202PlayerAbilities;

public class CommandFly extends CommandBase {

	@Override
	public String getCommandName() {
		return "fly";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "/" + getCommandName();
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		
		if (sender instanceof EntityPlayerMP) {
			EntityPlayerMP curPlayer = (EntityPlayerMP) sender;
			PlayerCapabilities pc = curPlayer.capabilities;
			if (pc.allowFlying) {
				pc.allowFlying = false;
				pc.isFlying = false;
				sender.sendChatToPlayer("No more flying for " + sender.getCommandSenderName() + ".");
			} else {
				pc.allowFlying = true;
				sender.sendChatToPlayer(sender.getCommandSenderName() + " can fly now.");
			}
			Packet202PlayerAbilities pcPack = new Packet202PlayerAbilities(pc);
			curPlayer.capabilities = pc;
			curPlayer.playerNetServerHandler.sendPacketToPlayer(pcPack);
		}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		if (sender instanceof EntityPlayerMP) {
			return true;
		} else {
			return false;
		}
	}
}
