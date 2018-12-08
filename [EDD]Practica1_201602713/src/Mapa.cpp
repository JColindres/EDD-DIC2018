#include "Mapa.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

using namespace std;

Mapa::Mapa()
{
    //ctor
}

Mapa::~Mapa()
{
    //dtor
}

string rutaMapa;
int linMa = 0;
int colMa = 0;
int num = 0;
int k = 0;
int kk = 0;
string **mapa;
string *listaIslas;
string *islas;
bool encontrado = false;

void llenarMapa(string rm)
{
    ifstream arch(rm);
    linMa = 0;
    colMa = 0;
    num = 0;
    string linea;
    vector<char> vect;
    int i;
    int j;
    char k;

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
            linMa++;
        }
        arch.close();
    }

    colMa = vect.size()/linMa;
    num = vect.size();
    int contVect = 0;
    mapa = new string*[linMa];
    listaIslas = new string[num];
    islas = new string[num];
    for(i = 0; i < linMa; i++)
    {
        mapa[i] = new string[colMa];
    }
    for(i = 0; i < linMa; i++)
    {
        for(j = 0; j < colMa; j++)
        {
            mapa[i][j] = vect.at(contVect);
            contVect++;
        }
    }

    for(i = 0; i < linMa; i++)
    {
        for(j = 0; j < colMa; j++)
        {
            cout<<"  ["<<mapa[i][j]<<"]";
        }
        cout<<"\n";
    }
}

bool esta(string a)
{
    for(int t = 0; t < num; t++)
    {
        if(listaIslas[t] == a)
        {
            return true;
        }
    }
    return false;
}

void buscarIslas(int iii, int jjj)
{
    int i = iii; int j = jjj;
    if(mapa[i][j] == "1")
    {
        string ii = to_string(i);
        string jj = to_string(j);
        if(!esta("(" + ii + "," + jj + ")"))
        {
            listaIslas[k] = "(" + ii + "," + jj + ")";
            cout<<"("<< ii << "," << jj << ")";
            islas[kk] = islas[kk] + listaIslas[k];
            k++;
        }
        if(mapa[i][j+1] == "1")
        {
            buscarIslas(i,j+1);
        }
        if(mapa[i+1][j] == "1")
        {
            buscarIslas(i+1,j);
        }
    }
}

void bi(int i, int j)
{
    kk = 0;
    for(int i = 0; i < linMa; i++)
    {
        for(int j = 0; j < colMa; j++)
        {
            string ii = to_string(i);
            string jj = to_string(j);
            if(mapa[i][j] == "1" && !esta("(" + ii + "," + jj + ")"))
            {
                buscarIslas(i,j);
                kk++;
            }
        }
    }
    for(int t = 0; t < kk; t++)
    {
        if(islas[t] != "")
            cout<<"\n   Isla "<<t+1<<": "<<islas[t]<<endl;
    }
}

void cargarMapa()
{
    cout<<"\n   Escriba la ruta:"<<endl;
    cin>>rutaMapa;

    llenarMapa(rutaMapa);
}

void graficarMapa()
{
    ofstream arc;
    arc.open("mapa.dot", ios::out);
    arc<<"digraph G { table [ shape = plaintext label=<<table>"<<endl;
    for(int i = 0; i < linMa; i++)
    {
        arc<<"<tr>"<<endl;
        for(int j = 0; j < colMa; j++)
        {
            arc<<"<td>" + mapa[i][j] + "</td>";
        }
        arc<<"</tr>"<<endl;
    }
    arc<<"</table>>];}"<<endl;
    arc.close();

    system("dot -Tjpg mapa.dot -o mapa.jpg");
    system("start mapa.jpg");
}
