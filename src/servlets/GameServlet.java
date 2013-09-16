package servlets;

import java.io.File;  
import java.io.IOException;  
import java.io.PrintWriter;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;  
import java.util.List;  
  








import javax.servlet.ServletConfig;  
import javax.servlet.ServletContext;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  








import model.beans.GameBean;

import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  

import controllers.GameController;


@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TEMP_PATH = "/capas";  
    private File tmpDir;  
    private static final String DESTINATION_DIR_PATH = "/capas";  
    private File destinationDir;
    
    public void init(ServletConfig config) throws ServletException {  
        super.init(config);  
        ServletContext sc = getServletContext();  
        tmpDir = new File(sc.getRealPath(TEMP_PATH));  
        if (!tmpDir.isDirectory()) {  
            throw new ServletException(TEMP_PATH + " is not a directory");  
        }  
        String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);  
        destinationDir = new File(realPath);  
        if (!destinationDir.isDirectory()) {  
            throw new ServletException(DESTINATION_DIR_PATH + " is not a directory");  
        }  
  
    } 
    
    protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter out = response.getWriter();  
    	
    	//Upload da imagem para o servidor
    	response.setContentType("text/html");  
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();  
        fileItemFactory.setSizeThreshold(1 * 1024 * 1024); //1 MB  
        fileItemFactory.setRepository(tmpDir);  
  
        ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);  
        try {  
            List items = uploadHandler.parseRequest(request);  
            Iterator itr = items.iterator();  
            while (itr.hasNext()) {  
                FileItem item = (FileItem) itr.next();  
                if (item.isFormField()) {  
                	System.out.println("Nome do campo = " + item.getFieldName() +  
                            ", Value = " + item.getString());  
                } else {  
                   out.println("Arquivo = " + item.getName() + "<br/>"  
                            + "Mime Type = " + item.getContentType() + "<br/>"  
                            + "Tamanho= " + item.getSize() / 1024 + " KB");  
                    File file = new File(destinationDir, item.getName());  
                    item.write(file);  
                    System.out.println("<br/>Arquivo gravado em: " + file.getPath());  
                }  
                out.close();  
            }  
        } catch (FileUploadException ex) {  
            ex.printStackTrace();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        } 
    	//
        
    	GameController controller = new GameController();
    	controller.request = request;
    	controller.response = response;
 
		String game_id = request.getParameter("game_id");
		String game_nome = request.getParameter("game_nome");
		String game_descricao = request.getParameter("game_descricao");
		String game_capa = request.getParameter("game_capa");
		
		//Convertendo data em String
    	String dataEmTexto = request.getParameter("game_data");
    	Calendar game_data = null;
    	try {
    		if (dataEmTexto != null){    			
    			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
    			game_data = Calendar.getInstance();
    			game_data.setTime(data);
    		}
    	} catch (ParseException e) {
    		System.out.println("Erro de conversão de data!");
    		return; //Para a execução do Metodo
    	}
    	//Fim da conversao
		
		String gen_id = request.getParameter("gen_id");
		String mid_id = request.getParameter("mid_id"); 
		String pla_id = request.getParameter("pla_id"); 
  	
		//Criação do objeto model
		GameBean bean = new GameBean();
				
		//If para verificar se é cadastro ou alteração
		if ((game_id.trim().length() != 0)){
		   bean.setGame_id(Integer.parseInt(game_id));
		}
								
		if(request.getParameter("acao") == null){
			bean.setGame_nome(game_nome);
			bean.setGame_descricao(game_descricao);
			bean.setGame_capa(game_capa);
			bean.setGame_data(game_data);
			bean.setGen_id(Integer.parseInt(gen_id));
			bean.setMid_id(Integer.parseInt(mid_id));
			bean.setPla_id(Integer.parseInt(pla_id));
			controller.save();
		}else
		{
			controller.delete();
		}
				
				
				response.sendRedirect(request.getContextPath() + "/views/?view=game/game-lista");
	}
    	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}

}
