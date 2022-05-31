package CasasAlcarria;

public class TablaDispersa {

    static final int TAMTABLA = 101;
    private int numElementos;
    private double factorCarga;
    private CasaRural[] tabla;

    //inicializacion
    public TablaDispersa() {
        tabla = new CasaRural[TAMTABLA];

        for (int j = 0; j < TAMTABLA; j++){
            tabla[j] = null;

        }
            

        numElementos = 0;
        factorCarga = 0.0;
    }

    // funcion para tranformar la clave en entero
    public int direccion(String clave) {
        int i = 0, p;
        long d;
        d = transformaCadena(clave);
        p = (int) (d % TAMTABLA);
        while (tabla[p] != null && !tabla[p].elCodigo().equals(clave)) {
            i++;
            p = p + i * i;
            p = p % TAMTABLA;
        }

        return p;
    }

    
    long transformaCadena(String c) {
        long d;
        d = 0;
        for (int j = 0; j < Math.min(10, c.length()); j++) {
            d = d * 27 + (int) c.charAt(j);
        }
        if (d < 0)
            d = -d;
        return d;
    }

    // este procedimiento es para insertar una casa en la tabla
    public void insertar(CasaRural r) {
        int posicion;
        posicion = direccion(r.elCodigo());
        tabla[posicion] = r;
        numElementos++;
        factorCarga = (double) (numElementos) / TAMTABLA;
        if (factorCarga > 0.5)
            System.out.println("\n!! Factor de carga supera el 50%.!!" + " Conviene aumentar el tamaño.");
    }


    // para buscar y encontrar una casa en la tabla
    public CasaRural buscar(String clave) {
        CasaRural asd;

        int pos;

        pos= direccion(clave);

        asd = tabla[pos];

        if (asd != null){

            if (!asd.esAlta)
            asd = null;

        System.out.println("la casa no se encuentra ");
        }
        return asd;
    }

    // procedimiento para eliminar una casa de la tabla
    public void eliminar(String clave) {
        int posicion ;

        posicion = direccion(clave);

        if (tabla[posicion] != null) {
            tabla[posicion].esAlta = false;
            System.out.println("Se borro correctamente la casa " + clave);
        }else{
            System.out.println("No se ha encontrado la casa");
        }
        

    }

}