#include<curses.h>
int fact(int);
int main() {
	int n;
	printf("Enter the no: ");
	scanf("%d",&n);
	printf("Factorial of no %d: %d\n", n, fact(n));
	return 0;
}
int fact(int n1) {
	if(n1 == 0)
		return 1;
	else
		return (n1 * fact(n1-1));
}