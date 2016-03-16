package server;

import commands.Command;
import server.remoteService.ExecuteService;

import java.rmi.RemoteException;

/**
 * Created by pkogler on 16.03.2016.
 */
public class ServerService implements ExecuteService {

    /**
     *
     * @param command
     * @throws RemoteException
     */
    @Override
    public void executeService(Command command) throws RemoteException {
        command.execute();
    }
}
