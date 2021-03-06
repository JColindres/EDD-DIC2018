#include <iostream>
#include <stdio.h>
#include "Matriz.h"
#include "Sopa.h"
#include "Mapa.h"
#include "Totito.h"

using namespace std;

int main()
{
    int opcion;

    do
    {
        FirstMenu:
        system("cls");
        printf( "\n   ------------------------------------------");
        printf( "\n          [EDD-B]Practica 1 - 201602713");
        printf( "\n\n   Introduzca opcion (1-5): ");
        printf( "\n\n   1. Matriz");
        printf( "\n   2. Totito");
        printf( "\n   3. Sopa de Letras." );
        printf( "\n   4. Mapa." );
        printf( "\n   5. Salir.\n\n" );
        printf( "\n\n   Su eleccion: ");

        scanf( "%d", &opcion );

        /* Inicio del anidamiento */

        switch ( opcion )
        {
            case 1:
                SecondMenu:
                system("cls");
                printf( "\n   ------------------------------------------");
                printf( "\n          1. Matriz");
                printf( "\n\n   Introduzca opcion (1-5): ");
                printf( "\n\n   1.1. Cargar Matriz.");
                printf( "\n   1.2. Calcular Determinante.");
                printf( "\n   1.3. Mostrar Matriz.");
                printf( "\n   1.4. Mostrar Matriz Transpuesta.");
                printf( "\n   1.5. Regresar.\n\n" );
                printf( "\n\n   Su eleccion: ");

                scanf( "%d", &opcion );

                /* Inicio del anidamiento */

                switch ( opcion )
                {
                    case 1:
                        ThirdMenu:
                        system("cls");
                        printf( "\n   ------------------------------------------");
                        printf( "\n          1.1. Cargar Matriz");
                        printf( "\n\n   Introduzca opcion (1-2): ");
                        printf( "\n\n   1.1.1. Insertar ruta.");
                        printf( "\n   1.1.2. Regresar.\n\n" );
                        printf( "\n\n   Su eleccion: ");

                        scanf( "%d", &opcion );

                        /* Inicio del anidamiento */

                        switch ( opcion )
                        {
                            case 1:
                                cargarMatriz();
                                system("pause");
                                goto ThirdMenu;
                                break;

                            case 2:
                                goto SecondMenu;
                                break;

                            default:
                                printf("\n   Seleccione un valor valido!");
                                goto ThirdMenu;
                                break;
                        }
                        break;

                    case 2:
                        FourthMenu:
                        system("cls");
                        printf( "\n   ------------------------------------------");
                        printf( "\n          1.2. Calcular Determinante");
                        printf( "\n\n   Introduzca opcion (1-2): ");
                        printf( "\n\n   1.2.1. Calcular.");
                        printf( "\n   1.2.2. Regresar.\n\n" );
                        printf( "\n\n   Su eleccion: ");

                        scanf( "%d", &opcion );

                        /* Inicio del anidamiento */

                        switch ( opcion )
                        {
                            case 1:
                                calcularDet();
                                system("pause");
                                goto FourthMenu;
                                break;

                            case 2:
                                goto SecondMenu;
                                break;

                            default:
                                printf("\n   Seleccione un valor valido!");
                                goto FourthMenu;
                                break;
                        }
                        break;

                    case 3:
                        FifthMenu:
                        system("cls");
                        printf( "\n   ------------------------------------------");
                        printf( "\n          1.3. Mostrar Matriz");
                        printf( "\n\n   Introduzca opcion (1-2): ");
                        printf( "\n\n   1.3.1. Abrir Imagen.");
                        printf( "\n   1.3.2. Regresar.\n\n" );
                        printf( "\n\n   Su eleccion: ");

                        scanf( "%d", &opcion );

                        /* Inicio del anidamiento */

                        switch ( opcion )
                        {
                            case 1:
                                graficarMatriz();
                                system("pause");
                                goto FifthMenu;
                                break;

                            case 2:
                                goto SecondMenu;
                                break;

                            default:
                                printf("\n   Seleccione un valor valido!");
                                break;
                        }
                        break;

                    case 4:
                        SixthMenu:
                        system("cls");
                        printf( "\n   ------------------------------------------");
                        printf( "\n          1.4. Mostrar Matriz Transpuesta");
                        printf( "\n\n   Introduzca opcion (1-2): ");
                        printf( "\n\n   1.4.1. Abrir Imagen.");
                        printf( "\n   1.4.2. Regresar.\n\n" );
                        printf( "\n\n   Su eleccion: ");

                        scanf( "%d", &opcion );

                        /* Inicio del anidamiento */

                        switch ( opcion )
                        {
                            case 1:
                                graficarMatrizTranspuesta();
                                system("pause");
                                goto SixthMenu;
                                break;

                            case 2:
                                goto SecondMenu;
                                break;

                            default:
                                printf("\n   Seleccione un valor valido!");
                                break;
                        }
                        break;

                    case 5:
                        goto FirstMenu;
                        break;

                    default:
                        printf("\n   Seleccione un valor valido!");
                        break;
                }
                break;

            case 2:
                HojaMenu:
                system("cls");
                printf( "\n   ------------------------------------------");
                printf( "\n          2. Totito");
                printf( "\n\n   Introduzca opcion (1-2): ");
                printf( "\n\n   2.1. Cargar Totito.");
                printf( "\n   2.2. Regresar.\n\n" );
                printf( "\n\n   Su eleccion: ");

                scanf( "%d", &opcion );

                /* Inicio del anidamiento */

                switch ( opcion )
                {
                    case 1:
                        CargarT:
                        system("cls");
                        printf( "\n   ------------------------------------------");
                        printf( "\n          2.1. Cargar Totito");
                        printf( "\n\n   Introduzca opcion (1-2): ");
                        printf( "\n\n   2.1.1. Insertar ruta.");
                        printf( "\n   2.1.2. Regresar.\n\n" );
                        printf( "\n\n   Su eleccion: ");

                        scanf( "%d", &opcion );

                        /* Inicio del anidamiento */

                        switch ( opcion )
                        {
                            case 1:
                                cargarTotito();
                                system("pause");
                                goto CargarT;
                                break;

                            case 2:
                                goto HojaMenu;
                                break;

                            default:
                                printf("\n   Seleccione un valor valido!");
                                goto CargarT;
                                break;
                        }
                        break;

                    case 2:
                        goto FirstMenu;
                        break;

                    default:
                        printf("\n   Seleccione un valor valido!");
                        break;
                }
                break;

            case 3:
                MenuSopa:
                system("cls");
                printf( "\n   ------------------------------------------");
                printf( "\n          3. Sopa de Letras");
                printf( "\n\n   Introduzca opcion (1-5): ");
                printf( "\n\n   3.1. Cargar Sopa.");
                printf( "\n   3.2. Buscar Palabras.");
                printf( "\n   3.3. Mostrar Sopa.");
                printf( "\n   3.4. Regresar.\n\n" );
                printf( "\n\n   Su eleccion: ");

                scanf( "%d", &opcion );

                /* Inicio del anidamiento */

                switch ( opcion )
                {
                    case 1:
                        CargarSopa:
                        system("cls");
                        printf( "\n   ------------------------------------------");
                        printf( "\n          3.1. Cargar Matriz");
                        printf( "\n\n   Introduzca opcion (1-2): ");
                        printf( "\n\n   3.1.1. Insertar ruta.");
                        printf( "\n   3.1.2. Regresar.\n\n" );
                        printf( "\n\n   Su eleccion: ");

                        scanf( "%d", &opcion );

                        /* Inicio del anidamiento */

                        switch ( opcion )
                        {
                            case 1:
                                cargarSopa();
                                system("pause");
                                goto CargarSopa;
                                break;

                            case 2:
                                goto MenuSopa;
                                break;

                            default:
                                printf("\n   Seleccione un valor valido!");
                                goto CargarSopa;
                                break;
                        }
                        break;

                    case 2:
                        system("cls");
                        printf( "\n   ------------------------------------------");
                        printf( "\n          3.2. Cargar Matriz\n\n\n");
                        system("pause");
                        goto MenuSopa;
                        break;

                    case 3:
                        system("cls");
                        graficarSopa();
                        system("pause");
                        goto MenuSopa;
                        break;

                    case 4:
                        goto FirstMenu;
                        break;

                    default:
                        printf("\n   Seleccione un valor valido!");
                        goto MenuSopa;
                        break;

                }
            case 4:
                MenuMapa:
                system("cls");
                printf( "\n   ------------------------------------------");
                printf( "\n          4. Mapa");
                printf( "\n\n   Introduzca opcion (1-5): ");
                printf( "\n\n   4.1. Cargar Mapa.");
                printf( "\n   4.2. Mostrar Lista de Islas.");
                printf( "\n   4.3. Mostrar Mapa.");
                printf( "\n   4.4. Regresar.\n\n" );
                printf( "\n\n   Su eleccion: ");

                scanf( "%d", &opcion );

                /* Inicio del anidamiento */

                switch ( opcion )
                {
                    case 1:
                        CargarMapa:
                        system("cls");
                        printf( "\n   ------------------------------------------");
                        printf( "\n          4.1. Cargar Mapa");
                        printf( "\n\n   Introduzca opcion (1-2): ");
                        printf( "\n\n   4.1.1. Insertar ruta.");
                        printf( "\n   4.1.2. Regresar.\n\n" );
                        printf( "\n\n   Su eleccion: ");

                        scanf( "%d", &opcion );

                        /* Inicio del anidamiento */

                        switch ( opcion )
                        {
                            case 1:
                                cargarMapa();
                                system("pause");
                                goto CargarMapa;
                                break;

                            case 2:
                                goto MenuMapa;
                                break;

                            default:
                                printf("\n   Seleccione un valor valido!");
                                goto CargarMapa;
                                break;
                        }
                        break;

                    case 2:
                        MostrarIslas:
                        system("cls");
                        printf( "\n   ------------------------------------------");
                        printf( "\n          4.2. Mostrar Lista de Islas");
                        printf( "\n\n   Introduzca opcion (1-2): ");
                        printf( "\n\n   4.2.1. Mostrar.");
                        printf( "\n   4.2.2. Regresar.\n\n" );
                        printf( "\n\n   Su eleccion: ");

                        scanf( "%d", &opcion );

                        /* Inicio del anidamiento */

                        switch ( opcion )
                        {
                            case 1:
                                bi(0,0);
                                system("pause");
                                goto MostrarIslas;
                                break;

                            case 2:
                                goto MenuMapa;
                                break;

                            default:
                                printf("\n   Seleccione un valor valido!");
                                goto MostrarIslas;
                                break;
                        }
                        break;

                    case 3:
                        MostrarIslasG:
                        system("cls");
                        printf( "\n   ------------------------------------------");
                        printf( "\n          4.3. Mostrar Islas");
                        printf( "\n\n   Introduzca opcion (1-2): ");
                        printf( "\n\n   4.3.1. Mostrar.");
                        printf( "\n   4.3.2. Regresar.\n\n" );
                        printf( "\n\n   Su eleccion: ");

                        scanf( "%d", &opcion );

                        /* Inicio del anidamiento */

                        switch ( opcion )
                        {
                            case 1:
                                graficarMapa();
                                system("pause");
                                goto MostrarIslasG;
                                break;

                            case 2:
                                goto MenuMapa;
                                break;

                            default:
                                printf("\n   Seleccione un valor valido!");
                                goto MostrarIslasG;
                                break;
                        }
                        break;

                    case 4:
                        goto FirstMenu;
                        break;

                    default:
                        printf("\n   Seleccione un valor valido!");
                        break;
                }
                break;

            case 5:
                printf("\n   Adios");
                break;

            default:
                printf("\n   Seleccione un valor valido!");
                break;
         }

         /* Fin del anidamiento */

    } while ( opcion != 5 );

    return 0;
}

