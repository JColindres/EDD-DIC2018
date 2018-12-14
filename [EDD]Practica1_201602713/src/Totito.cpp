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
int **matriz_totito;

void resultado();

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
    matriz_totito = new int*[3];
    for(i = 0; i < 3; i++)
    {
        matriz_totito[i] = new int[3];
    }
    for(i = 0; i < 3; i++)
    {
        for(j = 0; j < 3; j++)
        {
            matriz_totito[i][j] = vect.at(contVect);
            contVect++;
        }
    }

    for(i = 0; i < 3; i++)
    {
        for(j = 0; j < 3; j++)
        {
            cout<<"  ["<<matriz_totito[i][j]<<"]";
        }
        cout<<"\n";
    }
}

void cargarTotito()
{
    cout<<"\n   Escriba la ruta:"<<endl;
    cin>>rutaTotito;

    fillinTotito(rutaTotito);
    resultado();
}


void resultado(){
    int hola=0;
    int cuenta_X=0,cuenta_O=0;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(matriz_totito[j][i]==1){
                cuenta_X++;
            }else if(matriz_totito[j][i]==2){
                cuenta_O++;
            }
        }
    }
    if((cuenta_X-cuenta_O)==1 || (cuenta_O-cuenta_X)==0 ){
        if((cuenta_X-cuenta_O)==0){
            if(      matriz_totito[0][0]==1 && matriz_totito[0][1]==1 && matriz_totito[0][2]==0){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][0]==0 && matriz_totito[0][1]==1 && matriz_totito[0][2]==1){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][0]==1 && matriz_totito[0][1]==0 && matriz_totito[0][2]==1){
                cout<<"Resultado: 1"<<endl;

            }else if(matriz_totito[1][0]==1 && matriz_totito[1][1]==1 && matriz_totito[1][2]==0){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[1][0]==0 && matriz_totito[1][1]==1 && matriz_totito[1][2]==1){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[1][0]==1 && matriz_totito[1][1]==0 && matriz_totito[1][2]==1){
                cout<<"Resultado: 1"<<endl;


            }else if(matriz_totito[2][0]==1 && matriz_totito[2][1]==1 && matriz_totito[2][2]==0){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[2][0]==0 && matriz_totito[2][1]==1 && matriz_totito[2][2]==1){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[2][0]==1 && matriz_totito[2][1]==0 && matriz_totito[2][2]==1){
                cout<<"Resultado: 1"<<endl;


            }else if(matriz_totito[0][0]==1 && matriz_totito[1][0]==1 && matriz_totito[2][0]==0){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][0]==1 && matriz_totito[1][0]==0 && matriz_totito[2][0]==1){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][0]==1 && matriz_totito[1][0]==1 && matriz_totito[2][0]==0){
                cout<<"Resultado: 1"<<endl;


            }else if(matriz_totito[0][1]==1 && matriz_totito[1][1]==1 && matriz_totito[2][1]==0){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][1]==1 && matriz_totito[1][1]==0 && matriz_totito[2][1]==1){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][1]==1 && matriz_totito[1][1]==1 && matriz_totito[2][1]==0){
                cout<<"Resultado: 1"<<endl;


            }else if(matriz_totito[0][2]==1 && matriz_totito[1][2]==1 && matriz_totito[2][2]==0){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][2]==1 && matriz_totito[1][2]==0 && matriz_totito[2][2]==1){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][2]==1 && matriz_totito[1][2]==1 && matriz_totito[2][2]==0){
                cout<<"Resultado: 1"<<endl;

            }else if(matriz_totito[0][0]==1 && matriz_totito[1][1]==1 && matriz_totito[2][2]==0){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][0]==1 && matriz_totito[1][1]==0 && matriz_totito[2][2]==1){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][0]==1 && matriz_totito[1][1]==1 && matriz_totito[2][2]==0){
                cout<<"Resultado: 1"<<endl;

            }else if(matriz_totito[0][2]==1 && matriz_totito[1][1]==1 && matriz_totito[2][0]==0){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][2]==1 && matriz_totito[1][1]==0 && matriz_totito[2][0]==1){
                cout<<"Resultado: 1"<<endl;
            }else if(matriz_totito[0][2]==1 && matriz_totito[1][1]==1 && matriz_totito[2][0]==0){
                cout<<"Resultado: 1"<<endl;

            }else{
                hola++;
            }

        }else{
            if(      matriz_totito[0][0]==2 && matriz_totito[0][1]==2 && matriz_totito[0][2]==0){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][0]==0 && matriz_totito[0][1]==2 && matriz_totito[0][2]==2){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][0]==2 && matriz_totito[0][1]==0 && matriz_totito[0][2]==2){
                cout<<"Resultado: 2"<<endl;

            }else if(matriz_totito[1][0]==2 && matriz_totito[1][1]==2 && matriz_totito[1][2]==0){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[1][0]==0 && matriz_totito[1][1]==2 && matriz_totito[1][2]==2){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[1][0]==2 && matriz_totito[1][1]==0 && matriz_totito[1][2]==2){
                cout<<"Resultado: 2"<<endl;


            }else if(matriz_totito[2][0]==2 && matriz_totito[2][1]==2 && matriz_totito[2][2]==0){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[2][0]==0 && matriz_totito[2][1]==2 && matriz_totito[2][2]==2){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[2][0]==2 && matriz_totito[2][1]==0 && matriz_totito[2][2]==2){
                cout<<"Resultado: 2"<<endl;


            }else if(matriz_totito[0][0]==2 && matriz_totito[1][0]==2 && matriz_totito[2][0]==0){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][0]==2 && matriz_totito[1][0]==0 && matriz_totito[2][0]==2){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][0]==2 && matriz_totito[1][0]==2 && matriz_totito[2][0]==0){
                cout<<"Resultado: 2"<<endl;


            }else if(matriz_totito[0][1]==2 && matriz_totito[1][1]==2 && matriz_totito[2][1]==0){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][1]==2 && matriz_totito[1][1]==0 && matriz_totito[2][1]==2){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][1]==2 && matriz_totito[1][1]==2 && matriz_totito[2][1]==0){
                cout<<"Resultado: 2"<<endl;


            }else if(matriz_totito[0][2]==2 && matriz_totito[1][2]==2 && matriz_totito[2][2]==0){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][2]==2 && matriz_totito[1][2]==0 && matriz_totito[2][2]==2){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][2]==2 && matriz_totito[1][2]==2 && matriz_totito[2][2]==0){
                cout<<"Resultado: 2"<<endl;

            }else if(matriz_totito[0][0]==2 && matriz_totito[1][1]==2 && matriz_totito[2][2]==0){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][0]==2 && matriz_totito[1][1]==0 && matriz_totito[2][2]==2){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][0]==2 && matriz_totito[1][1]==2 && matriz_totito[2][2]==0){
                cout<<"Resultado: 2"<<endl;

            }else if(matriz_totito[0][2]==2 && matriz_totito[1][1]==2 && matriz_totito[2][0]==0){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][2]==2 && matriz_totito[1][1]==0 && matriz_totito[2][0]==2){
                cout<<"Resultado: 2"<<endl;
            }else if(matriz_totito[0][2]==2 && matriz_totito[1][1]==2 && matriz_totito[2][0]==0){
                cout<<"Resultado: 2"<<endl;

            }else{
                hola++;
            }

        }
        if(hola==2){
            cout<<"Resultado: 0"<<endl;
        }
        cout<<"Resultado: 0"<<endl;
    }else{
        cout<<"Resultado: -1"<<endl;
    }
}
