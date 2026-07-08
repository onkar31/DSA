package DesignPattern.factory;

public class IosFlutterExecutor implements FlutterExecutor {

    @Override
    public void startApp() {

    }

    @Override
    public void printHelloworld() {

    }

    @Override
    public iosButton createList() {
        return new iosButton();
    }
}
