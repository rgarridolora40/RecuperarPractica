package es.studium.buscarejercicio9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class buscarejercicio9
{
	public static void main(String[] args)
	{
		// Creamos objeto entrada, enlazado al teclado
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String fichero = "";
		String lineaFichero = "";
		String contenidoFichero = "";
		String cadenaBuscada = "";
		try
		{
			// Preguntamos al usuario por el nombre del fichero
			System.out.println("Indicar el nombre del fichero:");
			fichero = entrada.readLine();
			// Origen de los datos
			FileReader fr = new FileReader(fichero);
			// Buffer de lectura
			BufferedReader origen = new BufferedReader(fr);
			// Sacamos el contenido del fichero y lo guardamos en la variable contenido
			while((lineaFichero=origen.readLine())!=null)
			{
				contenidoFichero += lineaFichero;
			}
			// Preguntar por la palabra a buscar
			System.out.println("Indicar la palabra a buscar en el fichero:");
			cadenaBuscada = entrada.readLine();
			// Buscar la palabra en el contenido del fichero
			int encontrado = contenidoFichero.indexOf(cadenaBuscada);
			if(encontrado!=-1)
			{
				System.out.println("La palabra '" + cadenaBuscada + "' esta en el fichero " + fichero + " en la posicion "+encontrado);
			}
			else
			{
				System.out.println("La palabra '" + cadenaBuscada + "' NO esta en el fichero " + fichero);
			}
			//Cerrar los objetos
			entrada.close();
			origen.close();
			fr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Archivo NO encontrado");
		}
		catch(IOException i)
		{
			System.out.println("Se produjo un error de Archivo:"+i.getMessage());
		}
	}
}