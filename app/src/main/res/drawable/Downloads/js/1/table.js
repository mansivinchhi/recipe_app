
f1=()=>{
      
    let x=document.getElementById("diva").innerHTML;
  x+="<table border=1>"
  
  x+="<tr>"
  for(i=1;i<=5;i++)
     x+="<th>"+i+"</th>"
  x+="</tr>"
  
  
  for(i=1;i<=10;i++){
     x+="<tr>"
    for(j=1;j<=5;j++)
      x+="<td>"+j+" x "+i+" = "+(i*j)+"</td>"
     x+="</tr>"
   
  }
  
 x+="<tr>"
  for(i=6;i<=10;i++)
     x+="<th>"+i+"</th>"
  x+="</tr>"
  
  for(i=1;i<=10;i++){
    x+="<tr>"  
    for(j=6;j<=10;j++)
      x+="<td>"+j+" x "+i+" = "+(i*j)+"</td>"    
    x+="</tr>"  
   }
    
  x+="</table>"
  document.write(x)
}
