package DesignPattern.factory;

public class Client {
    public static void main(String[] args) {
        FlutterExecutor flutterExecutor = FlutterExecutorFactory
                .createFlutterExecutorBasedOnPlatform(Platforms.ANDROID);

        Button button = flutterExecutor.createList();
    }
}
