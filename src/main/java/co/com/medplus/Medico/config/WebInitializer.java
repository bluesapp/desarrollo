package co.com.medplus.Medico.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
	// Se crea un contexto basado en anotaciones
        AnnotationConfigWebApplicationContext annConWebAppCtx = new AnnotationConfigWebApplicationContext();

        // Se configura el paquete de los ficheros de configuración. En el
        // propio paquete!!!
        annConWebAppCtx.setConfigLocation(this.getClass().getPackage().getName());

        // Se configura el contexto utilizado en Securiry
        annConWebAppCtx.setServletContext(servletContext);
        
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(annConWebAppCtx);

        servletContext.addListener(contextLoaderListener);
        
        servletContext.addFilter("authorizationFilter", new DelegatingFilterProxy("authorizationFilter")).addMappingForUrlPatterns(null, false, "/*");        

        // Se configura el servlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(annConWebAppCtx));

        // 1 es True
        servlet.setLoadOnStartup(1);

        
		
	}

}
