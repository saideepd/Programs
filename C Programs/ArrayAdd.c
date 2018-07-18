#include<curses.h>
int main() {
	int i, pos, c ,n;
	printf("Enter the size of array: ");
	scanf("%d", &n);
	int a[n];
	printf("Enter array elements:\n");
	for(i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	printf("Enter the position at which you want to enter value: ");
	scanf("%d", &pos);
	printf("Enter value to enter: ");
	scanf("%d", &c);
	for (i = 4; i >= pos; i--) {
		a[i] = a[i - 1];
	}
	a[pos - 1] = c;
	printf("After insertion\n");
	for(i = 0; i < 5; i++) {
		printf("%d", a[i]);
	}
	printf("\n");
	return 0;
}