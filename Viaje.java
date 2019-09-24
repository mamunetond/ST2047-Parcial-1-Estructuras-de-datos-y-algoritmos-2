import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Desarrollo Parcial 1 de la materia Estructura de Datos y Algoritmos 2
 * 
 * Objetivo: Desarrollar un programa que lea la lista de actividades y utilice un
 * algoritmo codicioso para determinar cuáles actividades debe realizar para
 * garantizar que desarrolla la mayor cantidad de actividades posibles. Si el número
 * de actividades es inferior a 10, a demás del algoritmo codicioso debe implementar
 * también un algoritmo de fuerza bruta para resolver el problema y comparar los 
 * resultados, una vez seleccionada una actividad, debe desarrollarla hasta que este
 * termine y que no puede desarrollar dos actividades simultáneamente
 * 
 * @author (Mario Alejandro Muñetón Durango - En colaboración con Juan Camilo Iguarán) 
 * @version (16 de Septiembre del 2019)
 * Asignatura: Estructura datos y algoritmos 2
 * Profesor: Juan Guillermo Lalinde Pulido
 * Universidad EAFIT
 * 2019
 */
public class Viaje extends Activity  // Hereda de la clase Activity
{

  public Viaje(int id, int inicio, int fin, String actividad) // Constructor de la clase Viaje
   {
        super(id,inicio,fin,actividad); // Hereda todos los atributos de la clase Activity
   }
   
  public static void LeerDatos(ArrayList<Activity> arrayActivities) // Método para pedir datos ak usuario, al igual que leer los datos
   {   int id = 0;  // usamos un identificador, que se va ir aumentando de uno en uno, cada vez que ingresemos una actividad
       Scanner entrada = new Scanner(System.in); // Creamos un Scanner llamado entrada
       System.out.println("Quiere ingresar actividades?"); // Le decimos al usuario "Quiere ingresar Actividades"
       String answer = entrada.nextLine(); // Guarda en un String el dato que ingreso el usuario
     
          while(answer.toLowerCase().equals("si"))  //mientras que el usuario digite si se va ejecutar lo que esta dentro del while, además no hay problema si el usuario ingresa mayúscualas
          {
             id++;
             System.out.println("Por favor ingrese la fecha de inicio de la actividad:");
             int inicio = entrada.nextInt();
             entrada.nextLine();
             System.out.println("Por favor ingrese la fecha fin de la actividad:");
             int fin = entrada.nextInt();
             entrada.nextLine();
             System.out.println("Por favor ingrese la  actividad que desea realizar:");
             String actividad = entrada.nextLine();
             Viaje al = new Viaje(id,inicio,fin,actividad);
             arrayActivities.add(al);
             System.out.println("¿Desea continuar ingresando actividades?");
             answer = entrada.nextLine();
          }
          
       System.out.println("fin de las actividades.");
       }  

  public static void Ordenar(ArrayList<Activity> arrayActivities, ArrayList<Activity> listaOrdenada) //Ordenas las actividades de menor a mayor, tienne como parametos dos arrayList, uno que se llama arrayActivities y otro listaOrdenada
  {
   
     for(int i = 0; i<arrayActivities.size(); i++)
     {
        for(int j = i+1; j<arrayActivities.size(); j ++)
        {
            if(arrayActivities.get(j).getFin()< arrayActivities.get(i).getFin())
            {
               Activity a2 = new Activity(arrayActivities.get(i).getId(), arrayActivities.get(i).getInicio(), arrayActivities.get(i).getFin(), arrayActivities.get(i).getActividad());
               listaOrdenada.add(a2);
               arrayActivities.set(i, arrayActivities.get(j));
               arrayActivities.set(j, listaOrdenada.get(0));
               listaOrdenada.remove(0);
            }
        }
     }
  }
  
  
  public static void codicioso(ArrayList<Activity> arrayActivities, ArrayList<Activity> listaOrdenada) // Este es el algoritmo Codicioso
  {
        
     for(int i = 0; i<arrayActivities.size(); i++)
     {
       for(int j = i+1; j<arrayActivities.size(); j ++)
       {
           if(arrayActivities.get(j).getFin()< arrayActivities.get(i).getFin())
           {
               Activity a1 = new Activity(arrayActivities.get(i).getId(), arrayActivities.get(i).getInicio(), arrayActivities.get(i).getFin(), arrayActivities.get(i).getActividad());
               listaOrdenada.add(a1);
               arrayActivities.set(i, arrayActivities.get(j));
               arrayActivities.set(j, listaOrdenada.get(0));
               listaOrdenada.remove(0);
           }
       }
    }
  
    
  
}

    
  public static void fuerzaBruta(ArrayList<Activity> listaOrdenada, ArrayList<Activity> arrayActivities) // Algoritmo de Fuerza Bruta
  {
     int count = 0;
     int mayor = 0;
     
        for(int i = 0; i<arrayActivities.size(); i++)
     {
        Activity a2 = new Activity(arrayActivities.get(i).getId(), arrayActivities.get(i-i).getInicio(), arrayActivities.get(i-i).getFin(), arrayActivities.get(i-i).getActividad());
        listaOrdenada.add(a2);
        arrayActivities.set(0, arrayActivities.get(i));
        arrayActivities.set(i, listaOrdenada.get(0));
        
            
        for(int j = 1; j<arrayActivities.size(); j++)
        {
           if((arrayActivities.get(j).getInicio() > arrayActivities.get(i-i).getInicio()) && (arrayActivities.get(j).getInicio() > arrayActivities.get(i-i).getFin()))
           {
               count++;
            }
        }
        
     
        if(count > mayor)
        {
          mayor = count;
        }
        listaOrdenada.remove(0);
    
     }
  }

  
  public static void imprimeArrayActivities(ArrayList<Activity> arrayActivities) // imprime la cantidad mayor de actividades que se pueden realizar
  {
    System.out.println("La lista de actividades que puede realizar son las siguientes:");
    
    for(int i = 1; i < arrayActivities.size(); i++)
    {
        System.out.println("Id:" +  " " +  arrayActivities.get(i). getId() + " " + "Fecha de inicio:" + " " +  arrayActivities.get(i).getInicio() + " " + "Fecha fin:" + " " +  arrayActivities.get(i).getFin() + "Actividad" + " " +  arrayActivities.get(i).getActividad());      
    }
  }
  

  public  static void main(String args[]) // En el main invocamos cada uno de los métodos
  {
      ArrayList<Activity> arrayActivities = new ArrayList<>(); // ArrayLkist para guardar las actividades que digiten los usuarios
      ArrayList <Activity> listaOrdenada = new ArrayList<>(); // ArrayList que almacena las actividades de menor a mayor
      LeerDatos(arrayActivities); // Lee los datos que digiten el usuario
      
      if(arrayActivities.size() < 10) // Si la cantidade de actividades es menor a 10 entonces se ejecuta el algoritmo de fuerza bruta
      {
       Ordenar(arrayActivities, listaOrdenada);
       fuerzaBruta(listaOrdenada, arrayActivities);
       System.out.println("Menos de 10 actividades");
       imprimeArrayActivities(arrayActivities);
      }else // De lo contrario se ejecuta el algoritmo Codicioso
      {
       Ordenar(arrayActivities, listaOrdenada);
       codicioso(arrayActivities, listaOrdenada);
       imprimeArrayActivities(arrayActivities);
  
      }

  }
  
}


