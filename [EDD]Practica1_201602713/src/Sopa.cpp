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
int aux = 0;
string **sopa;
string *letras;
string eee;
string *encontrados;
string *pintados;
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

void horizontal(int i, int j, int F, int C, int l, int ii, int jj)
{
    if(i < F)
    {
        if(sopa[i][j] == letras[l])
        {
            string iii = to_string(i);
            string jjj = to_string(j);
            eee = eee + "(" + iii + "," + jjj + ")";
        }
        if(sopa[i][j+1] != letras[l+1])
        {
            l = 0;
        }
        j++;
    }
}

void buscarPalabrasH(int i, int j, int F, int C, int l, int ii, int jj)
{
    if(i < F && l < cant)
    {
        horizontal(i, j, F, C, l, ii, jj);
        l++;
        j++;
        if(sopa[i][j] != letras[l] && l < cant)
        {
            l = 0;
        }
        if(j < C)
        {
            buscarPalabrasH(i, j, F, C, l, ii, jj);
        }
        else
        {
            i++;
            buscarPalabrasH(i, 0, F, C, l, ii, jj);
        }
    }
    if(l == cant)
    {
        enc = true;
    }
}

void vertical(int i, int j, int F, int C, int l, int ii, int jj)
{
    if(j < C && aux < cant)
    {
        if(sopa[i][j] == letras[l])
        {
            string iii = to_string(i);
            string jjj = to_string(j);
            eee = eee + "(" + iii + "," + jjj + ")";
            //cout<<eee<<endl;
            i++;
            vertical(i, j, F, C, l+1, ii, jj);
            l = l + 1;
            if(l == cant)
            {
                aux = l;
            }
        }
        else
        {
            l = 0;
        }
    }
}

void buscarPalabrasV(int i, int j, int F, int C, int l, int ii, int jj)
{
    if(i < F && aux < cant)
    {
        vertical(i, j, F, C, l, ii, jj);
        j++;
        if(j < C)
        {
            buscarPalabrasV(i, j, F, C, l, ii, jj);
        }
        else
        {
            i++;
            buscarPalabrasV(i, 0, F, C, l, ii, jj);
        }
    }
    if(aux == cant)
    {
        enc = true;
    }
}

void diagonalA(int i, int j, int F, int C, int l, int ii, int jj)
{
    if(i > -1 && i < F && aux < cant)
    {
        if(sopa[i][j] == letras[l])
        {
            //cout<<i<<"-"<<j<<endl;
            string iii = to_string(i);
            string jjj = to_string(j);
            eee = eee + "(" + iii + "," + jjj + ")";
            i--;
            j++;
            diagonalA(i, j, F, C, l+1, ii, jj);
            l = l + 1;
            if(l == cant)
            {
                aux = l;
            }
        }
        else
        {
            l = 0;
        }
    }
}

void buscarPalabrasDA(int i, int j, int F, int C, int l, int ii, int jj)
{
    if(i < F && aux < cant)
    {
        diagonalA(i, j, F, C, l, ii, jj);
        j++;
        if(j < C)
        {
            buscarPalabrasDA(i, j, F, C, l, ii, jj);
        }
        else
        {
            i++;
            buscarPalabrasDA(i, 0, F, C, l, ii, jj);
        }
    }
    if(aux == cant)
    {
        enc = true;
    }
}

void diagonalB(int i, int j, int F, int C, int l, int ii, int jj)
{
    if(j < C && i < F && aux < cant)
    {
        if(sopa[i][j] == letras[l])
        {
            string iii = to_string(i);
            string jjj = to_string(j);
            eee = eee + "(" + iii + "," + jjj + ")";
            //cout<<eee<<endl;
            i++;
            j++;
            diagonalB(i, j, F, C, l+1, ii, jj);
            l = l + 1;
            if(l == cant)
            {
                aux = l;
            }
        }
        else
        {
            l = 0;
        }
    }
}

void buscarPalabrasDB(int i, int j, int F, int C, int l, int ii, int jj)
{
    if(i < F && aux < cant)
    {
        diagonalB(i, j, F, C, l, ii, jj);
        j++;
        if(j < C)
        {
            buscarPalabrasDB(i, j, F, C, l, ii, jj);
        }
        else
        {
            i++;
            buscarPalabrasDB(i, 0, F, C, l, ii, jj);
        }
    }
    if(aux == cant)
    {
        enc = true;
    }
}

