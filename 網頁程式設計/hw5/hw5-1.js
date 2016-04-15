var baseball;
var shape;
var result;
function start()
{
  result = document.getElementById( "result" );
  var tributton = document.getElementById( "drewBaseballTriangleButton" );
  var squbutton = document.getElementById( "drewBaseballSquareButton" );
  tributton.addEventListener( "click", triangle, false );
  squbutton.addEventListener( "click", square, false );
}

function square()
{
  var temp="";
  var num = document.getElementById( "width" ).value;
  if(num<=10&&num>=0){
    temp+="<table>";
    for ( var i = 1; i <= num; i++ ){
      temp+="<tr>";
      for ( var j = 1; j <= num; j++ ){
        temp+="<td><img src=baseball.jpg height='50' width='50'/></td>";
      }
      temp+="</tr>"
    }
    temp+="</table>";
  }
  else {alert("輸入錯誤")}
  result.innerHTML=temp;
}

function triangle()
{
  var temp="";
  var num = document.getElementById( "width" ).value;
  if(num<=10&&num>=0){
    temp+="<table>";
    for ( var i = 1; i <= num; i++ ){
      temp+="<tr>";
      for ( var j = 1; j <= i; j++ ){
        temp+="<td><img src=baseball.jpg height='50' width='50'/></td>";
      }
      temp+="</tr>"
    }
    temp+="</table>";
  }
  else {alert("輸入錯誤")}
  result.innerHTML=temp;
}

window.addEventListener( "load", start, false );
