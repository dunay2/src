/*
To compare (or find) two Java objects, we need to override both equals and hashCode (Good practice).
 */
package Utils.Record;

import java.util.Objects;

/**
 *
 * @author ashh412
 */
//Proposito: Definir una clave multiple de acceso a un Hashmap
public class Key {

    private final String codCli;
    private final String codEmp;
    private final String codOper;

    public Key(String codCli, String codEmp, String codOper) {
        this.codCli = codCli;
        this.codEmp = codEmp;
        this.codOper = codOper;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof Key)) {
            return false;
        }
        Key key = (Key) o;
        return codCli == key.codCli
                && Objects.equals(codEmp, key.codEmp)
                && Objects.equals(codOper, key.codOper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCli, codEmp, codOper);
    }

}
