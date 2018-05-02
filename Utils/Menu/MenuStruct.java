/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Menu;

/**
 *
 * @author ashh412
 */
public class MenuStruct {

private final String mnuNanme;
private final String mnuText;

    public MenuStruct(String mnuNanme, String mnuText) {
        this.mnuNanme = mnuNanme;
        this.mnuText = mnuText;
    }

    public String getMnuNanme() {
        return mnuNanme;
    }

    public String getMnuText() {
        return mnuText;
    }

    


}
