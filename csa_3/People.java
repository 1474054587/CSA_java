package csa_3;

//People类：Monkey子类
class People extends Monkey{
    public People(String name){
        super(name);
    }
    @Override
    public void speak(){
        System.out.println("小样的，不错嘛！会说话了！");
    }
    public void think(){
        System.out.println("别说话！认真思考！");
    }
}