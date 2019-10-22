package saga;

import java.lang.reflect.Array;
import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Laboratório de Programação 2 - Lab 5
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

public interface Produto extends Comparable<Produto>{
    public ProdutoId getProdutoId();
    public double getPreco();
    public void setPreco(double preco);
    public boolean equals(Object o);
    public int hashCode();
    public String toString();
    default int compareTo(Produto produto){
        Collator cot = Collator.getInstance(new Locale("pt","BR"));
        if(produto != null) {
            String string = String.join("", Arrays.toString(this.toString().split("- ")));
            String string1 = String.join("", Arrays.toString(produto.toString().split("- ")));
            return cot.compare(string, string1);
        }else{
            return 0;
        }
    }
}
