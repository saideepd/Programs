#include<curses.h>
int top = -1, stack[5];
void push();
void pop();
void traverse();
void main() {
	int ch;
	do {
		printf("\n1. Push\n2. Pop\n3. Traverse\n4. Exit\nEnter your choice: ");
		scanf("%d", &ch);
		switch(ch) {
			case 1:	push();
					break;
			case 2:	pop();
					break;
			case 3:	traverse();
					break;
			case 4:	break;
			default: printf("Wrong choice bruh !!!\n");
					break;
		}
	}
	while(ch != 4);
}
void push() {
	int a;
	if(top == 4) {
		printf("The stack is full\n");
	}
	else {
		printf("Enter the number: ");
		scanf("%d", &a);
		top += 1;
		stack[top] = a;
	}
}
void pop() {
	int i;
	if(top == -1) {
		printf("The stack is empty\n");
	}
	else {
		i = stack[top];
		top -= 1;
		printf("The deleted number is %d", i);
	}
}
void traverse() {
	if(top == -1) {
		printf("The stack is empty");
	}
	else{
		for(int i = top; i >= 0; i--) {
			printf("\t%d", stack[i]);
		}
	}
}