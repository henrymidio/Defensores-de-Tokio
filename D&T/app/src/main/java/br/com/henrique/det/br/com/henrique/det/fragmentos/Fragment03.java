package br.com.henrique.det.br.com.henrique.det.fragmentos;


import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment03 extends Fragment {

    //Tipos de dano
    private String tdd1;
    private String tdd2;

    //Magias conhecidas
    private String magia1;
    private String magia2;
    private String magia3;
    private String magia4;
    private String magia5;

    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;

    public Fragment03() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment03, container, false);



        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        spinner4 = (Spinner) view.findViewById(R.id.spinner4);
        spinner5 = (Spinner) view.findViewById(R.id.spinner5);


        List<String> list = new ArrayList<String>();
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

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (view.getContext(), R.layout.layout_custom_spinner, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
        spinner3.setAdapter(dataAdapter);
        spinner4.setAdapter(dataAdapter);
        spinner5.setAdapter(dataAdapter);

        return view;
    }

    public void setaTiposDeDanoEMagiasConhecidas(Ficha personagem){

        tdd1 = ((EditText) getView().findViewById(R.id.exibeTDDForca)).getText().toString();
        tdd2 = ((EditText) getView().findViewById(R.id.exibeTDDPDF)).getText().toString();

        magia1 = spinner.getSelectedItem().toString();
        magia2 = spinner2.getSelectedItem().toString();
        magia3 = spinner3.getSelectedItem().toString();
        magia4 = spinner4.getSelectedItem().toString();
        magia5 = spinner5.getSelectedItem().toString();

        personagem.setTiposDeDanoEMagiasConhecidas(tdd1, tdd2, magia1, magia2, magia3, magia4, magia5);

    }


}
