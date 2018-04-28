#include<stdio.h>
#include<math.h>
void look(int a[], int n)
{
    int t=0,i,j,temp,head,pos;
    printf("assuming start and end as 0 and 200 and a decreasing order of access\n");
    head=a[0];
    for(i=0;i<=n;i++)
    {
        for(j=0;j<=n-i-1;j++)
        {
            if(a[j]>a[j+1])
            {
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
            }
        }
    }
    //look for head
    for(i=0;i<=n;i++)
        if(a[i]==head)
            pos=i;
    printf("processing order che ");
    for(j=pos-1;j>=0;j--)
    {
        t=t+abs(a[j]-a[j+1]);
        printf("%d  ",a[j]);
    }
    t=t+abs(a[0]-a[pos+1]);
    for(j=pos+1;j<n;j++)
    {
        t=t+abs(a[j]-a[j+1]);
        printf("%d  ",a[j]);
    }
    printf("%d ",a[j]);
    printf("t ka value is %d ",t);
}
int main()
{
    int i,j,k,a[10]={100,27,129,110,186,147,41,10,64,120},n=9;
    printf("\nLOOK");
    look(a,n);
    return 0;
}