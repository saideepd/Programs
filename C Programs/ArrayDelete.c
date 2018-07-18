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
	printf("Enter the element you want to delete element: ");
	scanf("%d", &pos);
	a[pos - 1] = a[pos];
	for (i = pos; i < 5; i++) {
		a[i] = a[i + 1];
	}
	printf("After deletion:\n");
	for(i = 0; i < (n-1); i++) {
		printf("%d", a[i]);
	}
	printf("\n");
	return 0;
}