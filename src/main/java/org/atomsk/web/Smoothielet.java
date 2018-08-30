package org.atomsk.web;

import org.atomsk.service.Smoothie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TreeMap;

@WebServlet(name = "Smoothielet", urlPatterns = "/bmiforsmoothie")
public class Smoothielet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        double height = Double.parseDouble(request.getParameter("height"))*0.01;
        double weight = Double.parseDouble(request.getParameter("weight"));

        Smoothie obj = Smoothie.getInstance();




        TreeMap<String,String> smoothieMap = new TreeMap<String,String>();
        try {
            smoothieMap = (TreeMap<String, String>)obj.getProductSmoothie("table");
        } catch (Exception e) {
            e.printStackTrace();
        }


        double bmi = weight / (height * height);
        String num = String.format("%.1f", bmi);

        response.getWriter().print("<h1>BMI지수가 "+num+"인 당신에게 추천할만한 SmoothieKing메뉴</h1>");

        if(bmi>=0 && bmi<18.5)
        {
            for(int i=0; i<smoothieMap.size();i++)
                response.getWriter().print(smoothieMap.values().toArray()[i] + "\t");

        }
        else if(bmi>=18.5 && bmi<23)
        {
            for(int i=0; i<24 ;i++)
                response.getWriter().print(smoothieMap.values().toArray()[i] + "\t");
        }
        else if(bmi>=23 && bmi<25)
        {
            for(int i=0; i<15;i++)
                response.getWriter().print(smoothieMap.values().toArray()[i] + "\t");
        }
        else if(bmi>=25 && bmi<30)
        {
            for(int i=0; i<5;i++)
                response.getWriter().print(smoothieMap.values().toArray()[i] + "\t");
        }
        else if(bmi>=30)
        {

            response.getWriter().print("먹을수없슴다...");
        }








    }
}