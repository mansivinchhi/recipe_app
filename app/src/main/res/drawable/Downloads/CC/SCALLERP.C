#include<stdio.h>
#include<conio.h>
void main()
{
	int i,j,m,n,A[10][10],num;
	clrscr();
	printf("Enter the no.of rows and no.of column of matrix :");
	scanf("%d%d",&m,&n);

	printf("Enter the element of matrix :- \n");
	for(i=0;i<m;i++)
		for(j=0;j<n;j++)
			scanf("%d",&A[i][j]);

       printf("enter any number to multiply with A =");
       scanf("%d",&num);
       for(i=0;i<m;i++)
       {

		for(j=0;j<n;j++)
		{
			A[i][j] = num * A[i][j];
		}
       }
       for(i=0; i<m; i++)
	{
		for(j=0;j<n;j++)
		{
			printf("%d",A[i][j]);
		}

	}

}
	getch();