void bp()
{
    kkk = 0;
    for(int z = 0; z < contVect2; z++)
    {
        cad1 = vect2.at(z);
        cant = cad1.length();
        cout<<cant<<cad1<<endl;
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
        enc = false;
        eee = "";
        buscarPalabrasH(0, 0, linS, colS, 0, 0, 0);
        if(!enc)
        {
            buscarPalabrasV(0, 0, linS, colS, 0, 0, 0);
        }
        if(!enc)
        {
            buscarPalabrasDA(0, 0, linS, colS, 0, 0, 0);
        }
        if(!enc)
        {
            buscarPalabrasDB(0, 0, linS, colS, 0, 0, 0);
        }
        if(enc)
        {
            int e3 = eee.length();
            int e2 = 0;
            int pos;
            for(int y = e3; y > -1; y--)
            {
                if(eee[y] == '(')
                {
                    e2++;
                }
                if(e2 == cant)
                {
                    pos = y;
                    break;
                }
            }
            string e4 = eee.substr(pos);
            cout<<e4<<endl;
            encontrados[kkk] = e4;
            kkk++;
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

bool estaSopa(string a)
{
    for(int p = 0; p < contVect2; p++)
    {
        if(encontrados[p].find(a) != string::npos)
        {
            return true;
        }
    }
    return false;
}

bool estaPin(string a)
{
    for(int p = 0; p < contVect2; p++)
    {
        if(pintados[p] == a)
        {
            return true;
        }
    }
    return false;
}

void graficarSopa()
{
    ofstream arc;
    string colores[50] = {"red", "pink", "orange", "yellow", "magenta", "green", "blue", "purple", "gray", "maroon","red", "pink", "orange", "yellow", "magenta", "green", "blue", "purple", "gray", "maroon","red", "pink", "orange", "yellow", "magenta", "green", "blue", "purple", "gray", "maroon","red", "pink", "orange", "yellow", "magenta", "green", "blue", "purple", "gray", "maroon","red", "pink", "orange", "yellow", "magenta", "green", "blue", "purple", "gray", "maroon"};
    int **clr;
    clr = new int*[linS];
    pintados = new string[linS*colS];
    for(int i = 0; i < linS; i++)
    {
        clr[i] = new int[colS];
    }
    kkk = 0;
    for(int i = 0; i < linS; i++)
    {
        for(int j = 0; j < colS; j++)
        {
            string ii = to_string(i);
            string jj = to_string(j);
            if(estaSopa("(" + ii + "," + jj + ")"))
            {
                clr[i][j] = 1;
            }
            else
            {
                clr[i][j] = 0;
            }
        }
    }


    arc.open("sopa.dot", ios::out);
    arc<<"digraph G { table [ shape = plaintext label=<<table>"<<endl;
    cout<<"digraph G { table [ shape = plaintext label=<<table>"<<endl;
    for(int i = 0; i < linS; i++)
    {
        arc<<"<tr>"<<endl;
        cout<<"<tr>"<<endl;
        for(int j = 0; j < colS; j++)
        {
            string ii = to_string(i);
            string jj = to_string(j);
            if(clr[i][j] == 1)
            {
                for(int a = 0; a < contVect2; a++)
                {
                    int aux = a;
                    if(aux > 9)
                    {
                        aux = aux - 10;
                    }
                    string jeje = "(" + ii + "," + jj + ")";
                    if(encontrados[a].find(jeje) != string::npos && !estaPin(jeje))
                    {
                        arc<<"<td bgcolor=\""+ colores[aux] + "\">" + sopa[i][j] + "</td>";
                        pintados[kkk] = jeje;
                        kkk++;
                    }
                }
                //idcolor++;
            }
            else
            {
                arc<<"<td>" + sopa[i][j] + "</td>";
            }
        }
        arc<<"</tr>"<<endl;
        cout<<"</tr>"<<endl;
    }
    arc<<"</table>>];}"<<endl;
    cout<<"</table>>];}"<<endl;
    arc.close();

    system("dot -Tjpg sopa.dot -o sopa.jpg");
    system("start sopa.jpg");
}


