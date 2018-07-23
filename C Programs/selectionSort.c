#include<curses.h>
void main() {
	int i,j,n,loc,min =0,temp;
	printf("Enter the no of array elements: ");
	scanf("%d", &n);
	int a[n];
	printf("Enter array elements:\n");
	for(i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	for(i = 0; i < n; i++) {
		min = a[i];
		loc = i;
		for(j = i+1; j < n; j++) {
			if(a[j] < min) {
				min = a[j];
				loc = j;
			}
		}
		if(loc != i) {
			temp = a[i];
			a[i] = a[loc];
			a[loc] = temp;
		}
	}
	printf("Selection Sorted Array: \n");
	for(i = 0; i < n; i++) {
		printf("%d ", a[i]);
	}
	printf("\n");
}

/*Output:
Enter the no of array elements: 5
Enter array elements:
4
5
8
1
7
Selection Sorted Array:
1 4 5 7 8*/