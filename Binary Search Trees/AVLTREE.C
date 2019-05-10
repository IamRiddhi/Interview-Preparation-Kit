/*
    Generation of an AVL tree and some of its funcitons
*/

#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <windows.h>
#define  LH   1        /* Left Higher, Balance Factor = 1 (/) */
#define  RH  -1        /* Right Higher, Balance Factor = -1 (\) */
#define  EH   0        /* Equal Height, Balance Factor = 0 (-) */

#define  GAPS 2        /* Printed width of each key */

void clrscr(void)
{
   system("cls") ;
}

void gotoxy(short x, short y)
{
	COORD pos = {x, y};
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);
}

typedef struct avlTree
{
    int key ;
    int bf  ;
    struct avlTree *left ;
    struct avlTree *right ;
} avlTree ;


avlTree *createNode(int k)
{
    avlTree *t ;

    t = (avlTree *) malloc(sizeof(avlTree)) ;
    t->left = t->right = NULL ;
    t->bf = EH ;
    t->key = k ;

    return t ;
}


void setLeft(avlTree *root, int k)
{
    root->left = createNode(k) ;
}

void setRight(avlTree *root, int k)
{
    root->right = createNode(k) ;
}


avlTree *insertKey(avlTree *root, int k)
{
    avlTree *p, *q, *s ;
    int qBF ;

    if(root == NULL)
        return createNode(k) ;

    if(k == root->key)
	   return root ;

    p = root ;
    if(k < p->key)                 /* The key may be in the left subtree */
    {
	   if(p->left == NULL)           /* Left subtree is empty */
	   {
		  p->left = createNode(k) ;  /* Add new node on the left */
		  p->bf ++ ;                 /* and make its left more higher */
	   }
	   else                          /* Non-empty left subtree */
	   {
		  qBF = p->left->bf ;               /* Save BF (Balance Factor) of its left child */
		  p->left = insertKey(p->left, k) ; /* and recursively insert the key in its left subtree */
		  q = p->left ;                     /* Point the the root of its left subtree */
          if(q->bf != EH && q->bf != qBF)   /* If BF if left subtree changes it is not equihigh after insertion */
          {
    		  if(p->bf == LH)           /* Tree rooted to at parent p was already left higher */
    		  {
    			 if(q->bf == LH)        /* and the left child has also become left heigher */
    			 /* Case : Left of Left  (needs single rotation) */
    			 {
    				/* Right rotate q around p */
    				p->left = q->right ;
    				q->right = p ;
    				q->bf = p->bf = EH ;
    				p = q ;
    			 }
    			 else if(q->bf == RH)      /* but if the left child has become right heigher */
    			 /* Case : Right of Left  (needs double rotations) */
    			 {
    				s = q->right ;
    				/* Left rotate s around q */
    				q->right = s->left ;
    				s->left = q ;

    				/* Right rotate s around p */
    				p->left = s->right ;
    				s->right = p ;

    				/* Adjust the balance factors */
    				if(s->bf == EH)
    				    p->bf = q->bf = EH ;
    				else if(s->bf == LH)
    				{
    				    p->bf = RH ;
    				    q->bf = EH ;
    				}
    				else      /* s->bf == RH */
    				{
    				    p->bf = EH ;/* but if the left child has become right heigher */
    				    q->bf = LH ;
    				}

    				s->bf = EH ;
    				p = s ;
    			 }
    		  }
              else
                 p->bf ++ ;               /* Update root's BF */
            }
	   }
    }
    else                 /* if(k > root->key) The key may be in the right subtree */
    {
	   if(p->right == NULL)           /* Right subtree is empty */
	   {
		  p->right = createNode(k) ;  /* Add new node on the right */
		  p->bf -- ;                  /* and make its right more higher */
	   }
	   else                          /* Non-empty right subtree */
        {/* but if the left child has become right heigher */
		    qBF = p->right->bf ;                  /* Save BF (Balance Factor) of its right child */
            p->right = insertKey(p->right, k) ;   /* and recursively insert the key in its right subtree */
            q = p->right ;                       /* Point the the root of its left subtree */
            if(q->bf != EH && q->bf != qBF) /* If BF if right subtree changes it is not equihigh after insertion */
            {
                if(p->bf == RH)          /* Tree rooted to at parent p was already right higher */
                {
                    if(q->bf == RH)      /* and the right child has also become right heigher */
                    /* Case : Right of Right  (needs single rotation) */
                    {
                        /* Left rotate q around p */
                        p->right = q->left ;
                        q->left = p ;
                        q->bf = p->bf = EH ;
                        p = q ;/* but if the left child has become right heigher */
                    }
                    else if(q->bf == LH)      /* but if the right child has become left heigher */
                    /* Case : Left of Right  (needs double rotations) */
                    {
                        s = q->left ;
                        /* Right rotate s around q */
                        q->left = s->right ;
                        s->right = q ;
/* but if the left child has become right heigher */
                        /* Left rotate s around p */
                        p->right = s->left ;
                        s->left = p ;

                        /* Adjust the balance factors */
                        if(s->bf == EH)
                            p->bf = q->bf = EH ;
                        else if(s->bf == LH)
                        {
                            p->bf = EH ;
                            q->bf = RH ;
                        }
                        else      /* s->bf == RH */
                        {
                            p->bf = LH ;
                            q->bf = EH ;
                        }
/* but if the left child has become right heigher */
                        p = s ;
                    }/* but if the left child has become right heigher */
                }
                else
                    p->bf -- ;              /* Update root's BF */
            }
        }
    }

    return p ;
}

