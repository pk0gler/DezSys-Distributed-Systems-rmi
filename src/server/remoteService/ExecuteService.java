package server.remoteService;

import commands.Command;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by pkogler on 16.03.2016.
 */
public interface ExecuteService extends Remote {
    public void executeService(Command command) throws RemoteException;
}
