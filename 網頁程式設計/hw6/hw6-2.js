var tempxy =[];
var tempimgpath=["林益全.jpg","林智勝.jpg","鄭凱文.jpg","陳金鋒.jpg","彭政閔.jpg","胡金龍.jpg","高國輝.jpg"];
for ( var i = 0; i < 7; i++){
  tempxy[i]=[];
  for( var j = 0; j < 2; j++){
  tempxy[i][j] = Math.floor( 1 + Math.random() * 400 );
  }
  document.write("<img style='position:absolute; left:"+tempxy[i][0]+"px; top:"+tempxy[i][1]+"px' src='resources/" + tempimgpath[i] + "'>"+"</center>");
} // end for
