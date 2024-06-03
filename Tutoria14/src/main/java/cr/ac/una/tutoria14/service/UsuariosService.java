package cr.ac.una.tutoria14.service;

import cr.ac.una.tutoria14.model.Usuario;
import cr.ac.una.tutoria14.model.UsuarioDto;
import cr.ac.una.tutoria14.util.EntityManagerHelper;
import cr.ac.una.tutoria14.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Luvara
 */
public class UsuariosService {

    EntityManager em = EntityManagerHelper.getManager();
    private EntityTransaction et;

    public Respuesta getUsuarios() {

        try {
            Query qryUsuario = em.createNamedQuery("Usuario.findAll", Usuario.class);

            List<UsuarioDto> usuarios = new ArrayList<>();
            List<Usuario> usuario = qryUsuario.getResultList();
            for (int i = 0; i < usuario.size(); i++) {
                usuarios.add(new UsuarioDto(usuario.get(i)));
            }
            return new Respuesta(true, "", "", "Usuarios", usuarios);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un usuario con las credenciales ingresadas.", "getEmpleados NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(UsuariosService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el usuario.", "getUsuario NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(UsuariosService.class.getName()).log(Level.SEVERE, "Error obteniendo informacion del empleado []", ex);
            return new Respuesta(false, "Error obteniendo el usuario.", "getEmpleados " + ex.getMessage());
        }

    }
}
