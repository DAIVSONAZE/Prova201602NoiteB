package entidades;

import java.util.Date;

public class Aplicativo {
	
	private int id;
	private String tituloApp;
	private String descricao;
	private String autor;
	private int quantidadeDownloads;
	private float valor;
	private Date dataLiberacao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTituloApp() {
		return tituloApp;
	}
	public void setTituloApp(String tituloApp) {
		this.tituloApp = tituloApp;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getQuantidadeDownloads() {
		return quantidadeDownloads;
	}
	public void setQuantidadeDownloads(int quantidadeDownloads) {
		this.quantidadeDownloads = quantidadeDownloads;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Date getDataLiberacao() {
		return dataLiberacao;
	}
	public void setDataLiberacao(Date dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}
	
	
	

}
