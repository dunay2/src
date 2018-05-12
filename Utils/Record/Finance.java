/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Record;

/**
 *
 * @author ashh412
 */
public class Finance extends Record {

    private boolean approved;

    /**
     *
     * @param operCode
     * @param cliCode
     * @param empCode
     * @param approved
     *
     */
    public Finance(String operCode, String cliCode, String empCode, boolean approved) {
        super(operCode, cliCode, empCode, "F");
        this.approved = approved;

    }

    public boolean isApproved() {
        return approved;
    }

}
