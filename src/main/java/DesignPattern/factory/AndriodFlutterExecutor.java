package DesignPattern.factory;

public class AndriodFlutterExecutor implements FlutterExecutor {
    @Override
    public void startApp() {

    }

    @Override
    public void printHelloworld() {

    }

    @Override
    public AndroidButton createList() {
        return new AndroidButton();
    }
}
