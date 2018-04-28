#include<stdio.h>
int main()
{
      int frames[10], temp[10], pages[10];
      int tpages, m, n, pos, k, l, tframes;
      int a = 0, b = 0, page_fault = 0;
      printf("\nEnter Total Number of Pages:\t");
      scanf("%d", &tpages);
      printf("\nEnter Values for String:\n");
      for(m = 0; m < tpages; m++)
      {
	    printf("Value %d:  ", m + 1);
	    scanf("%d", &pages[m]);
      }
      printf("\nEnter Total Number of Frames:\t");
      scanf("%d", &tframes);
      for(m = 0; m < tframes; m++)
      {
	    frames[m] = -1;
      }
      for(n = 0; n < tpages; n++)
      {
	    a = 0, b = 0;
	    for(m = 0; m < tframes; m++)
	    {
		  if(frames[m] == pages[n])
		  {
			a = 1;
			b = 1;
			break;
		  }
	    }
	    if(a == 0)
	    {
		  for(m = 0; m < tframes; m++)
		  {
			if(frames[m] == -1)
			{
			      frames[m] = pages[n];
			      b = 1;
			      page_fault++;
			      break;
			}
		  }
	    }
	    if(b == 0)
	    {
		  for(m = 0; m < tframes; m++)
		  {
			temp[m] = 0;
		  }
		  for(k = n - 1, l = 1; l <= tframes - 1; l++, k--)
		  {
			for(m = 0; m < tframes; m++)
			{
			      if(frames[m] == pages[k])
			      {
				    temp[m] = 1;
			      }
			}
		  }
		  for(m = 0; m < tframes; m++)
		  {
			if(temp[m] == 0)
			pos = m;
		  }
		  frames[pos] = pages[n];
		  page_fault++;
	    }
	    printf("\n");
	    for(m = 0; m < tframes; m++)
	    {
		  printf("%d\t", frames[m]);
	    }
    }
    printf("\n\nTotal Page Faults:\t%d\n", page_fault);
    printf("Hit Ratio: \t\t%.2f\n",1-(page_fault*1.0)/tpages);
    printf("Miss Ratio: \t\t%.2f\n",(page_fault*1.0)/tpages);
    return 0;
}

/*
Output:

Enter Total Number of Pages:    5

Enter Values for String:
Value 1:  4
Value 2:  1
Value 3:  2
Value 4:  4
Value 5:  5

Enter Total Number of Frames:   3

4       -1      -1
4       1       -1
4       1       2
4       1       2
4       5       2

Total Page Faults:      4
Hit Ratio:              0.20
Miss Ratio:             0.80
*/