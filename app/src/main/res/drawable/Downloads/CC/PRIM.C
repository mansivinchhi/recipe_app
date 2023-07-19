#include<stdio.h>
#include<conio.h>
int main()
{
	int num,i,j,flag=0,count=0;
	clrscr();
	printf("how many number you want to print");
	scanf("%d",&num);
       for(i=2; count<num; i++)
		{
			for(j=2;j<i; j++)
			{
				if(i%j==0)
				{
					flag++;
					break;
				}
			}
			if(flag==0)
			{       count++;
				printf("\n%d",i);
			}
			flag=0;

		}
		getch();
}
