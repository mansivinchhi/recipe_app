#include<stdio.h>
#include<conio.h>

void main()
{
	int i,j,m,n,A[10][10],transpose[10][10],count=0;
	clrscr();

	printf("enter the no of rows and columns of matrix A:");
	scanf("%d%d",&m,&n);

	printf("Enter the elements of matrix A: \n");
	for(i=0;i<m;i++)
		for(j=0;j<n;j++)
			scanf("%d",&A[i][j]);


	for(i=0;i<m;i++)
		for(j=0;j<n;j++)
			transpose[j][i]=A[i][j];

	printf("transpose of given matrix :\n");

	for(i=0;i<n;i++)
	{
		for(j=0;j<m;j++)
			printf("%d\t",transpose[i][j]);
			printf("\n");

	}
		/* to check A=A' or not ???*/
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				if(A[i][j]==transpose[i][j])
				{
					count++;
					if(count==(m*n))
					{
						printf("yes, A=A, so matrix A is symetric matrix:");
						getch();
						return 0;

					}
				}
			}
		}
		printf("no ,A is not equal to A',so matrix A is not symetric matrix.");
		getch();
		return 0;
	      }