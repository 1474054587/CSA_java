package csa_3;

//Truck子类：Vehicle抽象父类
class Truck extends Vehicle{
    public int loader;
    public long payload;
    public Truck(int loader,int wheels,double weight,long payload){
        this.loader = loader;
        this.wheels = wheels;
        this.weight = weight;
        this.payload = payload;
    }
    public void loading(int loader,double payload){
        System.out.println("车轮的个数是："+wheels+"  车重："+weight);
        System.out.print("这是一辆卡车，能载"+this.loader+"人,实载"+loader+"人");
        if(this.loader < loader){
            System.out.println(",你超员了！！！");
        } else {
            System.out.println();
        }
        System.out.print("这是一辆卡车，核载"+this.payload+"kg,你已装载"+payload+"kg");
        if(this.payload < payload){
            System.out.println(",你超载了！！！");
        } else {
            System.out.println();
        }

        System.out.println("-----------------------------");
    }
}
