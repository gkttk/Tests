package service;

public interface IService<T> {
    T createInstance();
    void readInstance(T obj);
    void updateInstance(T obj);
    boolean deleteInstance(T obj);
}
