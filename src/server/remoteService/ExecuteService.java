package server.remoteService;

import commands.Command;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by pkogler on 16.03.2016.
 */
public interface ExecuteService extends Remote {
    /**
     * Executes the Service
     *
     * @param command gets a command and executes it
     * @throws RemoteException if something is going wrong
     */
    public void executeService(Command command) throws RemoteException;
}
