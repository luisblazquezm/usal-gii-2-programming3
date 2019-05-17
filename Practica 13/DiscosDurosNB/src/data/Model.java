/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author pgina27
 */
public class Model {
    
    private final ArrayList<HardDisk> lista = new ArrayList<>();

    public void giveRandomValuesToList() {
        for (int i = 0; i < 30; i++){
            lista.add(HardDisk.instanceWithRandomAttributes());
        }
    }

    public String[] getListOfItemsAsColumns() {
        String[] lineas = new String[lista.size()];
        for (int i = 0; i < lineas.length; i++) {
            lineas[i] = lista.get(i).exportStateAsColumns();
        }
        return lineas;
    }

    public void importListFromDelimitedFile(Path path, String delimiter) throws IOException {
        ArrayList<HardDisk> result;
        String fileContent;
        List<String> lineas = Files.readAllLines(path,Charset.forName("UTF-8"));
        for (String line : lineas){
            HardDisk hd = HardDisk.instanceWithRandomAttributes();
            if(null == hd){
                lista.add(hd);
            }
        }
    }

    public void exportListToDelimitedFile(Path path, String delimiter) throws IOException {
        List<String> lineas = new ArrayList<>();
        for (HardDisk hd : lista){
            lineas.add(hd.exportStateWithDelimiters(delimiter));
        }
        Files.write(path, lineas,Charset.forName("UTF-8"));
    }

    public void sortBy(String opcion) {
        Comparator <HardDisk> c;
        switch(opcion){
            case "1": c = new ComparadorDeFabricante();         break;
            case "2": c = new ComparadorDeMegabytes();          break;
            case "3": c = new ComparadorDeModelo();             break;
            case "4": c = new ComparadorNumeroDeSerie();        break;
            case "5": c = new ComparadorDeTasaDeTransmision();  break;
            case "6": c = new ComparadorDeTecnologia();         break;
            case "7": c = new ComparadorDeTipoDeInterfaz();     break;
            case "8": c = new ComparadorDeVelocidad();          break;
            default:  c = new ComparadorDeFabricante();         break;
        }
                    
        Collections.sort(lista, c);
    
            
    }

    public ArrayList<HardDisk> getLista() {
        return lista;
    }
    
}
