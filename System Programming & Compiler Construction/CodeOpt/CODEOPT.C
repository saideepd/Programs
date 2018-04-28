#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
int global,i;

void StrengthReduction()
{
	char operator,equal,op1[5],op2[5],op[5],res[10];
	int opr;
	printf("Input in form \"result\" operator1 operator operator2:\n");
	scanf("%s",res);
	scanf("%s",op1);
	scanf("%s",op);
	scanf("%s",op2);

	opr = atoi(op2);

	switch(op[0])
	{
		case '*':printf("%s->",res);
					for (i = 0; i < opr-1; ++i)
						printf("%s+",op1);
					printf("%s",op1);
					printf("\n");
				break;
		case '^':printf("%s->",res);
					for (i = 0; i < opr-1; ++i)
						printf("%s+",op1);
					printf("%s",op1);
					printf("\n");
				break;
	}
}

int before_opt_deadC()
{

	int i;
	clock_t start,end;
	double cputimeUsed;
	start = clock();
	i=1;
	global = i;
	global = 2;
	end = clock();
	cputimeUsed = ((double)(end-start))/CLOCKS_PER_SEC;
	printf("Time taken :%f\n",cputimeUsed);
	return global;
}


int after_opt_deadC()
{
	clock_t start,end;
	double cputimeUsed;
	start = clock();
	global = 2;
	end = clock();
	cputimeUsed = ((double)(end-start))/CLOCKS_PER_SEC;
	printf("Time taken :%f\n",cputimeUsed);
	return global;
}

void before_opt_Const()
{
	clock_t start,end;
	double cputimeUsed;
	int x,y,z;

	start = clock();
	x = 8;
	y = 14-x/2;
	z = y*(24/x+2);
	end = clock();
	cputimeUsed = ((double)(end-start))/CLOCKS_PER_SEC;
	printf("Time taken:%f\n",cputimeUsed);
	printf("Result:%d\n",z);
}

void after_opt_Const()
{
	clock_t start,end;
	double cputimeUsed;
	int y,z;

	start = clock();
	y = 14-8/2;
	z = y*(24/8+2);
	end = clock();
	cputimeUsed = ((double)(end-start))/CLOCKS_PER_SEC;
	printf("Time taken:%f\n",cputimeUsed);
	printf("Result:%d\n",z);
}

void before_opt_CSE()
{
	float pi=3.14,r = 4;
	clock_t start ,end;
	double cputimeUsed;
	start = clock();
	printf("Cicumference:%f\n",2*pi*r);
	printf("Area:%f\n",pi*r*r);
	end = clock();
	cputimeUsed = ((double)(end-start))/CLOCKS_PER_SEC;
	printf("Time Taken:%f\n", cputimeUsed);
}

void after_opt_CSE()
{
	float pi=3.14,r = 4,temp;
	clock_t start ,end;
	double cputimeUsed;
	start = clock();
	temp = pi*r;
	printf("Cicumference:%f\n",2*temp);
	printf("Area:%f\n",temp*r);
	end = clock();
	cputimeUsed = ((double)(end-start))/CLOCKS_PER_SEC;
	printf("Time Taken:%f\n", cputimeUsed);
}

void before_opt_codeM(int b,int c)
{
	clock_t start,end;
	double cputimeUsed;
	int i,a,z;
	start = clock();
	i=0;
	while(i<1000)
	{
		a = b*c;
		z = a+24;
		i++;
	}
	end = clock();
	cputimeUsed = ((double)(end-start))/CLOCKS_PER_SEC;
	printf("Time Taken:%f\n", cputimeUsed);

}

void after_opt_codeM(int b,int c)
{
	clock_t start,end;
	double cputimeUsed;
	int i,a,z;
	start = clock();
	a=b*c;
	i=0;
	while(i<1000)
	{
		z = a+24;
		i++;
	}
	end = clock();
	cputimeUsed = ((double)(end-start))/CLOCKS_PER_SEC;
	printf("Time Taken:%f\n", cputimeUsed);

}

void codeMovment()
{
	before_opt_codeM(4,3);
	after_opt_codeM(4,3);
}
void commonSubExp()
{
	before_opt_CSE();
	after_opt_CSE();
}

void deadCodeElimination()
{
	int a,b;
	a = before_opt_deadC();
	printf("Before opmization value :%d\n",a);
	b = after_opt_deadC();
	printf("After opmization value :%d\n",b);
}



void ConstantPropagtion()
{
	before_opt_Const();
	after_opt_Const();
}


void main()
{
	clrscr();
	StrengthReduction();
	//deadCodeElimination();
	//ConstantPropagtion();
	//commonSubExp();
	//codeMovment();
	getch();
}