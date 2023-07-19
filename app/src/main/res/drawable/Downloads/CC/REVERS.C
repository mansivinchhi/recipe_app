#include<stdio.h>
#include<conio.h>
void main()
{
	int a[5],no,i,j,temp;
	clrscr();
	printf("Enetr the any number you want to :");
	scanf("%d",&no);
	for(i=0; i<no; i++)
	{
		scanf("%d",&a[i]);

	}
	for(i=0; i<no; i++)
	{
	       //	printf("\n %d",a[i]);
	}
	i=no-1;
	for(j=0; j<i; j++)
	{
		temp=a[j];
		a[j]=a[i];
		a[i]=temp;
		i--;

	}
	for(i=0; i<no; i++)
	{
		printf("\n %d",a[i]);
	}

	getch();
}