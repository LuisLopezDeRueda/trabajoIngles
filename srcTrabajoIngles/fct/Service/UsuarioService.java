package fct.Service;

import java.sql.Connection;
import java.sql.SQLException;

import fct.Dao.UsuarioDao;
import fct.Modelo.Usuario;

public class UsuarioService {

	public Usuario iniciarSesion(String usuario, String password) throws UsuarioException {

		Connection conn = null;
		UsuarioDao csu = new UsuarioDao();

		try {
			conn = new OpenConnectionceufct().getConection();
			Usuario user = new Usuario();
			user = csu.consultarUsuario(conn, usuario);
			if (user != null && user.getPassword().equals(password)) {
				return user;
			} else {
				throw new UsuarioException();
			}
		} catch (SQLException e) {
			System.out.println("Problema con comprobar usuario " + e);
		}
		return null;

	}

	public void registrarUsuario(Usuario usuario) throws UsuarioException {

		Connection conn = null;
		UsuarioDao csu = new UsuarioDao();

		try {
			conn = new OpenConnectionceufct().getConection();
			Usuario user = csu.consultarUsuario(conn, usuario.getEmail());
			if (user == null) {

			} else {
				throw new UsuarioException();
			}
		} catch (SQLException e) {
			System.out.println("Problema con registrar usuario " + e);
		}

	}

}
