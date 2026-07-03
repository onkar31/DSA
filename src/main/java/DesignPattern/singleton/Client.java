package DesignPattern.singleton;

public class Client {
    public static void main(String[] args) {
//        DBC dbc = new DBC(); not possible

//        DBC.getInstance();
        DBC d1 = DBC.getInstance();
        DBC d2 = DBC.getInstance();
        ABC abc = new ABC();
    }
}
