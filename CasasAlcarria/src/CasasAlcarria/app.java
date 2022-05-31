package CasasAlcarria;


import java.util.Scanner;


/**
 *
 * @author user
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ent = 1;

        String cod;

        Scanner sc = new Scanner(System.in);

        TablaDispersa tabla = new TablaDispersa();
        //para contar las veces que se cargaron casas
        int contador=0;
        
        do{

            System.out.println("");
            System.out.println("Elija la opcion que desee:"); 
            System.out.println("");
            System.out.println("Ingrese 1 Cargar una casa rural"); 
            System.out.println("Ingrese 2 Buscar una casa rural"); 
            System.out.println("Ingrese 3 Eliminar una casa rural"); 
            System.out.println("Ingrese 0 Para Salir");
            ent = sc.nextInt();

            sc.nextLine();  

            while(ent < 0 || 3 < ent){

                //para borrar pantalla
                System.out.print("\033[H\033[2J");
                System.out.flush();
    
                System.out.println("ERROR.");
                    
                System.out.println("Elija:"); 
                System.out.println("Ingrese 1 Cargar una casa rural"); 
                System.out.println("Ingrese 2 Buscar una casa rural"); 
                System.out.println("Ingrese 3 Eliminar una casa rural"); 
                System.out.println("Ingrese 0 Para Salir");
                ent = sc.nextInt();

                sc.nextLine();  
                
            }


            //para borrar pantalla
            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch(ent){
                
                case 1:

                    CasaRural Casa = new CasaRural();
                    tabla.insertar(Casa);
                    contador=contador+1;

                    break;
                    
                case 2:
                    if(0 < contador){

                        System.out.println("Ingrese el codigo para buscar la casa:"); 
                        cod = sc.nextLine();
                        tabla.buscar(cod).muestra();

                        break;
                    }else
                    {
                        System.out.println("ERROR");
                        System.out.println("No hay ninguna casa cargada hasta el momento");
                        break;
                    }  
                    
                case 3:

                    if(0 < contador){   

                        System.out.println("Ingrese el codigo de la casa que desea eliminar:"); 
                        cod = sc.nextLine();
                        tabla.eliminar(cod);

                        break;

                    }else
                    {
                        System.out.println("ERROR");
                        System.out.println("No hay ninguna casa cargada hasta el momento");

                        break;
                    }  
                       
            }

        }while(ent!=0);    
    }        
}                
