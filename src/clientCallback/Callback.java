package clientCallback;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by pkogler on 16.03.2016.
 */
public interface Callback extends Remote {
    /**
     * This method returns the Result and
     * unexports the UnicastRemoteObject if needed
     *
     * @param result
     * @throws RemoteException
     */
    void getResult(BigDecimal result) throws RemoteException;

    /**
     * This Method sets wether a clientStub is
     * implemented or not
     *
     * @param clientStub
     * @throws RemoteException
     */
    void setClientStub(boolean clientStub) throws RemoteException;

}
