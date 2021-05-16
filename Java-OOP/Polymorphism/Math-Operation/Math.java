package InterfacesAndAbstraction.MathOperation;

public class Math {

    public static int add(int f, int s){
        return f + s;
    }

    public static int add(int f, int s, int t){
        return add(add(f,s),t);
    }

    public static int add(int f, int s, int t, int d){
        return add(add(f,s,t),d);
    }

}