avlTree *deleteKey(avlTree *root, int k)
{
    avlTree *p, *q, *s ;
    int qBF ;

    if(root == NULL)
        return NULL ;

    p = root ;
    if(k < p->key)                        /* The key may be in the left subtree */
    {
        if(p->left == NULL)
            return p ;

        qBF = p->left->bf ;               /* Save BF (Balance Factor) of its left child */
        p->left = deleteKey(p->left, k) ; /* and recursively delete the key in its left subtree */

        if(p->left == NULL)
          p->bf -- ;
        else if(q->bf == EH && q->bf != qBF)   /* If BF of left subtree changes and has become equihigh after deletion */
        {
          q = p->right ;            /* Make q point to the right child of p */
          if(p->bf == RH)           /* Tree rooted to at parent p was already right higher */
          {
             if(q->bf == RH)        /* and the right child is also right heigher */
             /* Case : Right of Right  (needs single rotation) */
             {
                /* left rotate q around p */
                p->right = q->left ;
                q->left = p ;
                q->bf = p->bf = EH ;
                p = q ;
             }
             else if(q->bf == RH)      /* but if the right child is left heigher */
             /* Case : Left of Right  (needs double rotations) */
             {
                s = q->left ;
                /* Right rotate s around q */
                q->left = s->right ;
                s->right = q ;

                /* Left rotate s around p */
                p->right = s->left ;
                s->left = p ;

                /* Adjust the balance factors */
                if(s->bf == EH)
                    p->bf = q->bf = EH ;
                else if(s->bf == LH)
                {
                    p->bf = EH ;
                    q->bf = RH ;
                }
                else      /* s->bf == RH */
                {
                    p->bf = LH ;/* but if the left child has become right heigher */
                    q->bf = EH ;
                }

                s->bf = EH ;
                p = s ;
             }
          }
          else
             p->bf -- ;               /* Update root's BF */
        }
    }
    else if(k > p->key)                        /* The key may be in the right subtree */
    {
        if(p->right == NULL)
            return p ;


          /* Now delete the key from the right subtree */
          qBF = p->right->bf ;              /* Save BF (Balance Factor) of its right child */
          p->right = deleteKey(p->right, k) ; /* and recursively delete the key in its right subtree */

          if(p->right == NULL)                /* If after deletion of the key the whole right subtree gets deleted */
             p->bf ++ ;                       /*  then make it more right higher */
          else if(q->bf == EH && q->bf != qBF)   /* If BF of right subtree changes and has become equihigh after deletion */
          {
              q = p->left ;            /* Make q point to the left child of p */
              if(p->bf == LH)           /* Tree rooted to at parent p was already left higher */
              {
                 if(q->bf == LH)        /* and the left child is also left heigher */
                 /* Case : Left of Left  (needs single rotation) */
                 {
                    /* right rotate q around p */
                    p->left = q->right ;
                    q->right = p ;
                    q->bf = p->bf = EH ;
                    p = q ;
                 }
                 else if(q->bf == RH)      /* but if the left child is right heigher */
                 /* Case : Right of Left  (needs double rotations) */
                 {
                    s = q->right ;
                    /* Left rotate s around q */
                    q->right = s->left ;
                    s->left = q ;

                    /* Right rotate s around p */
                    p->left = s->right ;
                    s->right = p ;

                    /* Adjust the balance factors */
                    if(s->bf == EH)
                        p->bf = q->bf = EH ;
                    else if(s->bf == LH)
                    {
                        p->bf = EH ;
                        q->bf = LH ;
                    }
                    else      /* s->bf == RH */
                    {
                        p->bf = RH ;/* but if the left child has become right heigher */
                        q->bf = EH ;
                    }

                    s->bf = EH ;
                    p = s ;
                 }
              }
              else
                 p->bf ++ ;               /* Update root's BF */
            }
        }
        else           // p->key == k     /* Root itself contains the key */
        {
            if(p->left == NULL)           // if left child is empty
                p = p->right ;            /*  then right child (with only one node) will be the new parent */
            else if(p->right == NULL)     // if right child is empty
                p = p->left ;             /*  then left child (with only one node) will be the new parent */
            else                          // If root has both the non-empty left and right children
            {
                /* Go to the inorder successor of root */
                s = p->right ;
                while(s->left != NULL)
                    s = s->left ;
                int tempKey = s->key ;     // Save key of the successor
                p = deleteKey(p, tempKey) ; /* Delete that inorder successor node */
                p->key = tempKey ;          /* Now copy the key in the successor to the root */

                return p ;
            }

            free(root) ;
        }

    return p ;
}



