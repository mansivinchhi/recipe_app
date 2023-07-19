#include<stdio.h>
#include<conio.h>

void main()
{
	int m,n,i,j,k,sum=0;
	int null[10][10],unit[10][10],first[10][10],mul[10][10];
	clrscr();

	printf("enter a size to create null matrix of order nxn");
	scanf("%d",&n);
	printf("null matrix is \n");

	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			null[i][j]=0;
			unit[i][j]=0;
			if(i==j)
			{
				unit[i][j]=1;
			}
			printf("%d",null[i][j]);
		}
		printf("\n");
	}
		printf("\n");

		printf("unit matrix is \n");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				printf("%d",unit[i][j]);

			}
			printf("\n");
		}
		printf("enter the no of element of first matrix = \n");
		scanf("%d%d",&m,&n);
		printf("enter the elemrnt of first matrix a= \n");
		for(i=0;i<m;i++)
			for(j=0;j<n;j++)
				scanf("%d",&first[i][j]);

		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				for(k=0;k<n;k++)
				{
					sum=sum+first[i][k]*unit[k][j];
				}
				mul[i][j] = sum;
				sum=0;
			}


		}
		printf("multiplication of matrix \n");
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
				printf("%d",mul[i][j]);
				printf("\n");

		}
	printf("a*i = a = i*a ");
	getch();

}
