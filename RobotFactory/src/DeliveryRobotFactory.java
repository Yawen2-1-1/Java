
public class DeliveryRobotFactory implements Factory {

    private String name;
    private float height;
    private float width;
    private String company;
    
    public DeliveryRobotFactory(String name, float height, float width, String company) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.company = company;
    }
    
    // 送貨機器人工廠接收使用者自訂的數值製造送貨機器人
    @Override
    public Robot generateRobot() {
        return new DeliveryRobot(name, height, width, company);
    }
}