avlTree *insertKeyUnBalanced(avlTree *root, int k)
{
    avlTree *tmp ;

    if(root == NULL)
        return createNode(k) ;

    /* Search for the key */
    tmp = root ;

    while(1)
    {
        if(tmp->key == k)
            break ;

        if(k < tmp->key)
        {
            if(tmp->left != NULL)
                tmp = tmp->left ;
            else
            {
                tmp->left = createNode(k) ;
                break ;
            }
        }
        else
        {
            if(tmp->right != NULL)
                tmp = tmp->right ;
            else
            {
                tmp->right = createNode(k) ;
                break ;
            }
        }
    }

    return root ;
}

/* Display the AVL Tree at the co-ordinate of (x, y) of the screen
   Returns widh of the tree that it has taken to print
*/
void display(avlTree *root, int jumps)
{
    int i ;

    /* Print Margin of jumps * GAPS spaces */
    for(i = (jumps-1) * GAPS ; i >= 1 ; i --)
        putchar(' ') ;

    if(root != NULL)
    {
        printf("ÀÄÄ%d\n", root->key) ;
        jumps ++ ;
        display(root->left, jumps) ;
        display(root->right, jumps) ;
    }
    else
       puts("ÀÄÄ#") ;

}

int show(avlTree *root, int x, int y, int *w, int *h)
{
    int lw, rw ;           /* Widths  of left and right subtrees */
    int lh, rh ;           /* Heights of left and right subtrees */
    int i, leftX, rightX ;

    if(root == NULL)
	   *w = *h = 0 ;
    else
    {
	   /* Print left subtree */
	   leftX = show(root->left, x, y+1, w, h) ;
	   lw = *w ;
	   lh = *h ;

	   /* Print right subtree */
	   rightX = show(root->right, x + lw + GAPS, y+1, w, h) ;
	   rw = *w ;
	   rh = *h ;

	   /* Print the root node */
	   x += lw ;
	   gotoxy(x, y) ;
	   printf("%-*d", GAPS, root->key) ;


	   /* Print graphical line for the left subtree */
	   if(lw > 0)
	   {
		 gotoxy(leftX, y) ; putchar('Ú') ;
		 for(i = leftX+1 ; i < x ; i ++)
		 {
		    gotoxy(i, y) ;
		    putchar('Ä') ;
		 }
	   }

	   /* Print graphical line for the right subtree */
	   if(rw > 0)
	   {
		 for(i = x + GAPS ; i <= rightX ; i ++)
		 {
		    gotoxy(i, y) ;
		    putchar('Ä') ;
		 }
		 gotoxy(rightX, y) ; putchar('¿') ;
	   }


	   *w = lw + rw + GAPS;
	   *h = (lh > rh ? lh : rh) + 1 ;
    }

    return x ;
}

