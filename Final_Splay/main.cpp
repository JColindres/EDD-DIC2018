#include <stdio.h>
#include <math.h>
#include <string.h>
#include <time.h>
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <list>
#include <string>
#include <algorithm>
#include <queue>
#include <stack>
#include <set>
#include <map>
#include <complex>

using namespace std;

typedef long long lld;
typedef unsigned long long llu;
string resultado = "";

struct TreeNode
{
    int key;
    TreeNode* parent;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int key)
    {
        this -> key = key;
        this -> parent = NULL;
        this -> left = NULL;
        this -> right = NULL;
    }
};

class SplayTree
{
    TreeNode *root;

    void zig(TreeNode*);
    void zig_zig(TreeNode*);
    void zig_zag(TreeNode*);

    void splay(TreeNode*);

public:
    SplayTree();
    SplayTree(TreeNode*);
    TreeNode* buscar(int);
    void insertar(int);
    void eliminar(int);
    void generarImagen();
};

void SplayTree::zig(TreeNode *x)
{
    TreeNode *p = x -> parent;
    if (p -> left == x)
    {
        TreeNode *B = x -> right;

        x -> parent = NULL;
        x -> right = p;

        p -> parent = x;
        p -> left = B;

        if (B != NULL) B -> parent = p;
    }
    else
    {
        TreeNode *B = x -> left;

        x -> parent = NULL;
        x -> left = p;

        p -> parent = x;
        p -> right = B;

        if (B != NULL) B -> parent = p;
    }
}

void SplayTree::zig_zig(TreeNode *x)
{
    TreeNode *p = x -> parent;
    TreeNode *g = p -> parent;
    if (p -> left == x)
    {
        TreeNode *B = x -> right;
        TreeNode *C = p -> right;

        x -> parent = g -> parent;
        x -> right = p;

        p -> parent = x;
        p -> left = B;
        p -> right = g;

        g -> parent = p;
        g -> left = C;


        if (x -> parent != NULL)
        {
            if (x -> parent -> left == g) x -> parent -> left = x;
            else x -> parent -> right = x;
        }

        if (B != NULL) B -> parent = p;

        if (C != NULL) C -> parent = g;
    }
    else
    {
        TreeNode *B = p -> left;
        TreeNode *C = x -> left;

        x -> parent = g -> parent;
        x -> left = p;

        p -> parent = x;
        p -> left = g;
        p -> right = C;

        g -> parent = p;
        g -> right = B;

        if (x -> parent != NULL)
        {
            if (x -> parent -> left == g) x -> parent -> left = x;
            else x -> parent -> right = x;
        }

        if (B != NULL) B -> parent = g;

        if (C != NULL) C -> parent = p;
    }
}

void SplayTree::zig_zag(TreeNode *x)
{
    TreeNode *p = x -> parent;
    TreeNode *g = p -> parent;
    if (p -> right == x)
    {
        TreeNode *B = x -> left;
        TreeNode *C = x -> right;

        x -> parent = g -> parent;
        x -> left = p;
        x -> right = g;

        p -> parent = x;
        p -> right = B;

        g -> parent = x;
        g -> left = C;

        if (x -> parent != NULL)
        {
            if (x -> parent -> left == g) x -> parent -> left = x;
            else x -> parent -> right = x;
        }

        if (B != NULL) B -> parent = p;

        if (C != NULL) C -> parent = g;
    }
    else
    {
        TreeNode *B = x -> left;
        TreeNode *C = x -> right;

        x -> parent = g -> parent;
        x -> left = g;
        x -> right = p;

        p -> parent = x;
        p -> left = C;

        g -> parent = x;
        g -> right = B;

        if (x -> parent != NULL)
        {
            if (x -> parent -> left == g) x -> parent -> left = x;
            else x -> parent -> right = x;
        }

        if (B != NULL) B -> parent = g;

        if (C != NULL) C -> parent = p;
    }
}

void SplayTree::splay(TreeNode *x)
{
    while (x -> parent != NULL)
    {
        TreeNode *p = x -> parent;
        TreeNode *g = p -> parent;
        if (g == NULL) zig(x);
        else if (g -> left == p && p -> left == x) zig_zig(x);
        else if (g -> right == p && p -> right == x) zig_zig(x);
        else zig_zag(x);
    }
    this -> root = x;
}

