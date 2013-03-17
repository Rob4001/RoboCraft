package couk.rob4001.robocraft;

import java.util.ArrayList;
import java.util.Collection;

import couk.rob4001.robocraft.gui.GUIJournalRedo;
import couk.rob4001.robocraft.research.ResearchItem;
import couk.rob4001.robocraft.research.ResearchMap;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerManager;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ConnectionHandler implements IConnectionHandler{

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler,
			INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler,
			INetworkManager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server,
			int port, INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler,
			MinecraftServer server, INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionClosed(INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clientLoggedIn(NetHandler netHandler,
			INetworkManager manager, Packet1Login login) {
		
	

		    if (RoboCraft.proxy.getClientWorld() != null) {
		      GUIJournalRedo.completedResearch.put(netHandler.getPlayer().username, new ArrayList());
		    }

		    for (ResearchItem ri : ResearchMap.researchList){
		      if (ri.getAutoUnlock())
		    	  GUIJournalRedo.completedResearch.get(netHandler.getPlayer().username).add(ri.id);
		    }
		    System.out.println("ResearchInit!");
		  }
		
	

}
