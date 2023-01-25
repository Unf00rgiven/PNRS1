package ognjen.stojisavljevic.memorygame;

public class JNI {
    static {
        System.loadLibrary("MyLibrary");
    }

    public native int increment(int x);
    public native int decrement(int x);
}
