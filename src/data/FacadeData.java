package data;

import java.io.IOException;
import java.io.Serializable;

public class FacadeData implements Serializable {

    private static final FacadeData INSTANCE = new FacadeData();
    private final String filePath = "data.ser";

    private FacadeData () {}

    //Retorna a instância do Facade da Data
    public static FacadeData getInstance() {
        return INSTANCE;
    }

    //Recebe o estado e guarda o estado no ficheiro "data.ser"
    public void saveState(Object state) throws IOException {
        FileStream fs = new FileStream(this.filePath);
        fs.saveObject(state);
    }

    //Retorna o estado guardado no ficheiro "data.ser"
    public Object accessState() throws IOException, ClassNotFoundException {
        FileStream fs = new FileStream(this.filePath);
        return fs.accessObject();
    }
}
