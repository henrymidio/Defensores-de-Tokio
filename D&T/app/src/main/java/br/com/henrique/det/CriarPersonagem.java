package br.com.henrique.det;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CriarPersonagem extends ActionBarActivity {

    int pontos;

    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_personagem);

        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#550000ff")));
        bar.setTitle("D&T");
        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayUseLogoEnabled(false);
        bar.setDisplayShowHomeEnabled(false);

        final Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        RelativeLayout linearLayout = new RelativeLayout(this);
        final NumberPicker aNumberPicker = new NumberPicker(this);
        aNumberPicker.setMaxValue(12);
        aNumberPicker.setMinValue(0);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(50, 50);
        RelativeLayout.LayoutParams numPicerParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        numPicerParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        linearLayout.setLayoutParams(params);
        linearLayout.addView(aNumberPicker, numPicerParams);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Pontuaçao");
        alertDialogBuilder.setView(linearLayout);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                pontos = aNumberPicker.getValue();
                                intent.putExtra("pontos", pontos);
                                getBaseContext().startActivity(intent);

                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        });
        alertDialog = alertDialogBuilder.create();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_criar_personagem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.novo) {
            //Define pontuação inicial e chama tela de criação de personagem
            alertDialog.show();
            return true;

        }

        if (id == R.id.manual){
            Uri uri = Uri.parse("https://docs.google.com/file/d/0B8RuOkz20HXSNzVjNDViZWQtNjUzZi00NzhmLWJmNjUtNThiY2Y0M2UxYjI2/edit");
            Intent drive = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(drive);
        }

        if (id == R.id.lista) {
            //Verifica se existe fichas criadas para listar
            try{

                if(InternalStorage.fileExistance(this)){



                    final List<Ficha> fichas = (List<Ficha>)InternalStorage.readObject(this, "personagens");


                    Dialog dialog = new Dialog(this);
                    dialog.setContentView(R.layout.list_view);
                    dialog.setCancelable(true);
                    dialog.setTitle("Fichas de Personagem");

                    ListView lv = (ListView) dialog.findViewById(R.id.lv);
                    MyCustomAdapter adapter = new MyCustomAdapter(fichas, CriarPersonagem.this);
                    lv.setAdapter(adapter);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Log.i("Hello!", "Clicked! YAY!");
                            Intent in = new Intent(CriarPersonagem.this, Tabs.class);
                            in.putExtra("personagem", fichas.get(position));
                            in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getBaseContext().startActivity(in);
                        }
                    });

                    dialog.show();


                } else {Toast.makeText(this, "Nenhum personagem encontrado", Toast.LENGTH_LONG).show();}

            } catch (Exception exc) {
                Log.e("test", "test");
                    Toast.makeText(this, "Erro ao buscar fichas de personagem", Toast.LENGTH_LONG).show();

                exc.printStackTrace();
            }



        }

        return super.onOptionsItemSelected(item);
    }


}
