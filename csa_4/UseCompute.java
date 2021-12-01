package csa_4;

class UseCompute{
    Plus plus = new Plus();
    Minus minus = new Minus();
    Multiply multiply = new Multiply();
    Divide divide = new Divide();
    public void useCom(Compute com,int one,int two){
        try {
            System.out.println(com.computer(one,two));
        }catch (Exception e){
            System.out.println("分母不能为0");
        }
    }
}
interface Compute{
    int computer(int n,int m);
}
class Plus implements Compute{
    @Override
    public int computer(int n,int m){
        return n+m;
    }
}
class Minus implements Compute{
    @Override
    public int computer(int n, int m) {
        return n-m;
    }
}
class Multiply implements Compute{
    @Override
    public int computer(int n, int m) {
        return n*m;
    }
}
class Divide implements Compute{
    @Override
    public int computer(int n, int m) {
        return n/m;
    }
}
