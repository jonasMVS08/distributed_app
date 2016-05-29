/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonas
 */
@WebServlet(name = "ControllerServlet",loadOnStartup = 1, urlPatterns = {"/ControllerServlet","/cart","/update"})
public class ControllerServlet extends HttpServlet {

    //@EJB
    //ShoppingCartRemote shoppingCart;
     
    public static String itemId;
    public static String catId;
    public static int aantal = 0;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        
        if(userPath.equals("/cart")){
            userPath = "/cart";
        }
        String url = userPath + ".xhtml";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        
        String userPath = request.getServletPath();
        CartManager myManagedBean = (CartManager) getServletContext().getAttribute("cartManager");
        if (userPath.equals("/update")) {
            String productId = request.getParameter("productId");
            String quantity = request.getParameter("quantity");
            myManagedBean.setQuantity(Integer.parseInt(productId), Integer.parseInt(quantity));
            userPath = "/cart";
        }
        String url = userPath + ".xhtml";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
