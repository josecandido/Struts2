package ejemplo15.cajaherramientas;

import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.servlet.ServletContext; 
import javax.servlet.ServletContextEvent; 
import javax.servlet.ServletContextListener; 
import javax.sql.DataSource;

public class ApplicationListener implements 
ServletContextListener{

       Context context=null;

       //funci�n llamada durante la creaci�n del iniciador 
       public void contextInitialized(ServletContextEvent servletContextEvent) 
       { 
              ServletContext servletContext=servletContextEvent.getServletContext(); 
              String dataSourceJNDI=servletContext.getInitParameter("dataSourceJNDI");

              try 
              { 
                      context=new InitialContext(); 
                      DataSource dataSource=(DataSource)context.lookup(dataSourceJNDI); 
                      if(dataSource==null) 
                      { 
                             System.out.println("No hay DataSource para el proyecto: ejemplo15"); 
                      } 
                      else 
                      { 
                              System.out.println("DataSource: �ejemplo15 cargado!"); 
                      } 
                      servletContext.setAttribute("dataSource", dataSource); 
               } 
               catch(NamingException e) 
               { 
                      throw new RuntimeException(); 
               } 
               finally 
               { 
                      try 
                      { 
                             //cerrar el contexto 
                             if(context!=null) 
                             { 
                                    context.close(); 
                             } 
                       } 
                       catch(Exception e) 
                       { 
                              System.out.println("�Error en initCtx!"); 
                       } 
              } 
       }

       //funci�n llamada durante la destrucci�n del iniciador 
       public void contextDestroyed(ServletContextEvent servletContextEvent) 
       { 
              try 
              { 
                       //cerrar el contexto 
                       if(context!=null) 
                       { 
                              context.close(); 
                       } 
              } 
              catch(Exception e) 
              { 
                     System.out.println("�Error en initCtx!"); 
              } 
       } 
}