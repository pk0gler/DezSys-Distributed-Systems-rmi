package clientCallback;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by pkogler on 16.03.2016.
 */
public class CalcPiCallback implements Callback {
    private boolean clientStub;

    /**
     * This method returns the Result and
     * unexports the UnicastRemoteObject if needed
     *
     * @param result
     * @throws RemoteException
     */
    @Override
    public void getResult(BigDecimal result) throws RemoteException {
        System.out.println("Result:\t" + result);
        if (clientStub) {
            UnicastRemoteObject.unexportObject(this, true);
        }
    }

    /**
     * This Method sets wether a clientStub is
     * implemented or not
     *
     * @param clientStub
     * @throws RemoteException
     */
    @Override
    public void setClientStub(boolean clientStub) throws RemoteException {
        this.clientStub = clientStub;
    }
}
