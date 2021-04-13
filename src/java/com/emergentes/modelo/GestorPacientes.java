
package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorPacientes {
    
    private ArrayList<Pacientes> lista;

    public GestorPacientes() {
        lista = new ArrayList<Pacientes>();
    }

    public ArrayList<Pacientes> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Pacientes> lista) {
        this.lista = lista;
    }
    public void insertarPaciente(Pacientes item){
        lista.add(item);
    }
    
    public void modificarPaciente(int pos, Pacientes item){
        lista.set(pos, item);
    }
    
    public void eliminarPaciente(int pos){
        lista.remove(pos);
    }
    
    public int ObtieneId(){
        int idaux = 0;
        for(Pacientes item : lista){
            idaux = item.getId();
        }
        return idaux + 1;
    }
    
    public int ubicarPaciente(int id){
        int pos = -1;
        Iterator<Pacientes> it = lista.iterator();
        
        while (it.hasNext()){
            ++pos;
            Pacientes aux = it.next();
            if(aux.getId() == id){
                break;
            }
        }
        return pos;
    }
}
