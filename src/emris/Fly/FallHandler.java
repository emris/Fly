/**
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
package emris.Fly;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;

public class FallHandler {
	@ForgeSubscribe
	public void onPlayerFlyFall(PlayerFlyableFallEvent event)
	{
		if(event.distance > 3) {
			event.entityPlayer.playSound("damage.fallsmall", 1.0F, 1.0F);
			event.entityPlayer.performHurtAnimation();
		}
		event.distance = 0;
	}
}
