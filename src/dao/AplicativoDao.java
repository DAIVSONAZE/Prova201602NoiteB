package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Aplicativo;

import util.ConnectionFactory;

public class AplicativoDao {
	
	private Connection connection;

	public AplicativoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void inserir(Aplicativo aplicativos ) {

		String sql = "INSERT INTO aplica (tituloApp, descricao, autor, quantidadeDownloads, valor, dataLiberacao) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, aplicativos.getTituloApp());
			stmt.setString(2, aplicativos.getDescricao());
			stmt.setString(3, aplicativos.getAutor());
			stmt.setInt(4, aplicativos.getQuantidadeDownloads());
			stmt.setFloat(5, aplicativos.getValor());
			stmt.setDate(6, new java.sql.Date(aplicativos.getDataLiberacao().getTime()));

			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void remover(int id) {

		try {
			String sql = "DELETE FROM aplica WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Aplicativo> listar() {

		try {
			List<Aplicativo> listaAplicativo = new ArrayList<Aplicativo>();

			String sql = "SELECT * FROM aplica ORDER BY id";
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Aplicativo aplicativos = new Aplicativo();
				
				aplicativos.setId(rs.getInt("id"));
				aplicativos.setTituloApp(rs.getString("tituloApp"));
				aplicativos.setDescricao(rs.getString("descricao"));
				aplicativos.setAutor(rs.getString("autor"));
				aplicativos.setQuantidadeDownloads(rs.getInt("quantidadeDownloads"));
				aplicativos.setValor(rs.getFloat("valor"));
				aplicativos.setDataLiberacao(rs.getDate("dataLiberacao"));

				listaAplicativo.add(aplicativos);
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaAplicativo;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	

}
