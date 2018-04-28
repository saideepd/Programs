#include<stdio.h>
#include<conio.h>
void main() {
	char a[10], a1[10], a2[10], a3[10], a4[10], a5[10];
	int i, j, k, l;
	clrscr();
	printf("Enter any Productions A-> ");
	gets(a);
	for(i=0, j=0; a[i]!='/'; i++, j++)
	a1[j] = a[i];
	a1[j] = '\0';
	for(j=++i, i=0; a[j]!='\0'; j++, i++)
	a2[i] = a[j];
	a2[i] = '\0';
	k = 0;
	l = 0;
	for(i=0; i<strlen(a1)||i<strlen(a2); i++) {
		if(a1[i] == a2[i]) {
			a3[k] = a1[i];
			k++;
		}
		else {
			a4[l] = a1[i];
			a5[l] = a2[i];
			l++;
		}
	}
	a3[k] = 'X';
	a3[++k] = '\0';
	a4[l] = '/';
	a5[l] = '\0';
	a4[++l] = '\0';
	strcat(a4, a5);
	printf("\nA -> %s", a3);
	printf("\nX -> %s", a4);
	getch();
}
/*Enter any Productions A-> bcd/bcf
A -> bcX
X -> d/f*/