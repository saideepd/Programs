#include<stdio.h>

int main()
{
    int reference_string[10], page_faults = 0, m, n, s, pages, frames=3, i;
    int temp[3];
   
    printf("\nEnter Total Number of Pages:\t");
    scanf("%d", &pages);
    printf("\nEnter values of Reference String:\n");
    for(m = 0; m < pages; m++)
    {
		printf("Value %d:  ", m + 1);
		scanf("%d", &reference_string[m]);
    }
    printf("\nEnter Total Number of Frames:\t");
	scanf("%d", &frames);

    for(m = 0; m < frames; m++)
    {
		temp[m] = -1;
    }
    for(m = 0; m < pages; m++)
    {
		s = 0;
		for(n = 0; n < frames; n++)
		{
		    if(reference_string[m] == temp[n])
		    {
			    s++;
			    page_faults--;
		    }
		}
		page_faults++;
		if((page_faults <= frames) && (s == 0))
		{
		    temp[m] = reference_string[m];
		}
		else if(s == 0)
		{
		    temp[(page_faults - 1) % frames] = reference_string[m];
		}
		printf("\n");
		for(n = 0; n < frames; n++)
		{
		    printf("%d\t", temp[n]);
		}
    }
    printf("\n\nTotal Page Faults:\t%d\n", page_faults);
    printf("Hit Ratio: \t\t%.2f\n",1-(page_faults*1.0)/pages);
    printf("Miss Ratio: \t\t%.2f\n",(page_faults*1.0)/pages);
    return 0;
}

/*
Ouptut:

Enter Total Number of Pages:    5

Enter values of Reference String:
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
5       1       2
Total Page Faults:      4
Hit Ratio:              0.20
Miss Ratio:             0.80
*/