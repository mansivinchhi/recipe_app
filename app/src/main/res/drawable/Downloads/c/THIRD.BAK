#include<stdio.h>
#include<conio.h>

int isSubset(int a[],int x[],int m,int n)

{

  int i=0,j=0;
  for(i=0;i<n;i++)
  {
	for(j=0;j<m;j++)
	{
	 if(x[i]==a[j])
	 break;
	}
	if(j==m)
	return 0;
  }
	return 1;
  }
void main()
{
	int *a,*x,m,n,i;
	clrscr();
	printf("Enter how many elements :");
	scanf("%d",&m);
	for(i=0;i<m;i++)
	{
		printf("enter how many elements are you requird in set A [%d]",i);
		scanf("%d",&a[i]);


	}
	printf("\n enter how many elements are you requird in set B");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("enter the element of set B %d\n",i);
		scanf("%d",&x[i]);


	}
	if(isSubset(a,x,m,n))
	{
		printf("x is a subset of A");
	}
	else
	{
		printf("x is not a subset of A");
	}
	getch();


}