
public class SweepingRobotFactory implements Factory {

    private String name;
    private float height;
    private float width;
    private String company;
    
    public SweepingRobotFactory(String name, float height, float width, String company) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.company = company;
    }
    
    // 掃地機器人工廠接收使用者自訂的數值製造掃地機器人
    @Override
    public Robot generateRobot() {
        return new SweepingRobot(name, height, width, company);
    }
}
