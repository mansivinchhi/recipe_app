#include<stdio.h>
#include<conio.h>

void main()
{
	int n,i,j,null[10][10],a[10][10],sum[10][10],diff[10][10];
	clrscr();
	printf("enter a size to create null matrix of order nxn");
	scanf("%d",&n);
	printf("null matrix is \n");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			null[i][j]=0;
			printf("%d",null[i][j]);
		}
		printf("\n");
	}
	printf("\n");

	printf("enter the size of first matrix a of order nxn");
	scanf("%d",&n);
	printf("enter the element of first matrix a: \n");
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			scanf("%d",&a[i][j]);
	      //sum of ij
	printf("addition of two matrices a+0 is =\n");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			sum[i][j]=a[i][j]+null[i][j];
			printf("%d \t",sum[i][j]);
		}
		printf("\n");



	}
	printf("subtraction of two matrices a-0 is =\n");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			diff[i][j]=a[i][j]-null[i][j];
			printf("%d \t",diff[i][j]);

			printf("\n");
			printf("a+0=a=a-0");
		}

	getch();

}
}