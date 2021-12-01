package csa_3;

//Car子类：Vehicle抽象父类
class Car extends Vehicle{
    public int loader;
    public Car(int loader,int wheels,double weight){
        this.loader = loader;
        this.wheels = wheels;
        this.weight = weight;
    }
    public void loading(int loader){
        System.out.println("车轮的个数是："+wheels+"  车重："+weight);
        System.out.print("这是一辆小车，能载"+this.loader+"人,实载"+loader+"人");
        if(this.loader < loader){
            System.out.println(",你超员了！！！");
        } else {
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
}