SplayTree::SplayTree()
{
    this -> root = NULL;
}

SplayTree::SplayTree(TreeNode *rt)
{
    this -> root = rt;
}

TreeNode* SplayTree::buscar(int x)
{
    TreeNode *ret = NULL;
    TreeNode *curr = this -> root;
    TreeNode *prev = NULL;
    while (curr != NULL)
    {
        prev = curr;
        if (x < curr -> key) curr = curr -> left;
        else if (x > curr -> key) curr = curr -> right;
        else
        {
            ret = curr;
            break;
        }
    }
    if (ret != NULL) splay(ret);
    else if (prev != NULL) splay(prev);
    return ret;
}

void SplayTree::insertar(int x)
{
    if (root == NULL)
    {
        root = new TreeNode(x);
        return;
    }
    TreeNode *curr = this -> root;
    while (curr != NULL)
    {
        if (x < curr -> key)
        {
            if (curr -> left == NULL)
            {
                TreeNode *newNode = new TreeNode(x);
                curr -> left = newNode;
                newNode -> parent = curr;
                splay(newNode);
                return;
            }
            else curr = curr -> left;
        }
        else if (x > curr -> key)
        {
            if (curr -> right == NULL)
            {
                TreeNode *newNode = new TreeNode(x);
                curr -> right = newNode;
                newNode -> parent = curr;
                splay(newNode);
                return;
            }
            else curr = curr -> right;
        }
        else
        {
            splay(curr);
            return;
        }
    }
}

TreeNode* subtree_max(TreeNode *subRoot)
{
    TreeNode *curr = subRoot;
    while (curr -> right != NULL) curr = curr -> right;
    return curr;
}

TreeNode* subtree_min(TreeNode *subRoot)
{
    TreeNode *curr = subRoot;
    while (curr -> left != NULL) curr = curr -> left;
    return curr;
}

void SplayTree::eliminar(int x)
{
    TreeNode *del = buscar(x);
    if (del == NULL)
    {
        return;
    }
    TreeNode *L = del -> left;
    TreeNode *R = del -> right;
    if (L == NULL && R == NULL)
    {
        this -> root = NULL;
    }
    else if (L == NULL)
    {
        TreeNode *M = subtree_min(R);
        splay(M);
    }
    else if (R == NULL)
    {
        TreeNode *M = subtree_max(L);
        splay(M);
    }
    else
    {
        TreeNode *M = subtree_max(L);
        splay(M);
        M -> right = R;
        R -> parent = M;
    }
    delete del;
}

void graficar(TreeNode *r)
{
    if(r != NULL)
    {
        if(r ->left != NULL)
        {
            resultado = resultado + to_string(r -> left -> key) + ";\n";
            resultado = resultado + to_string(r -> key) + " -> " + to_string(r -> left -> key) + ";\n";
        }
        if(r ->right != NULL)
        {
            resultado = resultado + to_string(r -> right -> key) + ";\n";
            resultado = resultado + to_string(r -> key) + " -> " + to_string(r -> right -> key) + ";\n";
        }
        graficar(r->left);
        graficar(r->right);
    }
}

void printTree(TreeNode *root)
{
    if (root != NULL)
    {
        ofstream arc;
        arc.open("splay.dot", ios::out);
        resultado = resultado + "digraph G { \n node[color = \"orange\";style = filled]\n";
        if(root != NULL)
        {
            resultado = resultado + to_string(root -> key) + ";\n";
            graficar(root);
        }
        resultado = resultado + "}";
        arc<<resultado<<endl;
        arc.close();

        system("dot -Tjpg splay.dot -o splay.jpg");
        system("start splay.jpg");
    }
    else
    {
        cout<<" El arbol esta vacio"<<endl;
    }
}

void SplayTree::generarImagen()
{
    printTree(this -> root);
}

int main()
{
    SplayTree *splay = new SplayTree();
    splay -> generarImagen();
    splay -> insertar(100);
    splay -> insertar(45);
    splay -> insertar(5);
    splay -> insertar(13);
    splay -> insertar(80);
    splay -> insertar(30);
    splay -> insertar(20);
    splay -> insertar(10);
    splay -> insertar(46);
    //splay -> generarImagen();
    splay -> eliminar(46);
    splay -> generarImagen();
    return 0;
}






