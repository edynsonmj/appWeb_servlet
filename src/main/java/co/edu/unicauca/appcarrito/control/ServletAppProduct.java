/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.edu.unicauca.appcarrito.control;

import co.edu.unicauca.appcarrito.persistence.jpa.ProductoJpaController;
import co.edu.unicauca.appcarrito.persistence.entities.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edyns
 */
@WebServlet("/")
public class ServletAppProduct extends HttpServlet {
    private ProductoJpaController productJPA;
    private final static String PU = "co.edu.unicauca_appCarrito_war_1.0-SNAPSHOTPU";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() throws ServletException{
        super.init();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        productJPA = new ProductoJpaController(emf);
        List<Producto> listaProductos = productJPA.findProductoEntities();
        /*for(Producto producto: listaProductos){
            System.out.println("nombre: "+producto.getNombre()+" codigo: "+producto.getCodigo()+"  precio: "+producto.getPrecio());
        }*/
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getServletPath();
        try{
            switch(action){
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    createProduct(request, response);
                    break;
                case "/delete":
                    deleteProduct(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateProduct(request, response);
                    break;
                default:
                    readProduct(request, response);
                    break;
            }
        }
        catch(Exception e){
            throw new ServletException(e);
        }
    }
    
    private void createProduct(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        
    }
    private void readProduct(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        List<Producto> listaProductos = productJPA.findProductoEntities();
        request.setAttribute("listProduct", listaProductos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-product.jsp");
        dispatcher.forward(request, response);
    }
    
    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
