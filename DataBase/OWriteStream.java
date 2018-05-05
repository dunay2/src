/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.io.*;

/**
 *
 * @author ashh412
 */
//Esta clase hereda sus propiedades de ObjectOutputStream
public class OWriteStream extends ObjectOutputStream {
    //Sobrescribimos el método que crea la cabecera

    @Override
    protected void writeStreamHeader() throws IOException {
        // No hacer nada.

    }

    //Constructores

    /**
     *
     * @throws IOException
     */
    public OWriteStream() throws IOException {
        super();
    }

    /**
     *
     * @param out
     * @throws IOException
     */
    public OWriteStream(OutputStream out) throws IOException {
        super(out);
    }
}


