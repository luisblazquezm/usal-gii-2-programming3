/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import data.Model;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author pgina27
 */
public class Controller {

    private final Model m = new Model();
    private final Path path  = Paths.get("archivodelimitado.txt");

    public int getNumeroDeElementos() {
        return m.getLista().size();
    }

    public void darValores() {
        m.giveRandomValuesToList();
    }

    public void importar() throws IOException{
        m.importListFromDelimitedFile(path,"\t");
    }

    public void exportar() throws IOException{
        m.exportListToDelimitedFile(path,"\t");
    }

    public String[] obtenerListado() {
        return m.getListOfItemsAsColumns();
    }

    public void ordenarPor(String opcion) {
        m.sortBy(opcion);
    }
    
}
