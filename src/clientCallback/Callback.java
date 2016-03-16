package clientCallback;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by pkogler on 16.03.2016.
 */
public interface Callback extends Remote {
    /**
     * @param result
     * @throws RemoteException
     */
    void getResult(BigDecimal result) throws RemoteException;

    /**
     *
     * @param clientStub
     * @throws RemoteException
     */
    void setClientStub(boolean clientStub) throws RemoteException;

}
