#include "Totito.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

using namespace std;

Totito::Totito()
{
    //ctor
}

Totito::~Totito()
{
    //dtor
}

string rutaTotito;
int **matrizT;


void fillinTotito(string rm)
{
    ifstream arch(rm);
    string linea;
    vector<int> vect;
    int i;
    int j;
    int k;

    if(arch.is_open())
    {
        while(getline(arch,linea))
        {
            stringstream ss(linea);
            while(ss >> k)
            {
                vect.push_back(k);
                if(ss.peek() == ',')
                    ss.ignore();
            }
        }
        arch.close();
    }

    int contVect = 0;
    matrizT = new int*[3];
    for(i = 0; i < 3; i++)
    {
        matrizT[i] = new int[3];
    }
    for(i = 0; i < 3; i++)
    {
        for(j = 0; j < 3; j++)
        {
            matrizT[i][j] = vect.at(contVect);
            contVect++;
        }
    }

    for(i = 0; i < 3; i++)
    {
        for(j = 0; j < 3; j++)
        {
            cout<<"  ["<<matrizT[i][j]<<"]";
        }
        cout<<"\n";
    }
}

void cargarTotito()
{
    cout<<"\n   Escriba la ruta:"<<endl;
    cin>>rutaTotito;

    fillinTotito(rutaTotito);
}
