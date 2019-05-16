import java.io.RandomAccessFile;
import java.util.Scanner;

public class BuscaNIS {
	public static void main(String[] args) throws Exception{
		RandomAccessFile f = new RandomAccessFile("bolsa.ind","r");
		RandomAccessFile f2 = new RandomAccessFile("bolsa2.csv","r");
		ElementoIndice e = new ElementoIndice();
		Scanner input = new Scanner(System.in);
		long posicao, primeiro, ultimo, meio;
		f.seek(f.length());
		posicao = f.getFilePointer();
		primeiro = 0;
		ultimo = (posicao/24);
		System.out.println("Digite o NIS. Ele e composto de 14 numeros: ");
		String nisInput = input.nextLine();
		boolean achou = false;
		while(primeiro<=ultimo && achou==false) {
			posicao = f.getFilePointer()/24;
			e = new ElementoIndice();
			meio=(primeiro+ultimo)/2;
			f.seek(meio*24);
			e.le(f);
			long nis1 = Long.parseLong(nisInput);
			long nis2 = Long.parseLong(e.getNis());
			if(nis1==nis2)
				achou=true;
			else if(nis1>nis2)
				primeiro=meio+1;
			else if(nis1<nis2)
				ultimo=meio-1;
		}
		if(!achou)
			System.out.println("NIS nao encontrado");
		else {
			String linha;
			f2.seek(e.getPosicao());
			linha = f2.readLine();
			System.out.println(linha);
		}
		f.close();
		f2.close();
		input.close();
	}

}
