package clientCallback;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by pkogler on 16.03.2016.
 */
public class CalcPiCallback implements Callback {
    private boolean clientStub;
    @Override
    public void getResult(BigDecimal result) throws RemoteException {
        System.out.println("Result:\t" + result);
        if (clientStub) {
            UnicastRemoteObject.unexportObject(this, true);
        }
    }

    @Override
    public void setClientStub(boolean clientStub) throws RemoteException {
        this.clientStub = clientStub;
    }
}
