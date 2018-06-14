package br.com.henrique.det.br.com.henrique.det.tabs;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.InternalStorage;
import br.com.henrique.det.R;


public class FragmentTab3 extends Fragment {

    private final Ficha character;
    private View v;

    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;

    public FragmentTab3(Ficha character) {
        this.character = character;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.fragment_tab3, container, false);

        exibeTDD();
        exibeMC();

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater mi) {
        // Inflate the menu; this adds items to the action bar if it is present.
        mi.inflate(R.menu.menu_tabs, menu);
        super.onCreateOptionsMenu(menu, mi);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.alterar) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
            alertDialogBuilder.setTitle("Deseja salvar as alterações?");
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("Salvar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    salvarAlteracoes();


                                }
                            })
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    dialog.cancel();
                                }
                            });
            alertDialogBuilder.create().show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void salvarAlteracoes(){
        String m1 = spinner.getSelectedItem().toString();
        String m2 = spinner2.getSelectedItem().toString();
        String m3 = spinner3.getSelectedItem().toString();
        String m4 = spinner4.getSelectedItem().toString();
        String m5 = spinner5.getSelectedItem().toString();

        String tdd1 = ((EditText) v.findViewById(R.id.exibeTDDForca)).getText().toString();
        String tdd2 = ((EditText) v.findViewById(R.id.exibeTDDPDF)).getText().toString();

        character.setTiposDeDanoEMagiasConhecidas(tdd1, tdd2, m1, m2, m3, m4, m5);
        InternalStorage.replaceFicha(getActivity(), character);
        Toast.makeText(getActivity(), "Alterações Salvas", Toast.LENGTH_SHORT).show();
    }


    public void exibeTDD(){

        String [] tdds = character.getTiposDeDano();

        ((EditText) v.findViewById(R.id.exibeTDDForca)).setText(tdds[0]);
        ((EditText) v.findViewById(R.id.exibeTDDPDF)).setText(tdds[1]);

    }

    public void exibeMC(){

        String[] vans = character.getMagiasConhecidas();

        spinner = (Spinner) v.findViewById(R.id.exibeMC1);
        spinner2 = (Spinner) v.findViewById(R.id.exibeMC2);
        spinner3 = (Spinner) v.findViewById(R.id.exibeMC3);
        spinner4 = (Spinner) v.findViewById(R.id.exibeMC4);
        spinner5 = (Spinner) v.findViewById(R.id.exibeMC5);

        List<String> list = new ArrayList<String>();
        list.add(vans[0]);
        List<String> list1 = new ArrayList<String>();
        list1.add(vans[1]);
        List<String> list2 = new ArrayList<String>();
        list2.add(vans[2]);
        List<String> list3 = new ArrayList<String>();
        list3.add(vans[3]);
        List<String> list4 = new ArrayList<String>();
        list4.add(vans[4]);

        if(TextUtils.isEmpty(vans[0])){
            list = new ArrayList<String>();
            populaSpinnerVazio(list);
        }
        if(TextUtils.isEmpty(vans[1])){
            list1 = new ArrayList<String>();
            populaSpinnerVazio(list1);
        }
        if(TextUtils.isEmpty(vans[2])){
            list2 = new ArrayList<String>();
            populaSpinnerVazio(list2);
        }
        if(TextUtils.isEmpty(vans[3])){
            list3 = new ArrayList<String>();
            populaSpinnerVazio(list3);
        }
        if(TextUtils.isEmpty(vans[4])){
            list4 = new ArrayList<String>();
            populaSpinnerVazio(list4);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list1);
        dataAdapter1.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list2);
        dataAdapter2.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list3);
        dataAdapter3.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list4);
        dataAdapter4.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter1);
        spinner3.setAdapter(dataAdapter2);
        spinner4.setAdapter(dataAdapter3);
        spinner5.setAdapter(dataAdapter4);

    }

    public void populaSpinnerVazio(List<String> list){
        list.add("");
        list.add("Acordar");
        list.add("Ao Alcance da Mão");
        list.add("O Amor Incontestavel de Raviollus");
        list.add("Anfíbio");
        list.add("A Aporrinhação de Nimb");
        list.add("O Apavorante Gás de Luigi");
        list.add("Arma de Allhana");
        list.add("Armadura de Alhana");
        list.add("Armadura Elétrica");
        list.add("Armadura Extra");
        list.add("Armadura Espiritual");
        list.add("Arpão");
        list.add("Asfixia");
        list.add("Ataque Vibratório");
        list.add("Ataque Vorpal");
        list.add("Aumento de Dano");
        list.add("Barreira Mística");
        list.add("Barreira de Vento");
        list.add("Bola de Fogo");
        list.add("Bola de Lama");
        list.add("Bola de Vento");
        list.add("Bolas Explosivas");
        list.add("Bomba Aérea");
        list.add("Bomba de Luz");
        list.add("Bomba de Terra");
        list.add("Bomba de Vento");
        list.add("Brilho de Espírito");
        list.add("Brilho Explosivo");
        list.add("Buraco Negro");
        list.add("Cajado em Cobra");
        list.add("Cancelamento Superior");
        list.add("O Canto da Sereia");
        list.add("Cegueira");
        list.add("Chuva Congelante");
        list.add("Chuva Quente");
        list.add("Coma");
        list.add("Comando de Khalmyr");
        list.add("Consertar");
        list.add("Contra-Ataque Mental");
        list.add("Controle de Mortos-Vivos");
        list.add("Corpo Elemental");
        list.add("O Crânio Voador de Vladislav");
        list.add("Criar Pântano");
        list.add("Criar Vento");
        list.add("Criação de Mortos-vivos");
        list.add("Criatura Mágica");
        list.add("Criatura Mágica Superior");
        list.add("Criatura Mágica Suprema");
        list.add("Cura de Maldição");
        list.add("Cura Para o Mal");
        list.add("Cura Para os Mortos");
        list.add("Cura Total");
        list.add("Dardos de Agonia");
        list.add("Desejo");
        list.add("Desmaio");
        list.add("Destrancar");
        list.add("Destruição do Espírito");
        list.add("Desvios de Disparos");
        list.add("Detecção do Mal");
        list.add("Dominação Total");
        list.add("Encontro Aleatório");
        list.add("Enfraquecer Magia");
        list.add("Enxame de Trovões");
        list.add("A Erupção de Aleph");
        list.add("A Escapatória de Valkaria");
        list.add("Esconjuro de Mortos-Vivos");
        list.add("Escuridão");
        list.add("Explosão");
        list.add("Fada Servil");
        list.add("Farejar Tesouro");
        list.add("Fascinação");
        list.add("Feras de Tenebra");
        list.add("Ferrões Venenosos");
        list.add("Flecha de Vento");
        list.add("Ilusão");
        list.add("Ilusão Avançada");
        list.add("Ilusão Total");
        list.add("Imagem Turva");
        list.add("Impulso");
        list.add("Inferno de Gelo");
        list.add("Invisibilidade");
        list.add("Invisibilidade Superior");
        list.add("Invocação do Dragão");
        list.add("Invocação do Elemtal");
        list.add("Invocação do Elemental Superior");
        list.add("Invocação do Elemental Supremo");
        list.add("Invulnerabilidade");
        list.add("Lágrimas de Wynna");
        list.add("A Lança Infalível de Talude");
        list.add("Leitura de Lábios");
        list.add("Luz");
        list.add("Maldição das Trevas");
        list.add("Marcha da Batalha");
        list.add("Marcha da Coragem");
        list.add("Magia Perdida");
        list.add("Marionete");
        list.add("Mata-Dragão");
        list.add("Megalon");
        list.add("Mikron");
        list.add("Monstros do Pântano");
        list.add("Morte Estelar");
        list.add("Mundo dos Sonhos");
        list.add("Muralha de Energia");
        list.add("Nevasca");
        list.add("Nobre Montaria");
        list.add("Ondas de Vento");
        list.add("Pacto com a Serpente");
        list.add("Pânico");
        list.add("Paralisia");
        list.add("Permanência");
        list.add("Petrificação");
        list.add("Poder Telepático");
        list.add("Porta Dimensional");
        list.add("Presença Distante");
        list.add("Proteção Mágica Superior");
        list.add("Raio Desintegrador");
        list.add("Raio Espiritual");
        list.add("Recuperação");
        list.add("Recuperação Natural");
        list.add("Reflexos");
        list.add("Ressurreição");
        list.add("Roubo de Magia");
        list.add("Roubo de Vida");
        list.add("Sacrifício do Herói");
        list.add("Sanidade");
        list.add("Sentidos Especiais");
        list.add("Silêncio");
        list.add("O Soco de Arsenal");
        list.add("Socos Explosivos");
        list.add("Sono");
        list.add("Teleportação");
        list.add("Teleportação Planar");
        list.add("Tempestade Explosiva");
        list.add("Terremoto");
        list.add("Toque do Unicórnio");
        list.add("Trancar");
        list.add("Transformação");
        list.add("Transformação em Outro");
        list.add("Transporte");
        list.add("Túnel");
        list.add("Vazio");
        list.add("Vento Espiritual");
        list.add("Verter Água de Pedra");
        list.add("Visão do Passado Recente");
        list.add("Visão do Passado remoto");
    }


}
