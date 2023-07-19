/*Write a program to take 5 integers and find and print the total and
average of the 5 numbers. Repeat the same for floating point numbers
instead of integers.*/

#include<stdio.h>
#include<conio.h>

void main()
{
	int  n1,n2,n3,n4,n5,total;
	float avg;
	clrscr();
	printf("enter the value:");
	scanf("%d%d%d%d%d",&n1,&n2,&n3,&n4,&n5);
	total=n1+n2+n3+n4+n5;
	printf("total is: %d\n",total);
	avg=total/5;
	printf("avg is: %f",avg);
	getch();
	}
	
output:

enter the value :
10
10
10
10
10

total is : 50
avg is : 10.00000