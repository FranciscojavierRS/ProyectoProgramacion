/*
===============================
ESTRUCTURA BASE DE EXAMEN
===============================


Scanner sc = new Scanner(System.in);

// 1. Declarar variables necesarias
int valor, suma = 0, contador = 0, max = 0, min = 0;
boolean primer = true;

// 2. Leer primer valor
valor = sc.nextInt();

// 3. Bucle principal (centinela o N veces)
while (valor != -1) {
    // aquí va la lógica del bloque elegido
    suma += valor;
    contador++;

    // ejemplo si se pide max/min:
    if (primer) { max = valor; min = valor; primer = false; }
    else {
        if (valor > max) max = valor;
        if (valor < min) min = valor;
    }

    valor = sc.nextInt(); // volver a leer
}

// 4. Procesar y mostrar resultados
if (contador > 0) {
    double media = suma / (double)contador;
    System.out.println("Media = " + media);
    System.out.println("Max = " + max + " Min = " + min);
}

// 5. Cerrar scanner
sc.close();
*/

package SUPERAYUDAS;