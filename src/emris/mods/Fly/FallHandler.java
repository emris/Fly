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

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class FallHandler {
	@ForgeSubscribe
	public void onPlayerFall(LivingHurtEvent event) 
	{
		if (event.entityLiving instanceof EntityPlayerMP) {
			EntityPlayerMP p = (EntityPlayerMP) event.entityLiving;
			if (p.capabilities.allowFlying && event.source == DamageSource.fall) {
				event.ammount = 0;
			}
//			System.out.println(event.source.damageType + " : " + event.ammount + " # " + p.capabilities.isFlying);
		}
	}
}
