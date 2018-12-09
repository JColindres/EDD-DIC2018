#include "Sopa.h"
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

Sopa::Sopa()
{
    //ctor
}

Sopa::~Sopa()
{
    //dtor
}

string rutaSopa;
int linS = 0;
int colS = 0;
int contVect2 = 0;
int numL = 0;
int cant = 0;
int k2 = 0;
int kkk = 0;
string **sopa;
string *letras;
string *encontrados;
vector<string> vect2;
string cad1;
string cad2;
bool enc = false;

void llenarSopa(string rm)
{
    ifstream arch(rm);
    linS = 0;
    colS = 0;
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
            linS++;
        }
        arch.close();
    }

    colS = vect.size()/linS;
    int contVect = 0;
    sopa = new string*[linS];
    for(i = 0; i < linS; i++)
    {
        sopa[i] = new string[colS];
    }
    for(i = 0; i < linS; i++)
    {
        for(j = 0; j < colS; j++)
        {
            sopa[i][j] = vect.at(contVect);
            contVect++;
        }
    }

    for(i = 0; i < linS; i++)
    {
        for(j = 0; j < colS; j++)
        {
            cout<<"  ["<<sopa[i][j]<<"]";
        }
        cout<<"\n";
    }

    cout<<"\n   Escriba la ruta:"<<endl;
    cin>>rutaSopa;

    ifstream pal(rutaSopa);
    string lineapa;
    string l;
    contVect2 = 0;

    if(pal.is_open())
    {
        while(getline(pal,lineapa))
        {
            stringstream ss(lineapa);
            while(ss >> l)
            {
                vect2.push_back(l);
                if(ss.peek() == ',')
                    ss.ignore();
            }
        }
        pal.close();
    }

    contVect2 = vect2.size();

    for(int z = 0; z < contVect2; z++)
    {
        cout<<"   "<<vect2.at(z)<<endl;
    }
    encontrados = new string[contVect2];
}

void buscarPalabras(int iii, int jjj)
{
    int i = iii; int j = jjj;
    if(k2 >= cant)
    {
        enc = true;
    }
    else if(k2 < cant)
    {
        if(sopa[i][j] == letras[k2])
        {
            string ii = to_string(i);
            string jj = to_string(j);
            int aux = kkk;
            if(aux > 9)
            {
                aux = aux - 10;
            }
            encontrados[kkk] = encontrados[kkk] + to_string(aux) + "(" + ii + "," + jj + ")";
            //cout<<"(" << ii << "," << jj << ")"<<endl;
            cout<<letras[k2]<<endl;
            if(j + 1 < colS)
            {
                if(sopa[i][j+1] == letras[k2+1])
                {
                    k2++;
                    buscarPalabras(i,j+1);
                }
            }
            else if(i + 1 < linS)
            {
                if(sopa[i+1][j] == letras[k2+1])
                {
                    k2++;
                    buscarPalabras(i+1,j);
                }
            }
        }
    }
}

void bp()
{
    kkk = 0;
    for(int z = 0; z < contVect2; z++)
    {
        cad1 = vect2.at(z);
        cant = cad1.length();
        if(linS >= colS)
        {
            numL = linS;
            letras = new string[numL];
        }
        else
        {
            numL = colS;
            letras = new string[numL];
        }

        for(int t = 0; t < cant; t++)
        {
            cad2 = cad1.substr(t,1);
            letras[t] = cad2;
        }
        for(int i = 0; i < linS; i++)
        {
            for(int j  = 0; j < colS; j++)
            {
                k2 = 0;
                string ii = to_string(i);
                string jj = to_string(j);
                enc = false;
                if(sopa[i][j] == letras[k2])
                {
                    buscarPalabras(i,j);
                    cout<<"asdasd"<<endl;
                    kkk++;
                    break;
                }
            }
            break;
        }
    }
    for(int p = 0; p < contVect2; p++)
    {
        cout<<"  Palabra "<<p+1<<": "<<encontrados[p]<<endl;
    }
}

void cargarSopa()
{
    cout<<"\n   Escriba la ruta:"<<endl;
    cin>>rutaSopa;

    llenarSopa(rutaSopa);
    bp();
}

void graficarSopa()
{
    ofstream arc;
    arc.open("sopa.dot", ios::out);
    arc<<"digraph G { table [ shape = plaintext label=<<table>"<<endl;
    for(int i = 0; i < linS; i++)
    {
        arc<<"<tr>"<<endl;
        for(int j = 0; j < colS; j++)
        {
            arc<<"<td>" + sopa[i][j] + "</td>";
        }
        arc<<"</tr>"<<endl;
    }
    arc<<"</table>>];}"<<endl;
    arc.close();

    system("dot -Tjpg sopa.dot -o sopa.jpg");
    system("start sopa.jpg");
}


