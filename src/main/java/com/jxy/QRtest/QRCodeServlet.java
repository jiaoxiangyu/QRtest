package com.jxy.QRtest;


import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
   
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
   
import net.glxn.qrgen.QRCode;  
import net.glxn.qrgen.image.ImageType;  

@WebServlet("/QRCodeServlet")
public class QRCodeServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override  
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
   
        String qrtext = request.getParameter("qrtext");  
        System.out.println(qrtext);
        ByteArrayOutputStream out = QRCode.from(qrtext).to(  
                ImageType.PNG).stream();  
           
        response.setContentType("image/png");  
        response.setContentLength(out.size());  
           
        OutputStream outStream = response.getOutputStream();  
   
        outStream.write(out.toByteArray());  
   
        outStream.flush();  
        outStream.close();  
        System.out.println("结束");        
    }  
}  