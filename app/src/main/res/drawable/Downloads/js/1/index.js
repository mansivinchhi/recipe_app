f12=()=>{

    let num1= document.querySelector('#num1').value;
    let num2 = document.querySelector('#num2').value;
    let res = document.querySelector('#res');
    res.innerHTML=parseInt(num1)+parseInt(num2);
}

f11=()=>{
    let n =prompt("Enter Number",0);
    document.write(n)
}

loopfun=()=>{

    const n = prompt("Enter N:", 1);

    document.write("<table border=1>")
    for (let i = 1; i <= 10; i++) {
        document.write("<tr>")
        document.write("<td>"+n+"</td>")
        document.write("<td>"+i+"</td>")
        document.write("<td>"+(n*i)+"</td>")
        document.write("</tr>") 
        
    }
    document.write("</table>");
}

    
    