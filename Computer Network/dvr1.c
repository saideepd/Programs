//DVR
#include <stdio.h>

int d[10][10], via[10][10];
 
int main()
{
  int i,j, k, n, g[10][10];
   
  printf("\nEnter the no of nodes: ");
  scanf("%d", &n);
    
  for(i=0; i<n; i++)
  {
    printf("Enter the record for Router %c: \n", i+97);
    for(j=0; j<n; j++)
    {
      printf("(%c -> %c) = ", i+97, j+97);
      scanf("%d", &g[i][j]);
      if(g[i][j] != 999)
        d[i][j] = 1;
    }
  }
   
  for(i=0; i<n; i++)
    for(j=0; j<n;j++)
      via[i][j] = i;
   
  for(i=0; i<n; i++)
  {
    for(j=0; j<n; j++)
      if(d[i][j] == 1)
         for(k=0; k<n; k++)
            if(g[i][j] + g[j][k] < g[i][k])
            {
              g[i][k] = g[i][j] + g[j][k];
              via[i][k] = j;
            }
  }
    
  for(i=0; i<n; i++)
  {
    printf("For Router %c :\n",i+97);
    for(j = 0; j<n;j++)
      printf("Distance to %c via %c : %d \n", j+97, via[i][j]+ 97, g[i][j]);
  }
  return 0;
}

/*
Output:

Enter the no of nodes: 3
Enter the record for Router a:
(a -> a) = 0
(a -> b) = 2
(a -> c) = 7
Enter the record for Router b:
(b -> a) = 2
(b -> b) = 0
(b -> c) = 1
Enter the record for Router c:
(c -> a) = 7
(c -> b) = 1
(c -> c) = 0
For Router a :
Distance to a via a : 0
Distance to b via a : 2
Distance to c via b : 3
For Router b :
Distance to a via b : 2
Distance to b via b : 0
Distance to c via b : 1
For Router c :
Distance to a via b : 3
Distance to b via c : 1
Distance to c via c : 0
*/