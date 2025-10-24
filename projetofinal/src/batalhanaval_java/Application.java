package batalhanaval_java;

import java.util.Scanner;

public class Application{

	public static void main(String[] args) 
	{
		
		Scanner in = new Scanner(System.in);
		
		String[][] mapa = new String[8][8];
		 
		System.out.println("Escolha seu barco");
		System.out.println("Digite '1' para: jet ski (2 espaços)");
		System.out.println("Digite '2' para: canoa (3 espaços)");
		System.out.println("Digite '3' para: navio cargueiro (4 espaços)");
		System.out.println("Digite '4' para: porta avioes (5 espaços)");
		
		int tamanhoBarco = in.nextInt();
		
		System.out.println("Escolha a posição do seu barco (ex: 11)");
		
		String posicaoBarco = in.next();
		
		for(int i = 0; i < tamanhoBarco+1; i++)
		{
			
			mapa[Integer.parseInt(String.valueOf(posicaoBarco.charAt(0)))][Integer.parseInt(String.valueOf(posicaoBarco.charAt(1)))+i] = "b";
			
		}
		
		for(int i = 0; i < 8; i++)
		{
			
			for(int j = 0; j < 8; j++)
			{
				
				if(mapa[i][j] == null)
					System.out.print("~");
				else
				
				System.out.print(mapa[i][j]);
				
			}
			
			System.out.println();
			
		}
		
	}
	
}
