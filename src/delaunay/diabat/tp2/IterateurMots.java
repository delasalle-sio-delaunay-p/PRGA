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
		int cursor = -1;
		int i = 0;
		
		
		while (this.tab[i] != null && i < tab.length) 
		{
			++i;
		}
		
		cursor = i;
		
		if (cursor == -1) {
			cursor = tab.length + 1;
		}
			   
		this.cursor = cursor;
		
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean hasNext() {
		return (this.cursor <= tab.length);
	}

	@Override
	public String next() {
		
		String concat = "";
		
		while (this.hasNext()) {
			
			concat += this.tab[this.cursor];
			this.cursor++;
			
		}
			
		return concat;
	}

}
