/*
=========================================================
🧠 HOJA DE AYUDA - ESTRUCTURAS BÁSICAS EN JAVA
=========================================================

----------------------------------------------
💬 IF / ELSE
----------------------------------------------
Sirve para ejecutar algo solo si se cumple una condición.

🔹 Sintaxis:
if (condición) {
    // Código si la condición es verdadera
} else {
    // Código si la condición es falsa
}

🔹 Ejemplo:
int edad = 18;
if (edad >= 18) {
    System.out.println("Eres mayor de edad");
} else {
    System.out.println("Eres menor de edad");
}


----------------------------------------------
💬 IF ANIDADO (IF dentro de otro IF)
----------------------------------------------
Se usa cuando quieres comprobar más de una condición en niveles.

🔹 Ejemplo:
int nota = 7;
if (nota >= 5) {
    if (nota >= 9) {
        System.out.println("Sobresaliente");
    } else {
        System.out.println("Aprobado");
    }
} else {
    System.out.println("Suspenso");
}


----------------------------------------------
💬 ELSE IF (varias condiciones seguidas)
----------------------------------------------
Permite comprobar distintas opciones sin anidar muchos ifs.

🔹 Ejemplo:
int numero = 0;
if (numero > 0) {
    System.out.println("Positivo");
} else if (numero < 0) {
    System.out.println("Negativo");
} else {
    System.out.println("Cero");
}


----------------------------------------------
💬 SWITCH
----------------------------------------------
Ideal cuando hay muchas opciones posibles para una misma variable.

🔹 Ejemplo:
char letra = 'B';
switch (letra) {
    case 'A':
        System.out.println("Excelente");
        break;
    case 'B':
        System.out.println("Bien");
        break;
    case 'C':
        System.out.println("Suficiente");
        break;
    default:
        System.out.println("Nota desconocida");
        break;
}


----------------------------------------------
💬 FOR
----------------------------------------------
Se usa cuando sabes cuántas veces quieres repetir algo.

🔹 Sintaxis:
for (inicialización; condición; incremento) {
    // Código que se repite
}

🔹 Ejemplo:
for (int i = 1; i <= 5; i++) {
    System.out.println("Número: " + i);
}


----------------------------------------------
💬 WHILE
----------------------------------------------
Repite un bloque mientras se cumpla una condición (nº de repeticiones desconocido).

🔹 Ejemplo:
int contador = 1;
while (contador <= 3) {
    System.out.println("Contando: " + contador);
    contador++; // Muy importante aumentar el contador, o el bucle será infinito
}


----------------------------------------------
💬 DO WHILE
----------------------------------------------
Similar a while, pero se ejecuta al menos una vez, incluso si la condición es falsa.

🔹 Ejemplo:
int opcion;
do {
    System.out.println("1. Jugar");
    System.out.println("2. Salir");
    opcion = 2; // Aquí normalmente se pediría un número con Scanner
} while (opcion != 2);
System.out.println("Programa finalizado");


----------------------------------------------
💬 OPERADORES LÓGICOS
----------------------------------------------
==   Igual que  
!=   Distinto de  
>    Mayor que  
<    Menor que  
>=   Mayor o igual  
<=   Menor o igual  
&&   Y lógico (ambas condiciones verdaderas)  
||   O lógico (al menos una condición verdadera)  
!    Negación (cambia true ↔ false)

🔹 Ejemplo:
int edad = 20;
boolean tieneCarnet = true;
if (edad >= 18 && tieneCarnet) {
    System.out.println("Puedes conducir");
}


----------------------------------------------
💬 VARIABLES BÁSICAS
----------------------------------------------
int → números enteros (10, -5, 0)
double → números decimales (3.14, -0.5)
String → texto ("Hola")
char → un solo carácter ('A')
boolean → verdadero o falso (true / false)

🔹 Ejemplo:
int edad = 25;
double precio = 19.99;
String nombre = "Carlos";
char letra = 'A';
boolean activo = true;


----------------------------------------------
💬 INPUT CON SCANNER
----------------------------------------------
Para leer datos del usuario desde teclado.

🔹 Ejemplo:
import java.util.Scanner;

Scanner sc = new Scanner(System.in);

System.out.print("Introduce tu nombre: ");
String nombre = sc.nextLine();

System.out.print("Introduce tu edad: ");
int edad = sc.nextInt();

System.out.println("Hola " + nombre + ", tienes " + edad + " años.");

sc.close();


----------------------------------------------
💬 CONVERTIR TIPOS
----------------------------------------------
A veces hay que cambiar el tipo de dato (casting).

🔹 Ejemplo:
int a = 5;
int b = 2;
double division = (double) a / b; // Resultado = 2.5
System.out.println(division);


----------------------------------------------
💬 FORMATO DE SALIDA
----------------------------------------------
Para mostrar resultados bonitos:

🔹 Ejemplo:
System.out.printf("El precio es %.2f euros%n", 12.3456);
// Muestra: "El precio es 12.35 euros"

=========================================================
💡 CONSEJO FINAL:
Usa System.out.println() para depurar tu código durante el examen.
Te ayuda a saber si las variables tienen el valor esperado.
=========================================================
*/
package SUPERAYUDAS;


