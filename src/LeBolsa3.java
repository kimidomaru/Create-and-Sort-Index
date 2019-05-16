import java.io.*;
import java.util.*;
import java.io.DataOutput;


class LeBolsa3
{
	public static void main(String args[]) throws Exception
	{
        long contador = 0;
		String linha;
		String colunas[];
        long posicao;
        //ArrayList<ElementoIndice> a = new ArrayList<ElementoIndice>(14000000);
        ArrayList<ElementoIndice> a = new ArrayList<ElementoIndice>(4300);
		RandomAccessFile f = new RandomAccessFile("bolsa2.csv", "r");
		RandomAccessFile f2 = new RandomAccessFile("bolsa.ind", "rw");
		f.readLine();
		while(f.getFilePointer() < f.length())
		{
			posicao = f.getFilePointer();
			linha = f.readLine();
			colunas = linha.split("\t");
            ElementoIndice e = new ElementoIndice();
            e.nis = colunas[7];
            e.posicao = posicao;
            //e.escreve(f2);
            a.add(e);
            if(contador % 10000 == 0)
            {
                System.out.print(".");
            }
            if(contador % 100000 == 0)
            {
                System.out.print("*");
            }
            if(contador % 1000000 == 0)
            {
                System.out.print("#");
            }
            contador++;
            
//			System.out.println("NIS => " + nis + " esta na posicao " + posicao);
		}
		Collections.sort(a, new ComparaNIS());
		for(int i=0;i<a.size();i++) {
			ElementoIndice e = a.get(i);
			e.escreve(f2);
		}
        f.close();
        f2.close();
	}

}