package server.remoteService;

import commands.Command;

import java.rmi.RemoteException;

/**
 * This Class implements ExecuteService
 *
 * Created by pkogler on 16.03.2016.
 */
public class ServerService implements ExecuteService {

    /**
     * This Method executes the Service
     *
     * @param command
     * @throws RemoteException
     */
    @Override
    public void executeService(Command command) throws RemoteException {
        command.execute();
    }
}
