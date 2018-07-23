#include<curses.h>
void main() {
	int i,j,n,temp;
	printf("Enter no of array elements: ");
	scanf("%d", &n);
	int a[n];
	printf("Enter array elements:\n");
	for(i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	for (i = 0; i < n; i++)
	{
		temp = a[i];
		j = i - 1;
		while(temp < a[j] && j >= 0) {
			a[j+1] = a[j];
			j = j - 1;
		}
		a[j+1] = temp;
	}
	printf("Insertion Sorted Array:\n");
	for(i = 0; i < n; i++) {
		printf("%d ", a[i]);
	}
	printf("\n");
}

/*Output:
Enter no of array elements: 5
Enter array elements:
5
4
3
2
1
Insertion Sorted Array:
1 2 3 4 5*/