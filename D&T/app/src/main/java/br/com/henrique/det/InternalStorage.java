package br.com.henrique.det;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by Henrique on 15/09/2015.
 */
public class InternalStorage {

    private InternalStorage() {}

    public static void writeObject(Context context, String key, Object object) throws IOException {
        FileOutputStream fos = context.openFileOutput(key, Context.MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
        fos.close();
    }

    public static Object readObject(Context context, String key) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = context.openFileInput(key);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object object = ois.readObject();
        return object;
    }

    public static boolean fileExistance(Context context){
        File file = context.getFileStreamPath("personagens");
        return file.exists();
    }

    public static boolean deletaFicha(Context contexto, int indice){
        try {
            List<Ficha> fichas = (List<Ficha>)readObject(contexto, "personagens");
            fichas.remove(indice);
            writeObject(contexto, "personagens", fichas);
            return true;
        } catch (Exception e){
            e.printStackTrace();;
            return false;
        }


    }

    public static void replaceFicha(Context contexto, Ficha personagem){

       try {
            List<Ficha> fichas = (List<Ficha>)readObject(contexto, "personagens");
            for(Ficha fs : fichas){
                if(fs.equals(personagem)){

                    fichas.remove(fs);
                    fichas.add(personagem);

                }
            }

            writeObject(contexto, "personagens", fichas);

        } catch (Exception e){
           Log.d("Erro", "Replace");
            e.printStackTrace();;

        }
    }


}