void insertAndDisplay(avlTree **root, int key)
{
   int y, w, h ;

   clrscr() ;

   printf("Before :-") ;/*  then right child (with only one node) will be the new parent */
   y = 2 ;
   show(*root, 1, y, &w, &h) ;
   y += h+1 ;
   gotoxy(1, y) ;

   printf("After  insertion of %d :-", key) ;
   *root = insertKey(*root, key) ;
   show(*root, 1, y+1, &w, &h) ;
   y += h+2 ;
   gotoxy(1, y) ;

   getch() ;
}

void deleteAndDisplay(avlTree **root, int key)
{
   int y, w, h ;

   clrscr() ;

   printf("Before :-") ;
   y = 2 ;
   show(*root, 1, y, &w, &h) ;
   y += h+1 ;
   gotoxy(1, y) ;

   printf("After  deletion of %d :-", key) ;
   *root = deleteKey(*root, key) ;
   show(*root, 1, y+1, &w, &h) ;
   y += h+2 ;
   gotoxy(1, y) ;

   getch() ;
}

/*
int main(void)
{
    avlTree *tree = NULL ;
    int keys[] = {50, 60, 90, 80, 70, 20, 10, 40, 30} ;
    int nKeys = sizeof(keys) / sizeof(keys[0]) ;   // Number of Keys
    int i, x, y, w, h ;

    clrscr() ;
    for(i = 0 ; i < nKeys ; i ++)
    {
	   printf("Insert %d:-\n", keys[i]) ;
	   tree = insertKey(tree, keys[i]) ;
	   x = wherex() ;
	   y = wherey() ;
	   show(tree, x, y, &w, &h) ;
	   gotoxy(1, y+h) ;
	   putchar('\n') ;
    }

    getch() ;

    return 0 ;
}
*/


int main(void)
{
    avlTree *tree = NULL ;
    int keys[] = {10, 24, 11, 31, 16, 26, 29, 20, 7, 5, 9, 3, 17, 8, 22, 33, 25} ;
    int nKeys = sizeof(keys) / sizeof(keys[0]) ;   // Number of Keys
    int i, x, y, w, h ;
    for(i = 0 ; i < nKeys ; i ++)
//        tree = insertKey(tree, keys[i]) ;
	   insertAndDisplay(&tree, keys[i]) ;

    int dkeys[] = {8, 10, 22, 25, 31, 29, 24} ;
    nKeys = sizeof(dkeys) / sizeof(dkeys[0]) ;   // Number of Keys


    for(i = 0 ; i < nKeys ; i ++)
	   deleteAndDisplay(&tree, dkeys[i]) ;

    return 0 ;
}


/*
int main(void)
{
    avlTree *tree = NULL ;
    int keys[] = {10, 24, 11, 31, 16, 26, 29, 20, 7, 5, 9} ;
    int nKeys = sizeof(keys) / sizeof(keys[0]) ;   // Number of Keys
    int i, x, y, w, h ;

    clrscr() ;
    for(i = 0 ; i < nKeys ; i ++)
    {
	   printf("Insert %d:-\n", keys[i]) ;
	   tree = insertKey(tree, keys[i]) ;
	   x = wherex() ;
	   y = wherey() ;
	   show(tree, x, y, &w, &h) ;
	   gotoxy(1, y+h) ;
	   putchar('\n') ;
	   getch() ;
    }


//  display(tree, 1) ;

    getch() ;

    return 0 ;
}
*/



