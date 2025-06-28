package model;

import java.util.ArrayList;
import java.util.List;

public class Estoque{

    static private List<Camisa> lista_camisa = new ArrayList<>();
    static private List<Calca> lista_calca = new ArrayList<>();


    //Método para consultar camisas do estoque
    static public List<Camisa> getListaCamisa(){
        return lista_camisa;
    }

    //Método para consultar calças do estoque
    static public List<Calca> getListaCalca(){
        return lista_calca;
    }

    //Cadastra camisa no estoque
    public static void adicionarCamisa(Camisa camisa) {
        lista_camisa.add(camisa);
    }

    //Cadastra calça no estoque
    public static void adicionarCalca(Calca calca) {
        lista_calca.add(calca);
    }
}
