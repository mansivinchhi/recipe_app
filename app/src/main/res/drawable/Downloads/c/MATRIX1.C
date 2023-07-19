#include<stdio.h>
#include<conio.h>
#define size 100

void create();  // UDF to create a matrix
void print();   // UDF to print a matrix
int matrix[size][size],row,col;
void main()
{
	clrscr();
	printf("Enter no of row :");
	scanf("%d",&row);
	printf("Enter no of col :\n");
	scanf("%d",&col);

	printf("Insert no element of matrix :\n");
	create();

	printf("the give a matrix is \n");
	print();

	getch();
}
void create()
{
	int i,j;
	for(i=0;i<row;i++)
	{
		for(j=0;j<col;j++)
		{
			printf("row %d column %d",i+1,j+1);
			scanf("%d",&matrix[i][j]);
		}

	}
}
void print()
{
	int i,j;
	for(i=0;i<row;i++)
	{
		for(j=0;j<col;j++)
		{
			printf("%d",matrix[i][j]);
		}
		printf("\n");
	}


}
