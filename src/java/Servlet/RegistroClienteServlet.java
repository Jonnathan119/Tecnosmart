
package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistroCliente")
public class RegistroClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<html><body><h2>Formulario de Registro de Cliente</h2>"
                + "<form action='RegistroCliente' method='post'>"
                + "Número de Cédula: <input type='text' name='numero_cedula'><br>"
                + "Fecha de Expedición de la Cédula: <input type='date' name='fecha_expedicion_cedula'><br>"
                + "Nombre Completo: <input type='text' name='nombre'><br>"
                + "Teléfono: <input type='text' name='telefono'><br>"
                + "Dirección: <input type='text' name='direccion'><br>"
                + "Correo Electrónico: <input type='email' name='correo_electronico'><br>"
                + "<input type='submit' value='Registrar'>"
                + "</form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String numero_cedula = request.getParameter("numero_cedula");
        String fecha_expedicion_cedula = request.getParameter("fecha_expedicion_cedula");
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String correo_electronico = request.getParameter("correo_electronico");

        
        String usuario = "root";
        String password = ".Betancur25121.";
        String url = "jdbc:mysql://localhost:3306/tecnosmart_salespro?serverTimezone=UTC";

        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);

            // Insertar datos en la base de datos.
            String sql = "INSERT INTO CLIENTES (NUMERO_CEDULA,FECHA_EXPEDICION_CEDULA, NOMBRE, TELEFONO, DIRECCION, CORREO_ELECTRONICO) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, numero_cedula);
            pstmt.setDate(2, java.sql.Date.valueOf(fecha_expedicion_cedula));
            pstmt.setString(3, nombre);
            pstmt.setString(4, telefono);
            pstmt.setString(5,direccion);
            pstmt.setString(6,correo_electronico);
            pstmt.executeUpdate();

            response.getWriter().println("Cliente registrado exitosamente!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al registrar el cliente: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
