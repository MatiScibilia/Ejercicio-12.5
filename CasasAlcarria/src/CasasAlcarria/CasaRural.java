package CasasAlcarria;
import java.util.Scanner;

public class CasaRural {
    private String codigo;
    private String poblacion;
    private String direccion;
    private int numHabitacion = 0;
    private double precio = 0.0;
    boolean esAlta;

    public CasaRural() {
        esAlta = true;
        asigna();
    }

    // para asignar los valores de la casa
    public void asigna() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n Codigo (10 caracteres): ");
        codigo = input.nextLine();
        System.out.println("\n Ciudad/Pueblo: ");
        poblacion = input.nextLine();
        System.out.println("\n Dirección: ");
        direccion = input.nextLine();
        System.out.println("\n Número de habitaciones: ");
        numHabitacion = Integer.parseInt(input.nextLine());
        System.out.println("\n Precio por día: ");
        precio = (new Double(input.nextLine())).doubleValue();

        //para borrar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // retorna el codigo en string
    public String elCodigo() {
        return codigo;
    }

    // para mostrar las variables d la casa
    public void muestra() {
        //para borrar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Casa Rural " + codigo);
        System.out.println("Población: " + poblacion);
        System.out.println("Dirección: " + direccion);
        System.out.println("Precio por día: " + precio);
        System.out.println("");
    }
}