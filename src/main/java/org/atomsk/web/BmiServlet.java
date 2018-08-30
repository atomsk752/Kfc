package org.atomsk.web;

import org.atomsk.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BmiServlet", urlPatterns = "/bmi")
public class BmiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double height= Double.parseDouble(request.getParameter("height"));
        double weight= Double.parseDouble(request.getParameter("weight"));
        double bmi = weight / (Math.pow(height, 2));
        response.getWriter().print("<h1>"+bmi+"</h1>");

        ProductService obj = ProductService.getInstance();

        Map<String, String> map = new HashMap<>();
        map = obj.getProductById("begrBox");

        if (bmi>=0 && bmi<18.5)
        {
            response.getWriter().print("<h1>"+map.get("572")+"</h1>");
        }


    }
}
