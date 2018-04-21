/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.util.List;

/**
 *
 * @author ashh412
 */
//Propósito: Guardar una referencia a las actuaciones de las personas
public class PersonOperation extends Person {

    private List<String> operations;
    
    public PersonOperation(String dni) {
        super(dni);
    }
    
    public List<String> getOperations() {
        return operations;
    }
    
    public void addOperation(String e) {
        this.operations.add(e);
    }
    
}
