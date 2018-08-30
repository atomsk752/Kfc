package org.atomsk.web;

import org.atomsk.service.Kfc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TreeMap;

@WebServlet(name = "BmiServlet", urlPatterns = "/bmiforkfc")
public class BmiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        double height = Double.parseDouble(request.getParameter("height"))*0.01;
        double weight = Double.parseDouble(request.getParameter("weight"));

        Kfc obj = Kfc.getInstance();

        TreeMap<String,String> key = new TreeMap<String,String>();
        key= (TreeMap<String, String>) obj.getProductById("begrBox");

        double bmi = weight / (height * height);
        String num = String.format("%.1f", bmi);

        // response.getWriter().print(key.values().toArray()[0]);
        response.getWriter().print("<h1>BMI지수가 "+num+"인 당신에게 추천할만한 KFC메뉴</h1>");
        if(bmi>=0 && bmi<18.5)
        {
            for(int i=0; i<key.size();i++)
                response.getWriter().print(key.values().toArray()[i] + "\t");

        }
        else if(bmi>=18.5 && bmi<23)
        {
            for(int i=0; i<8 ;i++)
                response.getWriter().print(key.values().toArray()[i] + "\t");
        }
        else if(bmi>=23 && bmi<25)
        {
            for(int i=0; i<4;i++)
                response.getWriter().print(key.values().toArray()[i] + "\t");
        }
        else if(bmi>=25 && bmi<30)
        {
            for(int i=0; i<1;i++)
                response.getWriter().print(key.values().toArray()[i] + "\t");
        }
        else if(bmi>=30)
        {

            response.getWriter().print("먹을수없슴다...");
        }








    }
}