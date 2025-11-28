package batalhanaval_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Application{
	
	static Scanner globalIn = new Scanner(System.in);
	
	static int escolherBarco() {
		System.out.println("Escolha seu barco");
		System.out.println("Digite '1' para: jet ski (2 espaços)");
		System.out.println("Digite '2' para: canoa (3 espaços)");
		System.out.println("Digite '3' para: navio cargueiro (4 espaços)");
		System.out.println("Digite '4' para: porta avioes (5 espaços)");
		
		int tamanhoBarco = globalIn.nextInt();
		
		return tamanhoBarco;
	}
	
	static boolean verificarOpcao(int opcao) {
		if(opcao < 1 || opcao > 5) {
			System.out.println("Tamanho inválido");
			return false;
		}
		
		return true;
		
	}
	
	static String escolherDirecao()
	{
		
		System.out.println("Escolha a direção do seu barco (ex: v ou h)");
		
		String direcaoBarco = globalIn.next();
		
		return direcaoBarco;
		
	}
	
	static boolean verificarDirecao(String direcao)
	{
		
		if(!direcao.equals("h") && !direcao.equals("v"))
		{
			
			System.out.println("Direção inválido");
			
			return false;
			
		}
		
		return true;
		
	}
	
	static boolean verificarPosDesajadaEhValida(String[][] mapa, int tamanhoBarco, String posBarco, String dirBarco) {
		if(dirBarco == "v")
		{
			
			for(int j = Integer.parseInt(String.valueOf(posBarco.charAt(0)))-1; j < Integer.parseInt(String.valueOf(posBarco.charAt(0)))+tamanhoBarco-1; j++)
			{

				if(mapa[j][Integer.parseInt(String.valueOf(posBarco.charAt(1)))-1] != null)
				{
					
					System.out.println("Posição inválida");
					
					return false;
					
				}
				
			}


			return true;
			
		}
		else
		{
			
			for(int j = Integer.parseInt(String.valueOf(posBarco.charAt(1)))-1; j < Integer.parseInt(String.valueOf(posBarco.charAt(1)))+tamanhoBarco-1; j++)
			{

				if(mapa[Integer.parseInt(String.valueOf(posBarco.charAt(0)))-1][j] != null)
				{
					
					System.out.println("Posição inválida");
					
					return false;
					
				}
				
			}


			return true;
			
		}

	}
	
	void printarTabuleiro() {
		
	}
	
	void setarBarco () {
		
	}
	
	boolean verificarPosicao() {
		return true;
	}

	public static void main(String[] args) 
	{	
		Scanner in = new Scanner(System.in);
		
		String modoDeJogo;
		
		String[][] mapa = new String[8][8];
		
		int tamanhoBarco = 0;
		
		String direcaoBarco = "";
		
		String posicaoBarco;
		
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
				
				tamanhoBarco = escolherBarco()+1;
				
				if(verificarOpcao(tamanhoBarco))
					break;
				
			}
			
			while(true)
			{
				
				direcaoBarco = escolherDirecao();
				
				if(verificarDirecao(direcaoBarco))
					break;
				
			}
			selecao:
			while(true)
			{
				
				System.out.println("Escolha a posição do seu barco (ex: 11)");
				
				posicaoBarco = in.next();
				
				if(posicaoBarco.length() != 2)
					System.out.println("Posição inválida");
				else if(Integer.parseInt(String.valueOf(posicaoBarco.charAt(0))) > 8 || Integer.parseInt(String.valueOf(posicaoBarco.charAt(1))) > 8)
					System.out.println("Posição inválida");
				else if(direcaoBarco.equals("v") && Integer.parseInt(String.valueOf(posicaoBarco.charAt(0))) > 8-tamanhoBarco+1)
					System.out.println("Posição inválida");
				else if(direcaoBarco.equals("h") && Integer.parseInt(String.valueOf(posicaoBarco.charAt(1))) > 8-tamanhoBarco+1)
					System.out.println("Posição inválida");
				else
					if (verificarPosDesajadaEhValida(mapa, tamanhoBarco, posicaoBarco, direcaoBarco))
						break selecao;
				
			}
			
			if(direcaoBarco.equals("v"))
			{
				
				for(int j = 0; j < tamanhoBarco; j++)
				{
					
					mapa[Integer.parseInt(String.valueOf(posicaoBarco.charAt(0)))-1+j][Integer.parseInt(String.valueOf(posicaoBarco.charAt(1)))-1] = "b";
					
				}
				
			}
			else if(direcaoBarco.equals("h"))
			{
				
				for(int j = 0; j < tamanhoBarco; j++)
				{
					
					mapa[Integer.parseInt(String.valueOf(posicaoBarco.charAt(0)))-1][Integer.parseInt(String.valueOf(posicaoBarco.charAt(1)))-1+j] = "b";
					
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
		
		if(modoDeJogo.equals("1"))
		{
			
			String[][] mapaInimigo = new String[8][8];
			
			for(int i = 0; i < 4; i++)
			{
				
				while(true)
				{
					
					tamanhoBarco = escolherBarco()+1;
					
					if(verificarOpcao(tamanhoBarco) == false)
						System.out.println("Tamanho inválido");
					else
						break;
					
				}
				
				while(true)
				{
					
					System.out.println("Escolha a direção do seu barco (ex: v ou h)");
					
					direcaoBarco = in.next();
					
					if(!direcaoBarco.equals("v") && !direcaoBarco.equals("h"))
						System.out.println("Direção inválida");
					else
						break;
					
				}
				selecao:
				while(true)
				{
					
					System.out.println("Escolha a posição do seu barco (ex: 11)");
					
					posicaoBarco = in.next();
					
					if(posicaoBarco.length() > 2 || posicaoBarco.length() < 2)
						System.out.println("Posição inválida");
					else if(Integer.parseInt(String.valueOf(posicaoBarco.charAt(0))) > 8 || Integer.parseInt(String.valueOf(posicaoBarco.charAt(1))) > 8)
						System.out.println("Posição inválida");
					else if(direcaoBarco.equals("v") && Integer.parseInt(String.valueOf(posicaoBarco.charAt(0))) > 8-tamanhoBarco+1)
						System.out.println("Posição inválida");
					else if(direcaoBarco.equals("h") && Integer.parseInt(String.valueOf(posicaoBarco.charAt(1))) > 8-tamanhoBarco+1)
						System.out.println("Posição inválida");
					else
					{
						
						if (verificarPosDesajadaEhValida(mapaInimigo, tamanhoBarco, posicaoBarco, direcaoBarco))
							break selecao;
						
					}
					
				}
				
				if(direcaoBarco.equals("v"))
				{
					
					for(int j = 0; j < tamanhoBarco+1; j++)
					{
						
						mapaInimigo[Integer.parseInt(String.valueOf(posicaoBarco.charAt(0)))-1+j][Integer.parseInt(String.valueOf(posicaoBarco.charAt(1)))-1] = "b";
						
					}
					
				}
				else if(direcaoBarco.equals("h"))
				{
					
					for(int j = 0; j < tamanhoBarco+1; j++)
					{
						
						mapaInimigo[Integer.parseInt(String.valueOf(posicaoBarco.charAt(0)))-1][Integer.parseInt(String.valueOf(posicaoBarco.charAt(1)))-1] = "b";
						
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
					
					System.out.println("Passou 0");
					
					if(contadorInimigo == 14)
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
							
							if(mapa[randPosBombaY][randPosBombaX] == null)
							{
								
								System.out.println("Passou 1");
								
								locaisPossiveisBombaY.remove(randPosBombaY);
								
								locaisPossiveisBombaX.remove(randPosBombaX);
								
								mapa[randPosBombaY][randPosBombaX] = "0";
								
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
								
								break jogadaInimigo;
								
							}
							else if(mapa[randPosBombaY][randPosBombaX].equals("b"))
							{
								
								System.out.println("Passou 1");
								
								locaisPossiveisBombaY.remove(randPosBombaY);
								
								locaisPossiveisBombaX.remove(randPosBombaX);
								
								acertadosInimigo++;
								
								contadorInimigo++;
								
								mapa[randPosBombaY][randPosBombaX] = "X";
								
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
							
							System.out.println(randAcao + " " + lista.size());
							
							lista.get(randAcao);
							
							if(randAcao == 0)
							{
								
								if(randPosBombaY+acertadosInimigo < 8)
								{
									
									if(mapa[randPosBombaY+acertadosInimigo][randPosBombaX] == null)
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY+acertadosInimigo);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										mapa[randPosBombaY+acertadosInimigo][randPosBombaX] = "0";
										
										acertadosInimigo = 0;
										
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
										
										break jogadaInimigo;
										
									}
									else if(mapa[randPosBombaY+acertadosInimigo][randPosBombaX].equals("b"))
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY+acertadosInimigo);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										mapa[randPosBombaY+acertadosInimigo][randPosBombaX] = "X";
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										lista.remove(randAcao);
										
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
										
									}else
										lista.remove(randAcao);
									
								}
								else
									lista.remove(randAcao);
								
							}
							else if(randAcao == 1)
							{
								
								if(randPosBombaX+acertadosInimigo < 8)
								{
									
									if(mapa[randPosBombaY][randPosBombaX+acertadosInimigo] == null)
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX+acertadosInimigo);
										
										mapa[randPosBombaY][randPosBombaX+acertadosInimigo] = "0";
										
										acertadosInimigo = 0;
										
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
										
										break jogadaInimigo;
										
									}
									else if(mapa[randPosBombaY+acertadosInimigo][randPosBombaX].equals("b"))
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX+acertadosInimigo);
										
										mapa[randPosBombaY][randPosBombaX+acertadosInimigo] = "X";
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										lista.remove(randAcao);
										
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
										
									}else
										lista.remove(randAcao);
									
								}
								else
									lista.remove(randAcao);
								
							}else if(randAcao == 2)
							{
								
								if(randPosBombaY-acertadosInimigo >= 0)
								{
									
									if(mapa[randPosBombaY-acertadosInimigo][randPosBombaX] == null)
									{
										
										
										
										locaisPossiveisBombaY.remove(randPosBombaY-acertadosInimigo);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										mapa[randPosBombaY-acertadosInimigo][randPosBombaX] = "0";
										
										acertadosInimigo = 0;
										
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
										
										break jogadaInimigo;
										
									}
									else if(mapa[randPosBombaY-acertadosInimigo][randPosBombaX].equals("b"))
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY-acertadosInimigo);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										mapa[randPosBombaY-acertadosInimigo][randPosBombaX] = "X";
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										lista.remove(randAcao);
										
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
										
										System.out.println("Passou");
										
										break;
										
									}else
										lista.remove(randAcao);
									
								}
								else
									lista.remove(randAcao);
								
							}
							else if(randAcao == 3)
							{
								
								if(randPosBombaX-acertadosInimigo >= 0)
								{
									
									if(mapa[randPosBombaY][randPosBombaX-acertadosInimigo] == null)
									{
										
										
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX-acertadosInimigo);
										
										mapa[randPosBombaY][randPosBombaX-acertadosInimigo] = "0";
										
										acertadosInimigo = 0;
										
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
										
										break jogadaInimigo;
										
									}
									else if(mapa[randPosBombaY][randPosBombaX-acertadosInimigo].equals("b"))
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX-acertadosInimigo);
										
										mapa[randPosBombaY][randPosBombaX-acertadosInimigo] = "X";
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										lista.remove(randAcao);
										
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
									else
										lista.remove(randAcao);
									
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
								
								if(randPosBombaY+acertadosInimigo < 8)
								{
									
									if(mapa[randPosBombaY+acertadosInimigo][randPosBombaX].equals(null))
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo = 0;
										
										mapa[randPosBombaY][randPosBombaX] = "0";
										
										break jogadaInimigo;
										
									}
									else if(mapa[randPosBombaY+acertadosInimigo][randPosBombaX] == "b")
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										mapa[randPosBombaY][randPosBombaX] = "X";
										
										break;
										
									}
									
								}
								
							}else if(randAcao == 1)
							{
								
								if(randPosBombaX+acertadosInimigo < 8)
								{
									
									if(mapa[randPosBombaY+acertadosInimigo][randPosBombaX].equals(null))
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo = 0;
										
										mapa[randPosBombaY][randPosBombaX] = "0";
										
										break jogadaInimigo;
										
									}
									else if(mapa[randPosBombaX+acertadosInimigo][randPosBombaX] == "b")
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										mapa[randPosBombaY][randPosBombaX] = "X";
										
									}
									
								}
								
							}else if(randAcao == 2)
							{
								
								if(randPosBombaY-acertadosInimigo >= 0)
								{
									
									if(mapa[randPosBombaY-acertadosInimigo][randPosBombaX].equals(null))
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo = 0;
										
										mapa[randPosBombaY][randPosBombaX] = "0";
										
										break jogadaInimigo;
										
									}
									else if(mapa[randPosBombaY-acertadosInimigo][randPosBombaX] == "b")
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo++;
										
										contadorInimigo++;
										
										mapa[randPosBombaY][randPosBombaX] = "X";
										
									}
									
								}
								
							}else if(randAcao == 3)
							{
								
								if(randPosBombaX-acertadosInimigo >= 0)
								{
									
									if(mapa[randPosBombaX-acertadosInimigo][randPosBombaX].equals(null))
									{
										
										locaisPossiveisBombaY.remove(randPosBombaY);
										
										locaisPossiveisBombaX.remove(randPosBombaX);
										
										acertadosInimigo = 0;
										
										mapa[randPosBombaY][randPosBombaX] = "0";
										
										break jogadaInimigo;
										
									}
									else if(mapa[randPosBombaX-acertadosInimigo][randPosBombaX] == "b")
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
