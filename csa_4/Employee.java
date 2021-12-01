package csa_4;

abstract class Employee{
    private String name;
    private long number;
    private MyDate birthday;
    public Employee(String name,long number,MyDate birthday){
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }
    abstract void earnings();
    public String toString(){
        return "姓名：" + name +
                "\n电话号码：" + number +
                "\n生日：" +birthday.getDate();
    }
    public String getName(){return name;}
}
