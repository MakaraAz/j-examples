package util;

import java.io.*;

public class FileUtil {

    public static void writeObject(Object obj, String fileName){
        try(FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Object readObject(String fileName){
        Object obj = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            obj = ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            return obj;
        }
    }
}
