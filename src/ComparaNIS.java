import java.util.Comparator;

public class ComparaNIS implements Comparator<ElementoIndice>{
	public int compare(ElementoIndice e1, ElementoIndice e2) {
		return e1.getNis().compareTo(e2.getNis());
	}
}
