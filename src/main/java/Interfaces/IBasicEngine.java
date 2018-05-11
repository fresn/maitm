package Interfaces;

public interface IBasicEngine {
    public IBasicEngine page(String URL, String pageName);
    public IBasicEngine page(String pageName);
    public IBasicEngine close();
    public void quit();
}
