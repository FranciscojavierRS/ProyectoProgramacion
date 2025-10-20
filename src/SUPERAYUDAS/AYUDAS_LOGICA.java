/*
===========================================================
     PLANTILLAS DE EXAMEN DE PROGRAMACIÓN EN JAVA
     (SIN ARRAYS, SIN BREAK, TODO ESTRUCTURADO)
===========================================================
Cada bloque explica:
 - CUÁNDO usarlo
 - LÓGICA de razonamiento
 - CÓDIGO genérico (con variables genéricas)
Cambia nombres de variables, condiciones o centinelas según el enunciado.
===========================================================
*/



        /*
        ===========================================================
        1) CALCULAR LA MEDIA DE UNA SECUENCIA
        ===========================================================
        Lógica:
        - Sumar todos los valores introducidos.
        - Contar cuántos se han introducido.
        - Dividir suma / cantidad.
        */

        // --- Con centinela (ej. -1 para terminar) ---
        /*
        Scanner sc = new Scanner(System.in);
        final int CENTINELA = -1;
        int valor = sc.nextInt();
        int contador = 0;
        int acumulador = 0;

        while (valor != CENTINELA) {
            acumulador += valor;
            contador++;
            valor = sc.nextInt();
        }

        if (contador > 0) {
            double media = acumulador / (double) contador;
            System.out.println(media);
        } else {
            System.out.println("Sin datos");
        }
        sc.close();
        */

        // --- Con N valores conocidos ---
        /*
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int acumulador = 0;
        for (int i = 0; i < N; i++) {
            int valor = sc.nextInt();
            acumulador += valor;
        }
        double media = acumulador / (double) N;
        System.out.println(media);
        sc.close();
        */


        /*
        ===========================================================
        2) SACAR LOS 2 MÁXIMOS Y LOS 2 MÍNIMOS DE UNA SECUENCIA
        ===========================================================
        Lógica:
        - Mantener dos variables para los mayores y dos para los menores.
        - Ir comparando y actualizando sin usar arrays.
        */

        /*
        Scanner sc = new Scanner(System.in);
        final int CENT = -1;
        int entrada = sc.nextInt();

        boolean primer = true;
        int max1 = 0, max2 = 0;
        int min1 = 0, min2 = 0;

        while (entrada != CENT) {
            if (primer) {
                max1 = entrada; max2 = Integer.MIN_VALUE;
                min1 = entrada; min2 = Integer.MAX_VALUE;
                primer = false;
            } else {
                // actualizar máximos
                if (entrada >= max1) {
                    max2 = max1;
                    max1 = entrada;
                } else if (entrada > max2) {
                    max2 = entrada;
                }
                // actualizar mínimos
                if (entrada <= min1) {
                    min2 = min1;
                    min1 = entrada;
                } else if (entrada < min2) {
                    min2 = entrada;
                }
            }
            entrada = sc.nextInt();
        }

        if (!primer) {
            System.out.println("Max1=" + max1 + " Max2=" + max2);
            System.out.println("Min1=" + min1 + " Min2=" + min2);
        } else {
            System.out.println("Sin datos");
        }
        sc.close();
        */


        /*
        ===========================================================
        3) MÁXIMO Y MÍNIMO SIMPLE
        ===========================================================
        Lógica:
        - Guardar primer valor como referencia.
        - Comparar y actualizar max/min en cada iteración.
        */

        /*
        Scanner sc = new Scanner(System.in);
        final int CENT = -1;
        int valor = sc.nextInt();
        boolean flag = true;
        int max = 0, min = 0;

        while (valor != CENT) {
            if (flag) {
                max = valor; min = valor; flag = false;
            } else {
                if (valor > max) max = valor;
                if (valor < min) min = valor;
            }
            valor = sc.nextInt();
        }
        if (!flag) {
            System.out.println("Max=" + max + " Min=" + min);
        } else {
            System.out.println("Sin datos");
        }
        sc.close();
        */


        /*
        ===========================================================
        4) CONTAR CUÁNTOS CUMPLEN UNA CONDICIÓN
        ===========================================================
        Lógica:
        - Ir leyendo y comprobar si cumple.
        - Sumar 1 cada vez que se cumpla.
        */

        /*
        Scanner sc = new Scanner(System.in);
        final int CENT = 0;
        int valor = sc.nextInt();
        int contadorCond = 0;

        while (valor != CENT) {
            if (valor % 2 == 0) { // Cambiar la condición
                contadorCond++;
            }
            valor = sc.nextInt();
        }
        System.out.println(contadorCond);
        sc.close();
        */


        /*
        ===========================================================
        5) COMPROBAR SI EXISTE ALGUNO QUE CUMPLA UNA CONDICIÓN
        ===========================================================
        Lógica:
        - Usar una variable booleana como "flag".
        - No se usa break; solo se marca la bandera.
        */

        /*
        Scanner sc = new Scanner(System.in);
        final int CENT = -1;
        int v = sc.nextInt();
        boolean existe = false;

        while (v != CENT) {
            if (v > 100) { // Cambiar la condición
                existe = true;
            }
            v = sc.nextInt();
        }

        if (existe) System.out.println("Sí existe");
        else System.out.println("No existe");
        sc.close();
        */


        /*
        ===========================================================
        6) PROCESAR REGISTROS CON VARIOS CAMPOS
        ===========================================================
        Lógica:
        - Leer varios datos por cada registro (ej: nombre, edad, nota...).
        - Calcular totales o condiciones según se pida.
        */

        /*
        Scanner sc = new Scanner(System.in);
        final int CENT = -1;
        int campoClave = sc.nextInt();
        int contador = 0;
        int sumaNotas = 0;
        int contadorMayores = 0;

        while (campoClave != CENT) {
            int edad = sc.nextInt(); // segundo campo
            // String nombre = sc.next(); // si hay nombre

            contador++;
            sumaNotas += campoClave;
            if (edad >= 18) contadorMayores++;

            campoClave = sc.nextInt();
        }

        if (contador > 0) {
            System.out.println("Media=" + (sumaNotas / (double)contador));
            System.out.println("Mayores=" + contadorMayores);
        }
        sc.close();
        */


        /*
        ===========================================================
        7) PROCESAR MESES Y DÍAS (BUCLE ANIDADO)
        ===========================================================
        Lógica:
        - Bucle exterior: meses.
        - Bucle interior: días de cada mes.
        - Calcular estadísticas por mes y global.
        */

        /*
        Scanner sc = new Scanner(System.in);
        int numMeses = sc.nextInt(); // o 12 si fijo
        int acumuladorGlobal = 0, contadorGlobal = 0;
        int mesesCumplen = 0;

        for (int m = 1; m <= numMeses; m++) {
            int dias = sc.nextInt();
            int acumMes = 0, contMes = 0;
            for (int d = 1; d <= dias; d++) {
                int valorDia = sc.nextInt();
                acumMes += valorDia;
                contMes++;
            }
            double mediaMes = (contMes>0) ? acumMes / (double) contMes : 0.0;
            if (mediaMes > 20.0) mesesCumplen++; // Cambiar condición
            acumuladorGlobal += acumMes;
            contadorGlobal += contMes;
            System.out.println("Media mes " + m + " = " + mediaMes);
        }

        double mediaGlobal = (contadorGlobal>0) ? acumuladorGlobal / (double) contadorGlobal : 0.0;
        System.out.println("Media global = " + mediaGlobal);
        System.out.println("Meses que cumplen = " + mesesCumplen);
        sc.close();
        */


        /*
        ===========================================================
        8) VALIDAR UNA ENTRADA HASTA QUE SEA VÁLIDA
        ===========================================================
        Lógica:
        - Usar un do-while.
        - Repetir lectura mientras la condición no se cumpla.
        */

        /*
        Scanner sc = new Scanner(System.in);
        int dia;
        do {
            dia = sc.nextInt();
        } while (dia < 1 || dia > 31);
        System.out.println("Día válido: " + dia);
        sc.close();
        */


        /*
        ===========================================================
        9) SUMAR DÍGITOS DE UN NÚMERO
        ===========================================================
        Lógica:
        - Extraer último dígito con % 10.
        - Dividir por 10 para avanzar.
        */

        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int suma = 0;
        int temp = Math.abs(n);
        while (temp > 0) {
            suma += temp % 10;
            temp /= 10;
        }
        System.out.println(suma);
        sc.close();
        */


        /*
        ===========================================================
        10) INVERTIR UN NÚMERO / COMPROBAR PALÍNDROMO
        ===========================================================
        Lógica:
        - Construir el número invertido multiplicando por 10 y sumando el dígito.
        - Para palíndromo, comparar invertido con original.
        */

        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = Math.abs(n);
        int invertido = 0;
        while (temp > 0) {
            invertido = invertido * 10 + (temp % 10);
            temp /= 10;
        }
        System.out.println(invertido);
        // Comprobar palíndromo:
        // if (invertido == Math.abs(n)) System.out.println("Es palíndromo");
        sc.close();
        */


        /*
        ===========================================================
        11) CALCULAR PORCENTAJE DE UN SUBCONJUNTO
        ===========================================================
        Lógica:
        - Contar total.
        - Contar cuántos cumplen condición.
        - Calcular (cumplen * 100) / total.
        */

        /*
        Scanner sc = new Scanner(System.in);
        final int CENT = -1;
        int nota = sc.nextInt();
        int total = 0;
        int aprobados = 0;

        while (nota != CENT) {
            total++;
            if (nota >= 5) aprobados++; // Cambiar criterio
            nota = sc.nextInt();
        }
        if (total > 0) {
            double porcentaje = aprobados * 100.0 / total;
            System.out.println(porcentaje + "%");
        }
        sc.close();
        */


        /*
        ===========================================================
        12) PLANTILLA GENERAL "TODO EN UNO"
        ===========================================================
        Lógica:
        - Estructura genérica con acumuladores, contadores,
          máximos, mínimos y condición opcional.
        - Copiar y eliminar lo que no necesites.
        */

        /*
        Scanner sc = new Scanner(System.in);
        final int CENT = -1;
        int v = sc.nextInt();

        int contador = 0;
        int suma = 0;
        boolean primer = true;
        int max = 0, min = 0;
        int contadorCond = 0;

        while (v != CENT) {
            suma += v;
            contador++;
            if (primer) { max = v; min = v; primer = false; }
            else {
                if (v > max) max = v;
                if (v < min) min = v;
            }
            if (v % 2 == 0) contadorCond++; // Cambiar condición
            v = sc.nextInt();
        }

        if (contador > 0) {
            System.out.println("Media=" + (suma / (double)contador));
            System.out.println("Max=" + max + " Min=" + min);
            System.out.println("CondicionCumplen=" + contadorCond);
        }
        sc.close();
        */


        /*
        ===========================================================
        CONSEJOS FINALES PARA EL EXAMEN
        ===========================================================
        1. Identifica rápidamente:
           - ¿Lectura con centinela o cantidad fija?
           - ¿Se pide media, máximo, mínimo, porcentaje...?
           - ¿Varios campos por registro o solo uno?

        2. Copia la plantilla del bloque que corresponda.

        3. Cambia:
           - Nombres de variables ("valor", "nota", etc.)
           - Centinela (por el que indique el enunciado)
           - Condiciones (>=5, %2==0, >20, etc.)

        4. Revisa:
           - Evita divisiones por cero.
           - Usa bandera "primer" o "flag" para max/min.
           - No uses break ni arrays.

        5. Lee los datos en el orden exacto que indique el enunciado.
        ===========================================================
        */
   
