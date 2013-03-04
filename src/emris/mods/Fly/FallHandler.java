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
