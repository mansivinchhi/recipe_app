#include<stdio.h>
#include<conio.h>

void main()
{
	int m,n,p,q,i,j,k,sum=0,first[10][10],second[10][10],mul[10][10];
	clrscr();
	printf("Enter the no.of row and columns of first matrix:");
	scanf("%d%d",&m,&n);
	printf("Enter the element of matrix A: \n");

	for(i=0;i<m;i++)
	  for(j=0;j<n;j++)
	   scanf("%d",&first[i][j]);

	printf("Enter the no.of row and no.of columns of second matrix:");
	scanf("%d%d",&p,&q);

	if(n!=p)
		printf("matrix multiplication a*b is not possible:\n ");
	else
	{
		printf("Enter the elements of second matrix B: \n");
		for(i=0;i<p;i++)
		  for(j=0;j<q;j++)
		   scanf("%d",&second[i][j]);

		   for(i=0;i<m;i++)
		   {
			for(j=0;j<q;j++)
			{
				for(k=0;k<p;k++)
				{
					sum=sum+first[i][k]*second[k][j];
				}
				mul[i][j] = sum;
				sum =0;
			}
		   }

		   printf("multiplication of two matrices A*B \n");
		   for(i=0;i<m;i++)
		   {
			for(j=0;j<q;j++)
				printf("%d\t",mul[i][j]);
				printf("\n");
		   }

		  }

	getch();

}