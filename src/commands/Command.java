package commands;

import java.io.Serializable;

/**
 * Created by pkogler on 16.03.2016.
 */
public interface Command extends Serializable {
    /**
     * Execute Method
     */
    public void execute();
}
