#include<curses.h>
void main() {
	int n, i, key, beg = 0, mid = 0, end, flag = 0;
	printf("Enter no of array elements: ");
	scanf("%d", &n);
	int a[n];
	printf("Enter array elements:\n");
	for(i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	printf("Enter the element you want to search: ");
	scanf("%d", &key);
	end = n - 1;
	while(beg <= end) {
		mid = ((beg + end) / 2);
		if(key == a[mid]) {
			printf("Element %d found at position: %d\n", key, mid+1);
			flag = flag + 1;
			break;
		}
		else if(key < a[mid]) {
			end = mid - 1;
		}
		else
			beg = mid + 1;
	}
	if(flag == 0)
		printf("Search not successful\n");
}