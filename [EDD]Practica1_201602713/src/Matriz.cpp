#include "Matriz.h"
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

Matriz::Matriz()
{
    //ctor
}

Matriz::~Matriz()
{
    //dtor
}

string rutaMatriz;
int linM = 0;
double deter;
double **matriz;

double det(double **m, int b);

void fillinMatriz(string rm)
{
    ifstream arch(rm);
    linM = 0;
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
            linM++;
        }
        arch.close();
    }

    int contVect = 0;
    matriz = new double*[linM];
    for(i = 0; i < linM; i++)
    {
        matriz[i] = new double[linM];
    }
    for(i = 0; i < linM; i++)
    {
        for(j = 0; j < linM; j++)
        {
            matriz[i][j] = vect.at(contVect);
            contVect++;
        }
    }

    for(i = 0; i < linM; i++)
    {
        for(j = 0; j < linM; j++)
        {
            cout<<"  ["<<matriz[i][j]<<"]";
        }
        cout<<"\n";
    }
}

void cargarMatriz()
{
    cout<<"\n   Escriba la ruta:"<<endl;
    cin>>rutaMatriz;

    fillinMatriz(rutaMatriz);
}

double det(double **m, int b)
{
   double determinante = 0, aux = 0;
   int c;
   if(b==2)
      return m[0][0]*m[1][1] - m[1][0]*m[0][1];
   else
   {
      for(int j=0; j < b; j++)
      {
         double **menor=(double **)malloc(sizeof(double)*(b-1));
         for(int h=0; h < (b-1); h++)
             menor[h] = (double *)malloc(sizeof(double)*(b-1));
         for(int k=1; k < b; k++)
         {
             c = 0;
             for(int l=0; l < b; l++)
             {
                 if(l!=j)
                 {
                     menor[k-1][c] = m[k][l];
                     c++;
                 }
             }
          }
          aux = pow(-1, 2+j)*m[0][j]*det(menor, b-1);
          determinante += aux;
          for(int q = 0; q < (b-1); q++)
               free(menor[q]);
          free(menor);
      }
      return determinante;
   }
}

void calcularDet()
{
    deter = det(matriz, linM);
    cout<<"\n   El determinante es:"<<deter<<endl;
}

void graficarMatriz()
{
    ofstream arc;
    arc.open("matriz.dot", ios::out);
    arc<<"digraph G { table [ shape = plaintext label=<<table>"<<endl;
    for(int i = 0; i < linM; i++)
    {
        arc<<"<tr>"<<endl;
        for(int j = 0; j < linM; j++)
        {
            double k = matriz[i][j];
            int l = (int) k;
            string varAsString = to_string(l);
            arc<<"<td>" + varAsString + "</td>";
        }
        arc<<"</tr>"<<endl;
    }
    arc<<"</table>>];}"<<endl;
    arc.close();

    system("dot -Tjpg matriz.dot -o matriz.jpg");
    system("start matriz.jpg");
}

void graficarMatrizTranspuesta()
{
    ofstream arc;
    arc.open("matrizT.dot", ios::out);
    arc<<"digraph G { table [ shape = plaintext label=<<table>"<<endl;
    for(int i = 0; i < linM; i++)
    {
        arc<<"<tr>"<<endl;
        for(int j = 0; j < linM; j++)
        {
            double k = matriz[i][j];
            int l = (int) k;
            string varAsString = to_string(l);
            arc<<"<td>" + varAsString + "</td>";
        }
        arc<<"</tr>"<<endl;
    }
    arc<<"</table>>];"<<endl;
    arc<<"table2 [ shape = plaintext label=<<table>"<<endl;
    for(int i = 0; i < linM; i++)
    {
        arc<<"<tr>"<<endl;
        for(int j = 0; j < linM; j++)
        {
            double k = matriz[j][i];
            int l = (int) k;
            string varAsString = to_string(l);
            arc<<"<td>" + varAsString + "</td>";
        }
        arc<<"</tr>"<<endl;
    }
    arc<<"</table>>];"<<endl;
    arc<<"table->table2}"<<endl;
    arc.close();

    system("dot -Tjpg matrizT.dot -o matrizT.jpg");
    system("start matrizT.jpg");
}
