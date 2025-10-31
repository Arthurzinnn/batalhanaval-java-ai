package batalhanaval_java;

import java.util.Scanner;

public class Application{

	public static void main(String[] args) 
	{
		
		Scanner in = new Scanner(System.in);
		
		String[][] mapa = new String[8][8];
		
		int[] tamanhoBarco = new int[4];
		
		String[] direcaoBarco = new String[4];
		
		String[] posicaoBarco = new String[4];
		
		for(int i = 0; i < 4; i++)
		{
			
			while(true)
			{
				
				System.out.println("Escolha seu barco");
				System.out.println("Digite '1' para: jet ski (2 espaços)");
				System.out.println("Digite '2' para: canoa (3 espaços)");
				System.out.println("Digite '3' para: navio cargueiro (4 espaços)");
				System.out.println("Digite '4' para: porta avioes (5 espaços)");
				
				tamanhoBarco[i] = in.nextInt();
				
				if(tamanhoBarco[i] < 1 || tamanhoBarco[i] > 4)
					System.out.println("Tamanho inválido");
				else
					break;
				
			}
			
			while(true)
			{
				
				System.out.println("Escolha a direção do seu barco (ex: v ou h)");
				
				direcaoBarco[i] = in.next();
				
				if(!direcaoBarco[i].equals("v") && !direcaoBarco[i].equals("h"))
					System.out.println("Direção inválida");
				else
					break;
				
			}
			
			while(true)
			{
				
				System.out.println("Escolha a posição do seu barco (ex: 11)");
				
				posicaoBarco[i] = in.next();
				
				if(Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(0))) > 8 || Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(1))) > 8)
					System.out.println("Posição inválida");
				else if(direcaoBarco[i].equals("v") && Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(0))) > 8-tamanhoBarco[i])
					System.out.println("Posição inválida");
				else if(direcaoBarco[i].equals("h") && Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(1))) > 8-tamanhoBarco[i])
					System.out.println("Posição inválida");
				else
					break;
				
			}
			
			if(direcaoBarco[i].equals("v"))
			{
				
				for(int j = 0; j < tamanhoBarco[i]+1; j++)
				{
					
					mapa[Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(0)))-1+j][Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(1)))-1] = "b";
					
				}
				
			}
			else if(direcaoBarco[i].equals("h"))
			{
				
				for(int j = 0; j < tamanhoBarco[i]+1; j++)
				{
					
					mapa[Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(0)))-1][Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(1)))-1+j] = "b";
					
				}
				
			}
			
			for(int j = 0; j < 8; j++)
			{
				
				for(int k = 0; k < 8; k++)
				{
					
					if(mapa[j][k] == null)
						System.out.print("~");
					else
					
						System.out.print(mapa[j][k]);
					
				}
				
				System.out.println();
				
			}
			
		}
		
	}
	
}
