#include<stdio.h>
#include<conio.h>
#include<math.h>
void main()
{
	float v,theta,h,t;
	clrscr();
	printf("enter the velocity :");
	scanf("%f",&v);
	printf("enter the engle of projection :");
	scanf("%f",&theta);
	t=sin(theta)*sin(theta);
	h=(0.5*v*v*t)/32.2;
	printf("the maximum hight reached is%f \n",h);
	getch();
}