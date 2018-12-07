#include <iostream>
#define ORIGINAL 20

using namespace std;

int main()
{

    int original;
    int *puntero;
    int **punterodoble;

    original = ORIGINAL;

    cout<<"El valor de original: "<<original<<endl;

    puntero = &original; /* puntero apunta a original */
    punterodoble = &puntero;

    cout<<"El valor de memoria de original: "<<&original<<endl;
    cout<<"El valor de puntero: "<<puntero<<endl;
    cout<<"El valor de memoria de puntero: "<<&puntero<<endl;
    cout<<"El valor de lo que apunta puntero: "<<*puntero<<endl;
    cout<<"El valor de punterodoble: "<<punterodoble<<endl;
    cout<<"El valor de memoria de punterodoble: "<<&punterodoble<<endl;
    cout<<"El valor de lo que apunta punterodoble: "<<*punterodoble<<endl;
    cout<<"El valor de lo que apunta el apuntador punterodoble: "<<**punterodoble<<endl;

    *puntero = 10; /* el valor a lo que apunta puntero, lo cambiamos de 20 a 10 */

    cout<<"El valor de original ahora es: "<<original<<endl;

    **punterodoble = 20;

    cout<<"El valor de original regresa: "<<original<<endl;

    return 0;
}
