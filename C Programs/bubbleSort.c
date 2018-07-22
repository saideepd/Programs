#include<curses.h>
void main() {
	int i,j,n,temp;
	printf("Enter no of elements: ");
	scanf("%d", &n);
	int a[n];
	printf("Enter array elements:\n");
	for(i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	for(i = 0; i < n; i++) {
		for(j = 0; j < n-1; j++) {
			if(a[j] > a[j+1]) {
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	printf("Bubble Sorted Array:\n");
	for(i = 0; i < n; i++) {
		printf("%d ", a[i]);
	}
	printf("\n");
}