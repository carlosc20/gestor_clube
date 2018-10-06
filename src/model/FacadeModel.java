package model;

public class FacadeModel {
    private static FacadeModel ourInstance = new FacadeModel();

    public static FacadeModel getInstance() {
        return ourInstance;
    }

    private FacadeModel() {
    }
}
