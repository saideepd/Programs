#include<stdio.h>
#include<math.h>
#include<string.h>

char prior[]={'^','*','/','+','-','\0'};
char x='A';

void AC3(char a[30], int j)
{
    int i,k;
    printf("%c = %c%c%c\n",x,a[j-1],a[j],a[j+1]);
    for(i=j+1;i<=strlen(a);++i)
        a[i-2]=a[i];
    a[j-1]=x;
    x++;
}

void main()
{
    int i,j,k,flag;
    char a[30];
    clrscr();
    printf("Enter the string: ");
    scanf("%s",a);
    for(i=0;i<strlen(prior);++i)
    {
	flag=0;
	for(j=0;j<strlen(a);++j)
	{
	    if(prior[i]==a[j])
	    {
		while(j<strlen(a) && prior[i]==a[j+2])
		{
			j+=2;
			flag=1;
		}
		AC3(a,j);
	    }
	}
	if(flag==1)
	    i--;
    }
    printf("%c = %c", a[0],--x);
    getch();
}
/*Enter the string: x=m+n-z^y
A = z^y
B = m+n
C = B-A
x = C*/