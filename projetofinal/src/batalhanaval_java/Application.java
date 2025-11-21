package batalhanaval_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Application{

	public static void main(String[] args) 
	{
		
		Scanner in = new Scanner(System.in);
		
		String modoDeJogo;
		
		String[][] mapa = new String[8][8];
		
		int[] tamanhoBarco = new int[4];
		
		String[] direcaoBarco = new String[4];
		
		String[] posicaoBarco = new String[4];
		
		Random rand = new Random();
		
		while(true)
		{
			
			System.out.println("Escolha seu modo de jogo (1: 2 Jogadores | 2: Jogador vs CPU)");
			
			modoDeJogo = in.next();
			
			if(modoDeJogo.equals("1") || modoDeJogo.equals("2"))
				break;
			
		}
		
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
			selecao:
			while(true)
			{
				
				System.out.println("Escolha a posição do seu barco (ex: 11)");
				
				posicaoBarco[i] = in.next();
				
				if(posicaoBarco[i].length() > 2 || posicaoBarco[i].length() < 2)
					System.out.println("Posição inválida");
				else if(Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(0))) > 8 || Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(1))) > 8)
					System.out.println("Posição inválida");
				else if(direcaoBarco[i].equals("v") && Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(0))) > 8-tamanhoBarco[i])
					System.out.println("Posição inválida");
				else if(direcaoBarco[i].equals("h") && Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(1))) > 8-tamanhoBarco[i])
					System.out.println("Posição inválida");
				else
				{
					
					if(direcaoBarco[i].equals("v"))
					{
						
						for(int j = Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(0)))-1; j < Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(0)))+tamanhoBarco[i]; j++)
						{
							
							if(mapa[j][Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(1)))-1] != null)
							{
								
								System.out.println("Posição inválida");
								
								break;
								
							}
							else
								break selecao;
							
						}
						
					}
					else if(direcaoBarco[i].equals("h"))
					{
						
						for(int j = Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(1)))-1; j < Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(1)))+tamanhoBarco[i]; j++)
						{
							
							if(mapa[Integer.parseInt(String.valueOf(posicaoBarco[i].charAt(0)))-1][j] != null)
							{
								
								System.out.println("Posição inválida");
								
								break;
								
							}
							else
								break selecao;
							
						}
						
					}
					
				}
				
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
		
		if(modoDeJogo == "1")
		{
			
			String[][] mapaInimigo = new String[8][8];
			
			int[] tamanhoBarcoInimigo = new int[4];
			
			String[] direcaoBarcoInimigo = new String[4];
			
			String[] posicaoBarcoInimigo = new String[4];
			
			for(int i = 0; i < 4; i++)
			{
				
				while(true)
				{
					
					System.out.println("Escolha seu barco");
					System.out.println("Digite '1' para: jet ski (2 espaços)");
					System.out.println("Digite '2' para: canoa (3 espaços)");
					System.out.println("Digite '3' para: navio cargueiro (4 espaços)");
					System.out.println("Digite '4' para: porta avioes (5 espaços)");
					
					tamanhoBarcoInimigo[i] = in.nextInt();
					
					if(tamanhoBarcoInimigo[i] < 1 || tamanhoBarcoInimigo[i] > 4)
						System.out.println("Tamanho inválido");
					else
						break;
					
				}
				
				while(true)
				{
					
					System.out.println("Escolha a direção do seu barco (ex: v ou h)");
					
					direcaoBarcoInimigo[i] = in.next();
					
					if(!direcaoBarcoInimigo[i].equals("v") && !direcaoBarcoInimigo[i].equals("h"))
						System.out.println("Direção inválida");
					else
						break;
					
				}
				selecao:
				while(true)
				{
					
					System.out.println("Escolha a posição do seu barco (ex: 11)");
					
					posicaoBarcoInimigo[i] = in.next();
					
					if(posicaoBarcoInimigo[i].length() > 2 || posicaoBarcoInimigo[i].length() < 2)
						System.out.println("Posição inválida");
					else if(Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(0))) > 8 || Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(1))) > 8)
						System.out.println("Posição inválida");
					else if(direcaoBarcoInimigo[i].equals("v") && Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(0))) > 8-tamanhoBarcoInimigo[i])
						System.out.println("Posição inválida");
					else if(direcaoBarcoInimigo[i].equals("h") && Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(1))) > 8-tamanhoBarcoInimigo[i])
						System.out.println("Posição inválida");
					else
					{
						
						if(direcaoBarcoInimigo[i].equals("v"))
						{
							
							for(int j = Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(0)))-1; j < Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(0)))+tamanhoBarcoInimigo[i]; j++)
							{
								
								if(mapaInimigo[j][Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(1)))-1] != null)
								{
									
									System.out.println("Posição inválida");
									
									break;
									
								}
								else
									break selecao;
								
							}
							
						}
						else if(direcaoBarcoInimigo[i].equals("h"))
						{
							
							for(int j = Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(1)))-1; j < Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(1)))+tamanhoBarcoInimigo[i]; j++)
							{
								
								if(mapaInimigo[Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(0)))-1][j] != null)
								{
									
									System.out.println("Posição inválida");
									
									break;
									
								}
								else
									break selecao;
								
							}
							
						}
						
					}
					
				}
				
				if(direcaoBarcoInimigo[i].equals("v"))
				{
					
					for(int j = 0; j < tamanhoBarcoInimigo[i]+1; j++)
					{
						
						mapaInimigo[Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(0)))-1+j][Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(1)))-1] = "b";
						
					}
					
				}
				else if(direcaoBarcoInimigo[i].equals("h"))
				{
					
					for(int j = 0; j < tamanhoBarcoInimigo[i]+1; j++)
					{
						
						mapaInimigo[Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(0)))-1][Integer.parseInt(String.valueOf(posicaoBarcoInimigo[i].charAt(1)))-1+j] = "b";
						
					}
					
				}
				
				for(int j = 0; j < 8; j++)
				{
					
					for(int k = 0; k < 8; k++)
					{
						
						if(mapaInimigo[j][k] == null)
							System.out.print("~");
						else
							System.out.print(mapaInimigo[j][k]);
						
					}
					
					System.out.println();
					
				}
				
			}
			
			int contadorJogador = 0;
			
			int contadorInimigo = 0;
			
			jogadas:
			while(true)
			{
				
				while(true)
				{
					
					if(contadorJogador == 14)
					{
						
						System.out.println("Jogador 1 venceu!!");
						
						break jogadas;
						
					}
					
					System.out.println("Jogador 1, escolha a posição da sua bomba (ex: 11)");
					
					String posicaoBomba1;
					
					posicaoBomba1 = in.next();
					
					if(posicaoBomba1.length() > 2 || posicaoBomba1.length() < 2)
						System.out.println("Posição inválida");
					else if(Integer.parseInt(String.valueOf(posicaoBomba1.charAt(0))) > 8 || Integer.parseInt(String.valueOf(posicaoBomba1.charAt(1))) > 8)
						System.out.println("Posição inválida");
					else if(mapaInimigo[Integer.valueOf(String.valueOf(posicaoBomba1.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba1.charAt(1)))-1] == "b")
					{
						
						mapaInimigo[Integer.valueOf(String.valueOf(posicaoBomba1.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba1.charAt(1)))-1] = "X";
						
						contadorJogador++;
						
						for(int j = 0; j < 8; j++)
						{
							
							for(int k = 0; k < 8; k++)
							{
								
								if(mapaInimigo[j][k] == null || mapaInimigo[j][k] == "b")
									System.out.print("~");
								else
									System.out.print(mapaInimigo[j][k]);
								
							}
							
							System.out.println();
							
						}
						
					}
					else if(mapaInimigo[Integer.valueOf(String.valueOf(posicaoBomba1.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba1.charAt(1)))-1] == null)
					{
						
						mapaInimigo[Integer.valueOf(String.valueOf(posicaoBomba1.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba1.charAt(1)))-1] = "0";
						
						for(int j = 0; j < 8; j++)
						{
							
							for(int k = 0; k < 8; k++)
							{
								
								if(mapaInimigo[j][k] == null || mapaInimigo[j][k] == "b")
									System.out.print("~");
								else
									System.out.print(mapaInimigo[j][k]);
								
							}
							
							System.out.println();
							
						}
						
						break;
						
					}
					else if(mapaInimigo[Integer.valueOf(String.valueOf(posicaoBomba1.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba1.charAt(1)))-1] == "0")
					{
						
						System.out.println("Posição já escolhida!");
						
					}
					
				}
				while(true)
				{
					
					if(contadorInimigo == 14)
					{
						
						System.out.println("Jogador 2 venceu!!");
						
						break jogadas;
						
					}
					
					System.out.println("Jogador 2, escolha a posição da sua bomba (ex: 11)");
					
					String posicaoBomba2;
					
					posicaoBomba2 = in.next();
					
					if(posicaoBomba2.length() > 2 || posicaoBomba2.length() < 2)
						System.out.println("Posição inválida");
					else if(Integer.parseInt(String.valueOf(posicaoBomba2.charAt(0))) > 8 || Integer.parseInt(String.valueOf(posicaoBomba2.charAt(1))) > 8)
						System.out.println("Posição inválida");
					else if(mapa[Integer.valueOf(String.valueOf(posicaoBomba2.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba2.charAt(1)))-1] == "b")
					{
						
						mapa[Integer.valueOf(String.valueOf(posicaoBomba2.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba2.charAt(1)))-1] = "X";
						
						contadorInimigo++;
						
						for(int j = 0; j < 8; j++)
						{
							
							for(int k = 0; k < 8; k++)
							{
								
								if(mapa[j][k] == null || mapa[j][k] == "b")
									System.out.print("~");
								else
									System.out.print(mapa[j][k]);
								
							}
							
							System.out.println();
							
						}
						
					}
					else if(mapa[Integer.valueOf(String.valueOf(posicaoBomba2.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba2.charAt(1)))-1] == null)
					{
						
						mapa[Integer.valueOf(String.valueOf(posicaoBomba2.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba2.charAt(1)))-1] = "0";
						
						for(int j = 0; j < 8; j++)
						{
							
							for(int k = 0; k < 8; k++)
							{
								
								if(mapa[j][k] == null || mapa[j][k] == "b")
									System.out.print("~");
								else
									System.out.print(mapa[j][k]);
								
							}
							
							System.out.println();
							
						}
						
						break;
						
					}
					else if(mapa[Integer.valueOf(String.valueOf(posicaoBomba2.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba2.charAt(1)))-1] == "0")
					{
						
						System.out.println("Posição já escolhida!");
						
					}
					
				}
				
			}
			
		}
		else if(modoDeJogo.equals("2"))
		{
			
			String[][] mapaInimigo = new String[8][8];
			
			int[] tamanhoBarcoInimigo = new int[4];
			
			String[] direcaoBarcoInimigo = new String[4];
			
			for(int i = 0; i < 4; i++)
			{
				
				tamanhoBarcoInimigo[i] = i+1;
				
				int randDirecao = rand.nextInt(2);
				
				if(randDirecao == 0)
					direcaoBarcoInimigo[i] = "v";
				else if(randDirecao == 1)
					direcaoBarcoInimigo[i] = "h";
				
				while(true)
				{
					
					if(direcaoBarcoInimigo[i].equals("v"))
					{
						
						int randPosicaoY = rand.nextInt(8-tamanhoBarcoInimigo[i]);
						
						int randPosicaoX = rand.nextInt(8);
						
						int contador = 0;
						
						for(int j = 0; j < tamanhoBarcoInimigo[i]+1; j++)
						{
							
							if(mapaInimigo[randPosicaoY+j][randPosicaoX] != null)
								break;
							else
								contador++;
							
						}
						
						if(contador == tamanhoBarcoInimigo[i]+1)
						{
							
							for(int j = 0; j < tamanhoBarcoInimigo[i]+1; j++)
							{
								
								mapaInimigo[randPosicaoY+j][randPosicaoX] = "b";
								
							}
							
							break;
							
						}
						
					}
					else if(direcaoBarcoInimigo[i].equals("h"))
					{
						
						int randPosicaoY = rand.nextInt(8);
						
						int randPosicaoX = rand.nextInt(8-tamanhoBarcoInimigo[i]);
						
						int contador = 0;
						
						for(int j = 0; j < tamanhoBarcoInimigo[i]+1; j++)
						{
							
							if(mapaInimigo[randPosicaoY][randPosicaoX+j] != null)
								break;
							else
								contador++;
							
						}
						
						if(contador == tamanhoBarcoInimigo[i]+1)
						{
							
							for(int j = 0; j < tamanhoBarcoInimigo[i]+1; j++)
							{
								
								mapaInimigo[randPosicaoY][randPosicaoX+j] = "b";
								
							}
							
							break;
							
						}
						
					}
					
				}
				
			}
			
			int contadorJogador = 0;
			
			int contadorInimigo = 0;
			
			jogadas:
			while(true)
			{
				
				while(true)
				{
					
					if(contadorJogador == 14)
					{
						
						System.out.println("Jogador 1 venceu!!");
						
						break jogadas;
						
					}
					
					System.out.println("Jogador 1, escolha a posição da sua bomba (ex: 11)");
					
					String posicaoBomba1;
					
					posicaoBomba1 = in.next();
					
					if(posicaoBomba1.length() > 2 || posicaoBomba1.length() < 2)
						System.out.println("Posição inválida");
					else if(Integer.parseInt(String.valueOf(posicaoBomba1.charAt(0))) > 8 || Integer.parseInt(String.valueOf(posicaoBomba1.charAt(1))) > 8)
						System.out.println("Posição inválida");
					else if(mapaInimigo[Integer.valueOf(String.valueOf(posicaoBomba1.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba1.charAt(1)))-1] == "b")
					{
						
						mapaInimigo[Integer.valueOf(String.valueOf(posicaoBomba1.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba1.charAt(1)))-1] = "X";
						
						contadorJogador++;
						
						for(int j = 0; j < 8; j++)
						{
							
							for(int k = 0; k < 8; k++)
							{
								
								if(mapaInimigo[j][k] == null || mapaInimigo[j][k] == "b")
									System.out.print("~");
								else
									System.out.print(mapaInimigo[j][k]);
								
							}
							
							System.out.println();
							
						}
						
					}
					else if(mapaInimigo[Integer.valueOf(String.valueOf(posicaoBomba1.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba1.charAt(1)))-1] == null)
					{
						
						mapaInimigo[Integer.valueOf(String.valueOf(posicaoBomba1.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba1.charAt(1)))-1] = "0";
						
						for(int j = 0; j < 8; j++)
						{
							
							for(int k = 0; k < 8; k++)
							{
								
								if(mapaInimigo[j][k] == null || mapaInimigo[j][k] == "b")
									System.out.print("~");
								else
									System.out.print(mapaInimigo[j][k]);
								
							}
							
							System.out.println();
							
						}
						
						break;
						
					}
					else if(mapaInimigo[Integer.valueOf(String.valueOf(posicaoBomba1.charAt(0)))-1][Integer.valueOf(String.valueOf(posicaoBomba1.charAt(1)))-1] == "0")
					{
						
						System.out.println("Posição já escolhida!");
						
					}
					
				}
				
				int acertadosInimigo = 0;
				
				ArrayList<Integer> locaisPossiveisBombaY = new ArrayList<Integer>();
				
				ArrayList<Integer> locaisPossiveisBombaX = new ArrayList<Integer>();
				
				for(int i = 0; i < 8; i++)
					locaisPossiveisBombaY.add(i);
				for(int i = 0; i < 8; i++)
					locaisPossiveisBombaX.add(i);
				
				jogadaInimigo:
				while(true)
				{
					
					if(contadorJogador == 14)
					{
						
						System.out.println("Jogador 2 venceu!!");
						
						break jogadas;
						
					}
					
					int randPosBombaY = (int)locaisPossiveisBombaY.get(rand.nextInt(locaisPossiveisBombaY.size()));
					
					int randPosBombaX = (int)locaisPossiveisBombaX.get(rand.nextInt(locaisPossiveisBombaX.size()));
					
					int randAcao = 0;
					
					if(acertadosInimigo == 0)
					{
						
						while(true)
						{
							
							if(mapa[randPosBombaY][randPosBombaX].equals(null))
							{
								
								locaisPossiveisBombaY.remove(randPosBombaY);
								
								locaisPossiveisBombaX.remove(randPosBombaX);
								
								mapa[randPosBombaY][randPosBombaX] = "0";
								
								break jogadaInimigo;
								
							}
							else if(mapa[randPosBombaY][randPosBombaX].equals("b"))
							{
								
								locaisPossiveisBombaY.remove(randPosBombaY);
								
								locaisPossiveisBombaX.remove(randPosBombaX);
								
								acertadosInimigo++;
								
								contadorInimigo++;
								
								mapa[randPosBombaY][randPosBombaX] = "X";
								
							}
							
						}
						
					}
					else if(acertadosInimigo == 1)
					{
						
						ArrayList<Integer> lista = new ArrayList<Integer>();
						
						for(int i = 0; i < 4; i++)
						lista.add(i);
						
						while(true)
						{
							
							randAcao = (int)lista.get(rand.nextInt(lista.size()));
							
							lista.get(randAcao);
							
							if(randAcao == 0)
							{
								
								if(randPosBombaY+acertadosInimigo < 8)
								{
									
									if(mapa[randPosBombaY+acertadosInimigo][randPosBombaX] == "b")
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										mapa[randPosBombaY][randPosBombaX] = "X";
										
										lista.remove(randAcao);
										
									}
									else if(mapa[randPosBombaY+acertadosInimigo][randPosBombaX] == null)
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo = 0;
										
										mapa[randPosBombaY][randPosBombaX] = "0";
										
										break jogadaInimigo;
										
									}
									
								}
								else
									lista.remove(randAcao);
								
							}
							else if(randAcao == 1)
							{
								
								if(randPosBombaX+acertadosInimigo < 8)
								{
									
									if(mapa[randPosBombaY][randPosBombaX+acertadosInimigo] == "b")
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										mapa[randPosBombaY][randPosBombaX] = "X";
										
										lista.remove(randAcao);
										
									}
									else if(mapa[randPosBombaY+acertadosInimigo][randPosBombaX] == null)
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo = 0;
										
										mapa[randPosBombaY][randPosBombaX] = "0";
										
										break jogadaInimigo;
										
									}
									
								}
								else
									lista.remove(randAcao);
								
							}else if(randAcao == 2)
							{
								
								if(randPosBombaY-acertadosInimigo >= 0)
								{
									
									if(mapa[randPosBombaY-acertadosInimigo][randPosBombaX] == "b")
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY-acertadosInimigo);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										mapa[randPosBombaY][randPosBombaX] = "X";
										
										lista.remove(randAcao);
										
									}
									else if(mapa[randPosBombaY-acertadosInimigo][randPosBombaX] == null)
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY-acertadosInimigo);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo = 0;
										
										mapa[randPosBombaY-acertadosInimigo][randPosBombaX] = "0";
										
										break jogadaInimigo;
										
									}
									
								}
								else
									lista.remove(randAcao);
								
							}
							else if(randAcao == 3)
							{
								
								if(randPosBombaX-acertadosInimigo >= 0)
								{
									
									if(mapa[randPosBombaY][randPosBombaX-acertadosInimigo] == "b")
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										mapa[randPosBombaY][randPosBombaX] = "X";
										
										lista.remove(randAcao);
										
									}
									else if(mapa[randPosBombaY][randPosBombaX-acertadosInimigo] == null)
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo = 0;
										
										mapa[randPosBombaY][randPosBombaX] = "0";
										
										break jogadaInimigo;
										
									}
									
								}
								else
									lista.remove(randAcao);
								
							}
							
							if(lista.size() == 0)
							{
								
								acertadosInimigo = 0;
								
								break;
								
							}
							
						}
						
					}
					else if(acertadosInimigo > 1)
					{
						
						while(true)
						{
							
							if(randAcao == 0)
							{
								
								if(randPosBombaX+acertadosInimigo < 8)
								{
									
									if(mapa[randPosBombaY+acertadosInimigo][randPosBombaX] == "b")
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										mapa[randPosBombaY][randPosBombaX] = "X";
										
									}
									
								}
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
