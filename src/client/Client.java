package client;

import clientCallback.CalcPiCallback;
import clientCallback.Callback;
import commands.CalculatePiCommand;
import server.Server;
import server.remoteService.ExecuteService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by pkogler on 16.03.2016.
 */
public class Client {
    private static String host;
    private static String serviceName;
    private final static int registryPort = Registry.REGISTRY_PORT;

    public static void main(String[] args) {
        host = args[0];
        serviceName = Server.serviceName;
        /**if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }**/
        try {
            //Get the Registry
            Registry registry = LocateRegistry.getRegistry(registryPort);

            //Creating the Callback Object
            Callback callback = new CalcPiCallback();

            //Creating stub from Callback Object
            Callback callbackStub = (Callback) UnicastRemoteObject.exportObject(callback,0);

            //Setting the Stub to true
            callbackStub.setClientStub(true);

            //Getting the remoteObkect from the Registrty
            ExecuteService executeService = (ExecuteService) registry.lookup(serviceName);
            System.out.print("Service found / bound");

            //Create CalculatePiCommand
            CalculatePiCommand command = new CalculatePiCommand(Integer.parseInt(args[1]),callbackStub);

            //Executing command
            executeService.executeService(command);

        } catch (RemoteException e) {
            System.err.print("Registry not found");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.err.print("Registry not bounded!");
            e.printStackTrace();
        }
    }
}
