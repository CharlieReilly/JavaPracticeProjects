package InterfaceChallenge;

import java.util.ArrayList;

public interface ISaveable {

    ArrayList valuesToList() throws IllegalAccessException;

    void populateFromList(ArrayList values);
}
