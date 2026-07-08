package DesignPattern.factory;

public class FlutterExecutorFactory {

    public static FlutterExecutor createFlutterExecutorBasedOnPlatform(Platforms platforms){
        switch (platforms){
            case IOS ->{
                return  new IosFlutterExecutor();
            }
            case ANDROID -> {
                return  new AndriodFlutterExecutor();
            }
        }
        return null;
    }
}
