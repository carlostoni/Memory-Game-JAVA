import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class TwoMemoria extends Memoria {


	private static final long serialVersionUID = 1L;


	public TwoMemoria() { 	

		super ();
	}

	public void inicializar () {

		getMenuSuperior().add(getNovoJogo()); 
		getMenuSuperior().add(getReiniciarJogo());
		add(getMenuSuperior(), BorderLayout.NORTH);

		for (int i=0; i<16; ++i){
			getBotao()[i] = new JButton();
			getPainel().add(getBotao()[i]);
			getBotao()[i].setFont(getFont());
			getBotao()[i].setVisible(true);
		}

		getPainel().setLayout(getLayoutJogo());
		add(getPainel(), BorderLayout.CENTER);

		getRodape().add(getContagemPontos());
		add(getRodape(), BorderLayout.SOUTH);


		acontecimentoJogo Handler = new acontecimentoJogo();
		for (int i=0; i<16; ++i){

			getBotao()[i].addActionListener(Handler);

		}

		getNovoJogo().addActionListener(Handler);
		getReiniciarJogo().addActionListener(Handler);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);     
		this.setSize(500,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

	public void imagem () {

		for(int i=0; i<getImgs().length; i++) {
			getImgs()[i] = new ImageIcon("imagens/"+i+".jpg");

		}
	}


	private class acontecimentoJogo implements ActionListener{
        
		
		int acerto,primeiroClique,segundoClique;
		int quantidadeClique, cont, posi;
		boolean novoJogo = true;
		boolean reiniciar = false;
		boolean fim = false;   {
			
			
		}


		public void actionPerformed(ActionEvent event){  
			
			
			
		    

			if (event.getSource() == getNovoJogo()){
				novoJogo = true;
				reiniciar = false;
			}

			if (event.getSource() == getReiniciarJogo()){
				novoJogo = true;
				reiniciar = true;
			}


			if (novoJogo == true){ 

				acerto = 0;
				pontos = 100;
				quantidadeClique = 0;
				posi = 0; cont = 16;
				primeiroClique = 0;
				segundoClique = 0;

				for (int i=0; i<16; ++i){
					getBotao()[i].setIcon(null);
					getBotao()[i].setEnabled(true);
				}

				if (reiniciar == false){

					for (int i=0; i<16; ++i){
						getVetorAleatorio()[i] = i;
					}

					for (int i=0; i<8; ++i){

						for (int j=0; j<2; ++j){
							posi = posicaoRandomica.nextInt(cont);
							getPosicionamento()[getVetorAleatorio()[posi]] = i;

							if (posi < cont){
								for (int q=(posi+1); q<(cont); ++q){
									getVetorAleatorio()[q-1] = getVetorAleatorio()[q];
								}
							} cont--;
						}
					}
				}

				novoJogo = false;
			}




			for (int i=0; i<16; ++i){

				if (event.getSource() == getBotao()[i]){

					getBotao()[i].setIcon(getImgs()[getPosicionamento()[i]]);
					getBotao()[i].setEnabled(true);
					getBotao()[i].setVisible(true);
					quantidadeClique++;

					if (quantidadeClique == 1) primeiroClique = i;
					if (quantidadeClique == 2){
						segundoClique = i;

						if  (getPosicionamento()[primeiroClique] != getPosicionamento()[segundoClique]){                                                       
							pontos-=2;
							play("Som De Bip");
							JOptionPane.showMessageDialog(TwoMemoria.this, "Errado");

							getBotao()[primeiroClique].setIcon(null);
							getBotao()[segundoClique].setIcon(null);
							getBotao()[primeiroClique].setEnabled(true);
							getBotao()[segundoClique].setEnabled(true);  


						}  else {
							play("Certo");
							acerto++;
							pontos+=10;
						}
						quantidadeClique = 0;
					}
				}
			}


			if (acerto == 8){

				acerto = 0;
				if (pontos >  pontos);
				fim = true;
			}


			if (pontos < 0) pontos = 0;
			getContagemPontos().setText("Pontos: " + pontos);


			if (fim == true){
				mensagem(pontos);
				fim = false;
			}           
		}
	}
	String nome = JOptionPane.showInputDialog("Qual o seu nome?");

	void mensagem(int pontos){

		JOptionPane.showMessageDialog(TwoMemoria.this, "Parabéns " + nome +  "\nSua pontuação é: "+ pontos);
	}
}