package emris.mods.Fly;

import TFC.Handlers.EntityHurtHandler;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.Side;

@Mod(modid="Fly", name="Fly", version="1.1")
@NetworkMod(clientSideRequired=false, serverSideRequired=false)
public class Fly {
	
	@Instance("Fly")
	public static Fly instance;
	
	@Init
	public void load(FMLInitializationEvent event) {
		if (event.getSide() == Side.SERVER) {
			MinecraftServer server = ModLoader.getMinecraftServerInstance();
			ICommandManager icm = server.getCommandManager();
			ServerCommandManager scm = ((ServerCommandManager) icm);
			scm.registerCommand(new CommandFly());
			
			MinecraftForge.EVENT_BUS.register(new FallHandler());
		}
	}
}
