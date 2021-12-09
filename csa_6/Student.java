package csa_6;

public class Student {
    private String SNO;
    private String Name;
    private int age;
    private String College;

    @Override
    public String toString() {
        return "Student{" +
                "SNO='" + SNO + '\'' +
                ", Name='" + Name + '\'' +
                ", age=" + age +
                ", College='" + College + '\'' +
                '}';
    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }
}
