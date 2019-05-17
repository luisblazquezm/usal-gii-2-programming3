/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

/**
 *
 * @author pgina27
 */
public class Model {
    
//  List<Ficha> lista;    
    Ficha[] lista;
    
    public List<String> getListOfItemsAsColumns() {
        List<String> result = new ArrayList<>();
        String separador
                = "+----------+-----------------+--------------+----+----+--------+----------------------+";
        result.add(separador);
        if (null == lista[0]){
            return null;
        }
        for (Ficha f : lista){
            result.add(f.exportStateAsColumns());
            result.add(separador);
        }
        return result;
    }
    
    public void sortBy(String opcion) {
        Comparator<Ficha> c;
        switch(opcion.toLowerCase()){
            case "1": c = new ComparadorDeDNI();             break;
            case "2": c = new ComparadorDeNombre();          break;
            case "3": c = new ComparadorDeApellidos();       break;
            case "4": c = new ComparadorDeCurso();           break;
            case "5": c = new ComparadorDeGrupo();           break;
            case "6": c = new ComparadorDeCalificacion();  break;
            default:  c = new ComparadorDeNombre();          break;
        }
        
        Arrays.sort(lista,c);
    }
    
    public void giveRandomValuesToList(int numItems) {
        
    }
    

    
}
