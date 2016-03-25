var amount1;
var amount2;
var amount3;
var amount4;

amount1=window.prompt("Please input the quantity of product of no. 1","0");
amount2=window.prompt("Please input the quantity of product of no. 2","0");
amount3=window.prompt("Please input the quantity of product of no. 3","0");
amount4=window.prompt("Please input the quantity of product of no. 4","0");

document.writeln( "<table>" ); // begin the table
document.writeln(
   "<caption>Earnings for Salepeople</caption>" );
document.writeln(
   "<thead><tr><th>Product</th>" );
document.writeln(
   "<th>Unit Price</th>" );
   document.writeln(
   "<th>Quantity</th>" );
   document.writeln(
   "<th>Subtotal</th>" );


document.writeln( "</tr></thead><tbody>" );

//output
var out1=(amount1*49.0);
var out2=(amount2*99.0);
var out3=(amount3*199.0);
var out4=(amount4*299.0);
var sum=out1+out2+out3+out4;

document.writeln("<tr><td>"+ '1' +"</td><td>"+ '49.0' +"</td><td>"+amount1+"</td><td>"+out1.toFixed(1)+"</td></tr>");
document.writeln("<tr><td>"+ '2' +"</td><td>"+ '99.0' +"</td><td>"+amount2+"</td><td>"+out2.toFixed(1)+"</td></tr>");
document.writeln("<tr><td>"+ '3' +"</td><td>"+ '199.0' +"</td><td>"+amount3+"</td><td>"+out3.toFixed(1)+"</td></tr>");
document.writeln("<tr><td>"+ '4'+"</td><td>"+ '299.0' +"</td><td>"+amount4+"</td><td>"+out4.toFixed(1)+"</td></tr>");


document.writeln("<tr><th colspan=3>"+'Total'+"</th><td>"+sum.toFixed(1)+"</td></tr>");
document.writeln("<tr><th colspan=3>"+'Earnings'+"</th><td>"+(sum*0.09+200).toFixed(1)+"</td></tr>");

document.writeln( "</tbody></table>" );
