package com.py.somesuggest.frist_chapter.no11;

import java.io.*;

/**
 * Created by Administrator on 2017/9/10 0010.
 */
public class SerializationUtils {
    private static String FILE_NAME = "E:/object.bin";

    //序列化
    public static void writeObject(Serializable s) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(s);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object readObject() {
        Object obj = null;
        //反序列化
        try {
            ObjectInput input = new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj = input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
