
public interface Robot {

    void introduce(); // 敘述自己是什麼樣的機器人
    Status[][] doWork(int length, int width, Status[][] roomArray); // 展現自己做的工作
}
