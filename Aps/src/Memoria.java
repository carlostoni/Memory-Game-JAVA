import java.awt.GridLayout;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Memoria extends JFrame{

	private static final long serialVersionUID = 1L;

	int pontos = 100;


	public void play (String nomeDoAudio) {

		URL url = Memoria.class.getResource(nomeDoAudio+".wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();

	}


	Random posicaoRandomica = new Random();
	private int posicionamento[] = new int [16];
	private int vetorAleatorio[] = new int [16];
	private final Icon[] imgs = new Icon[8];

	private JToolBar menuSuperior = new JToolBar();
	private JButton novoJogo = new JButton("Novo Jogo");
	private JButton reiniciarJogo = new JButton("Reiniciar Jogo");
	
	private JPanel painel = new JPanel();
	private GridLayout layoutJogo = new GridLayout(4,4);
	
	protected JButton botao[] = new JButton[16];

	private JPanel rodape = new JPanel();
	private JLabel contagemPontos = new JLabel("Pontos: 100");


	public Memoria () {

	}


	public Icon[] getImgs() {
		return imgs;
	}




	public JToolBar getMenuSuperior() {
		return menuSuperior;
	}



	public void setMenuSuperior(JToolBar MenuSuperior) {
		MenuSuperior = menuSuperior;
	}



	public JButton getNovoJogo() {
		return novoJogo;
	}



	public void setNovoJogo(JButton NovoJogo) {
		NovoJogo = novoJogo;
	}



	public JButton getReiniciarJogo() {
		return reiniciarJogo;
	}



	public void setReiniciarJogo(JButton ReiniciarJogo) {
		ReiniciarJogo = reiniciarJogo;
	}


	public GridLayout getLayoutJogo() {
		return layoutJogo;
	}



	public void setLayoutJogo(GridLayout LayoutJogo) {
		LayoutJogo = layoutJogo;
	}



	public JPanel getPainel() {
		return painel;
	}



	public void setPanel(JPanel Painel) {
		Painel = painel;
	}


	public JButton[] getBotao() {
		return botao;
	}



	public void setEscolha(JButton Botao[]) {
		Botao = botao;
	}



	public JPanel getRodape() {
		return rodape;
	}



	public void setRodape(JPanel Rodape) {
		Rodape = rodape;
	}



	public JLabel getContagemPontos() {
		return contagemPontos;
	}



	public void setContagemPontosr(JLabel ContagemPontos) {
		ContagemPontos = contagemPontos;
	}




	public int[] getPosicionamento() {
		return posicionamento;
	}


	public void setPosicionamento(int posicionamento[]) {
		this.posicionamento = posicionamento;
	}


	public int[] getVetorAleatorio() {
		return vetorAleatorio;
	}


	public void setVetorAleatorio(int vetorAleatorio[]) {
		this.vetorAleatorio = vetorAleatorio;
	}

}