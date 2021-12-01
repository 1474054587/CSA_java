package csa_4;

class Programmer extends Employee{
    private short money;
    @Override
    public void earnings(){
        money += 10;
    }
    public Programmer(String name, long number, MyDate birthday){
        super(name,number,birthday);
        money = 0;
    }
    public short getMoney(){
        return money;
    }
}
