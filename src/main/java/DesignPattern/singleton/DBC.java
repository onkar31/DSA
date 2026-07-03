package DesignPattern.singleton;

public class DBC {

    private static DBC dbc = null;
    private DBC() {}

    public static DBC getInstance() {
        if (dbc == null) {
            synchronized (DBC.class) {
                if(dbc == null) {
                    dbc = new DBC();
                }
            }
        }
        return dbc;
    }
}
