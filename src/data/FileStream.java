package data;

import java.io.*;

class FileStream {

    private String filePath;

    FileStream(String filePath) {
        this.filePath = filePath;
    }

    Object accessObject() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(this.filePath);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Object output = objectIn.readObject();
        objectIn.close();
        fileIn.close();
        return output;
    }

    void saveObject(Object alunos) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(this.filePath);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(alunos);
        objectOut.close();
    }
}
