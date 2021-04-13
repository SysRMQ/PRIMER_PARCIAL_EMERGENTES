
package com.emergentes.controller;

import com.emergentes.modelo.GestorPacientes;
import com.emergentes.modelo.Pacientes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pacientes objPaciente = new Pacientes();
        int id;
        int pos;
        String op = request.getParameter("op");
        
        if (op.equals("nuevo")){
            HttpSession ses = request.getSession();
            GestorPacientes vacunas = (GestorPacientes) ses.getAttribute("vacunas");
            objPaciente.setId(vacunas.ObtieneId());
            request.setAttribute("op", op);
            request.setAttribute("miPaciente", objPaciente);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if (op.equals("editar")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorPacientes vacunas = (GestorPacientes) ses.getAttribute("vacunas");
            pos = vacunas.ubicarPaciente(id);
            objPaciente = vacunas.getLista().get(pos);
            request.setAttribute("op", op);
            request.setAttribute("miPaciente", objPaciente);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("eliminar")){
           id = Integer.parseInt(request.getParameter("id"));
           HttpSession ses = request.getSession();
           GestorPacientes vacunas = (GestorPacientes) ses.getAttribute("vacunas");
           pos = vacunas.ubicarPaciente(id); 
           vacunas.eliminarPaciente(pos);
           ses.setAttribute("vacunas", vacunas);
           response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pacientes objPaciente = new Pacientes();
        int pos;
        String op = request.getParameter("op");
        
        if(op.equals("grabar")){
            objPaciente.setId(Integer.parseInt(request.getParameter("id")));
            objPaciente.setNombre(request.getParameter("nombre"));
            objPaciente.setPeso(Integer.parseInt(request.getParameter("peso")));
            objPaciente.setTalla(Double.parseDouble(request.getParameter("talla")));
            objPaciente.setVacuna(request.getParameter("vacuna"));
            
            HttpSession ses = request.getSession();
            GestorPacientes vacunas = (GestorPacientes) ses.getAttribute("vacunas");
            
            String opg = request.getParameter("opg");
            if(opg.equals("nuevo")){
                vacunas.insertarPaciente(objPaciente);
            }
            else{
                pos = vacunas.ubicarPaciente(objPaciente.getId());
                vacunas.modificarPaciente(pos, objPaciente);
            }
            
            ses.setAttribute("vacunas", vacunas);
            response.sendRedirect("index.jsp");
        }
    }

}
