package delaunay.diabat.tp2;

import java.util.Iterator;

/**
 * PRGA - TP2
 * @author Pierre D. , Alexis D.
 * @since 2019-01-21
 * @version 1.0.1
 *
 */
public class IterateurMots implements Iterator<String> {

	private Object[] tab;
	private int cursor;
	
	public IterateurMots(Object[] tab) {
		
		this.tab = tab.clone();
		this.setCursor();
		
	}
	
    private void setCursor() {
        while (this.cursor < this.tab.length && this.tab[this.cursor] == null) {
            this.cursor++;
        }
    }
    
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean hasNext() {
		return (this.cursor < tab.length) && (this.tab[this.cursor] != null);
	}

	@Override
	public String next() {
		assert this.hasNext() : "L'itérateur n'est pas sur un objet";
		
		String concat = "";
		
		 while(this.cursor < tab.length && (this.tab[this.cursor] != null)) {
			 concat += tab[this.cursor].toString();
			 this.cursor++;
		 }
		 
		this.cursor++;
		return concat;
	}

}
