package data;

import java.io.*;

public class FileStream {

    private String filePath;

    public FileStream(String filePath) {
        this.filePath = filePath;
    }

    public Object accessObject() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(this.filePath);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Object output = objectIn.readObject();
        objectIn.close();
        fileIn.close();
        return output;
    }

    public void saveObject(Object alunos) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(this.filePath);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(alunos);
        objectOut.close();
    }
}
