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
string **sopa;

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
}

void cargarSopa()
{
    cout<<"\n   Escriba la ruta:"<<endl;
    cin>>rutaSopa;

    llenarSopa(rutaSopa);
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


