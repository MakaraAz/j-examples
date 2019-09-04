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
//            ignore
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            return obj;
        }
    }

    public static void writeObjectByObject(Object[] objects, String fileName, boolean append) throws Exception{
        try(FileOutputStream fos = new FileOutputStream(fileName, append); ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for(Object obj : objects){
                oos.writeObject(obj);
            }
        }
    }

    public static Object[] readObjectByObject(int objCount, String fileName) throws Exception{
        Object[] objects = new Object[objCount];
        try(FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis)){
            for (int i=0; i<objCount; i++){
                Object obj = ois.readObject();
                objects[i] = obj;
            }
        }

        return objects;
    }
}
