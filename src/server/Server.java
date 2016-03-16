package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by pkogler on 16.03.2016.
 */
public class Server {
    private static int registryPort;
    private static int stubPort;
    private final static String serviceName = "You wanna CalcPi [*_*].exe";

    public static void main(String[] args) {
        //Assigning the registry Port
        registryPort = Integer.parseInt(args[0]);
        //Assigning the stubPort
        stubPort = Integer.parseInt(args[1]);

        /**
         * Implementing a Security Manager
         */
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            //Creating the Server Service
            ServerService serverService = new ServerService();

            //Creating the Registry
            Registry registry = LocateRegistry.createRegistry(registryPort);

            /*
            * Create the stub for Communication between Server and the Client
            * through the Skellet
            */
            ServerService stub = (ServerService) UnicastRemoteObject.exportObject(serverService, stubPort);

            //Binding the created Service to the registry
            registry.rebind(serviceName, stub);

            //Feedback for User
            System.out.println("Service has been bound! \nPress Enter to terminate ...");

            //Closing Server
            while (System.in.read() != '\n') ;

            //Unexporting the RemoteObject
            //Forcing it !
            UnicastRemoteObject.unexportObject(serverService, true);
            System.out.println("Service unbound, System goes down ...");

        } catch (RemoteException re) {
            System.err.println("Service already bound?" + " Check your RMI-Registry settings!");
            re.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Service exception:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
