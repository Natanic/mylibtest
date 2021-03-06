package me.noear.cache;

import android.content.Context;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import me.noear.utils.EncryptUtil;

/**
 * Created by yuety on 15/7/22.
 *
 * 本地数据缓存处理(接口根据需要调整)
 */
public class FileCache implements ICache{
    final File dir;

    public FileCache(Context context, String block) {
        File _root = null;
        if (_root == null) {
            _root = context.getExternalFilesDir(null);
        }

        if (_root == null) {
            _root = context.getFilesDir();
        }

        dir = new File(_root,block);
        if(dir.exists()==false){
            dir.mkdirs();
        }
    }

    File getFile(String key) {
        String key_md5 = EncryptUtil.md5(key);
        String path = key_md5.substring(0, 2);
        File dir2 = new File(dir,path);
        if(dir2.exists()==false){
            dir2.mkdir();
        }

        return new File(dir2, key_md5);
    }


    public void save(String key, String data){
        File file = getFile(key);
        try {
            if (file.exists() == false) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, false);
            fw.write(data);
            fw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public CacheBlock get(String key) {
        File file = getFile(key);
        if(file.exists()==false)
            return null;
        else{
            try {
                CacheBlock block = new CacheBlock();
                block.value = toString(file);
                block.time  = new Date(file.lastModified());
                return block;
            }catch (IOException ex){
                ex.printStackTrace();
                return null;
            }
        }
    }

    public void delete(String key) {
        File file = getFile(key);
        if(file.exists()){
            file.delete();
        }
    }

    public boolean isCached(String key) {
        File file = getFile(key);
        return file.exists();
    }

    //--------
    public static String toString(File is) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(is));
        return doToString(in);
    }

    static String doToString(BufferedReader in) throws IOException{
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null){
            buffer.append(line).append("\r\n");
        }
        return buffer.toString();
    }
}
