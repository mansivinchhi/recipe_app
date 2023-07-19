Write a program to find the sum of 1, 2, 3, … , n. Print average (avg)
also.


#include<stdio.h>
#include<conio.h>

void main()
{
	int  n,i,sum=0;
	float avg;
	clrscr();
	printf("Enter any no:");
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		printf("%d\n",i);
		sum=sum+i;
	}
	printf("%d\n",sum);
	avg=sum/n;
	printf("%f",avg);

	getch();

}