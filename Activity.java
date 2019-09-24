
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
public class Activity 
{
    private int id; // identificador
    private int inicio; // Fecha inicio
    private int fin; // Fecha final
    private String actividad; // Actividad
   
    
    public Activity(int id, int inicio, int fin, String actividad) // Constructor de la clase Activity
    {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.actividad = actividad;
    }
    
    
    /*
     * Getter del identificador
     * 
     */
    public int getId()
    {
        return id;
    }
    
     /*
     * Setter del identificador
     * 
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
     /*
     * Getter de la fecha de Inicio
     * 
     */
     public int getInicio()
    {
        return inicio;
    }
    
     /*
     * Setter de la fecha de inicio
     * 
     */
    public void setInicio(int inicio)
    {
        this.inicio = inicio;
    }
    
     /*
     * Getter de la fecha fin
     * 
     */
     public int getFin()
    {
        return fin;
    }
    
     /*
     * Setter de la fecha fin
     * 
     */
    public void setFin(int fin)
    {
        this.fin = fin;
    }
    
     /*
     * Getter de la actividad
     * 
     */
     public String getActividad()
    {
        return actividad;
    }
    
     /*
     * Setter de la actividad
     * 
     */
    public void setActividad(String actividad)
    {
        this.actividad = actividad;
    }
    

}
