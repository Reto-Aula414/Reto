import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC {
	public static void main(String [] args) {
	
		ArrayList<String> ac = new ArrayList<String>();
		ArrayList<String> cp = new ArrayList<String>();
		ArrayList<String> ed = new ArrayList<String>();
		ArrayList<String> biz = new ArrayList<String>();
		
	int contador = 0;
	int acdc = 0;
	int coldplay = 0;
	int edSheeran = 0;
	int bizarrap = 0;
	
		try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/eventos", "root", ""
        );
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from inscripciones");
        while (resultSet.next()) {
            
        	System.out.println("Nombre: " + resultSet.getString(1) + " \nApellidos: " + resultSet.getString(2) );
            System.out.println("Email: " + resultSet.getString(3));
            System.out.println("Ciudad: " + resultSet.getString(4));
            System.out.println("Evento: " + resultSet.getString(5));
            System.out.println("Fecha y Hora: " + resultSet.getString(6));
            System.out.println("\n");
            contador++;
            if(resultSet.getString(5).equals("AC/DC")) {
            	ac.add(resultSet.getString(1) + " " + resultSet.getString(2));
            	acdc++;
            	
            }
            if(resultSet.getString(5).equals("Coldplay")) {
            	cp.add(resultSet.getString(1) + " " + resultSet.getString(2));
            	coldplay++;
            }
            if(resultSet.getString(5).equals("Ed Sheeran")) {
            	ed.add(resultSet.getString(1) + " " + resultSet.getString(2));
            	edSheeran++;
            }
            if(resultSet.getString(5).equals("Bizarrap")) {
            	biz.add(resultSet.getString(1) + " " + resultSet.getString(2));
            	bizarrap++;
            }
            
           

        }
        connection.close();
    } catch (Exception e) {
        System.out.println(e);
    	}
		
		
		System.out.println("La cantidad de personas suscritas a todos los eventos es de: " + contador);
		System.out.println("\nLa cantidad de personas suscritas al evento de AC/DC es de:  " + acdc);
		System.out.println("\nLa cantidad de personas suscritas al evento de Coldplay es de: " + coldplay);
		System.out.println("\nLa cantidad de personas suscritas al evento de Ed Sheeran es de:" + edSheeran);
		System.out.println("\nLa cantidad de personas suscritas al evento de Bizarrap es de: " + bizarrap);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\nEl listado de personas suscritas a AC/DC es: " + ac);
		System.out.println("\nEl listado de personas suscritas a Coldplay es: " + cp);
		System.out.println("\nEl listado de personas suscritas a Ed Sheeran es: " + ed);
		System.out.println("\nEl listado de personas suscritas a Bizarrap es: " + biz);
	
	}
}

