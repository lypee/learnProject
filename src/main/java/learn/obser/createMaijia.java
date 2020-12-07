package learn.obser;

public class createMaijia implements maijia{
    public String name  ;

    public createMaijia(String name) {
        this.name = name;
    }

    @Override
    public void update(int newMoney) {
        System.out.println(name + " 接收到新价格为： "+ newMoney);
    }
}
