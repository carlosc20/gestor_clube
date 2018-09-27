package data;

import java.io.IOException;

public class FacadeData {

    private static final FacadeData INSTANCE = new FacadeData();
    private final String filePath = "data.ser";

    private FacadeData () {}

    public static FacadeData getInstance() {
        return INSTANCE;
    }

    public void saveState(Object state) throws IOException {
        FileStream fs = new FileStream(this.filePath);
        fs.saveObject(state);
    }

    public Object accessState() throws IOException, ClassNotFoundException {
        FileStream fs = new FileStream(this.filePath);
        return fs.accessObject();
    }
}
