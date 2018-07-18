#include<curses.h>
void main() {
	int a[5], i, b;
	printf("Enter array elements:\n");
	for(i = 0; i < 5; i++) {
		scanf("%d", &a[i]);
	}
	printf("Enter the element you want to search: ");
	scanf("%d", &b);
	for(i = 0; i < 5; i++) {
		if(a[i] == b) {
			printf("Element %d found at position: %d\n", b, i+1);
			break;
		}
	}
	if(a[i] != b) {
		printf("Element %d not found\n", b);
	}
}