// variables used to interact with the img elements
var die1Image;
var die2Image;
var die3Image;
var die4Image;

var die1num;
var die2num;
var die3num;
var die4num;

var resImage;
var output
// register button listener and get the img elements
function start()
{
   var button = document.getElementById( "rollButton" );
   button.addEventListener( "click", rollDice, false );
   var button_cut = document.getElementById( "shortcut" );
   button_cut.addEventListener( "click", cut, false );
   die1Image = document.getElementById( "die1" );
   die2Image = document.getElementById( "die2" );
   die3Image = document.getElementById( "die3" );
   die4Image = document.getElementById( "die4" );

   output=document.getElementById( "result" );
   resImage = document.getElementById( "res" );
} // end function start

function setRESImage(resImg, resnum)
{
  if(resnum ==1)
    resImg.setAttribute("src", "congrats.jpg");
  else if(resnum ==2)
    resImg.setAttribute("src", "oops.jpg");
  else
    resImg.setAttribute("src", "blank.png");
}

function checking(in1,in2,in3,in4)
{
 if(in1==in2&&in1==in3&&in1==in4){
   document.getElementById( "result" ).innerHTML = "Congratulations ! Your roll is \"一色\"";
   setRESImage(resImage, 1);
 }
 else if(in1!=in2&&in1!=in3&&in1!=in4&&in2!=in3&&in2!=in4&&in3!=in4){
   document.getElementById( "result" ).innerHTML = "Oops ! Your roll is \"無面\"";
   setRESImage(resImage, 2);
 }
 else{
   document.getElementById( "result" ).innerHTML = "No decision, please re-roll thr dice!";
   setRESImage(resImage, 0);
 }
}

// roll the dice
function rollDice()
{
   die1num=setImage( die1Image , die1num);
   die2num=setImage( die2Image , die2num);
   die3num=setImage( die3Image , die3num);
   die4num=setImage( die4Image , die4num);
   checking(die1num,die2num,die3num,die4num);
} // end function rollDice

// set src and alt attributes for a die
function setImage( dieImg , dienum)
{
   var dieValue = Math.floor( 1 + Math.random() * 6 );
   dieImg.setAttribute( "src", "die" + dieValue + ".png" );
   dieImg.setAttribute( "alt",
      "die image with " + dieValue + " spot(s)" );
      return dieValue;
} // end function setImage

function cut()//爆開
{
var ini1=Math.floor( 1 + Math.random() * 6 );
var ini2=ini1;
var ini3=ini1;
var ini4=ini1;

die1Image.setAttribute( "src", "die" + ini1 + ".png" );
      die1Image.setAttribute( "alt",
         "die image with " + ini1 + " spot(s)" );
die2Image.setAttribute( "src", "die" + ini1 + ".png" );
      die2Image.setAttribute( "alt",
         "die image with " + ini1 + " spot(s)" );
die3Image.setAttribute( "src", "die" + ini1 + ".png" );
      die3Image.setAttribute( "alt",
         "die image with " + ini1 + " spot(s)" );
die4Image.setAttribute( "src", "die" + ini1 + ".png" );
      die4Image.setAttribute( "alt",
         "die image with " + ini1 + " spot(s)" );
checking(ini1,ini2,ini3,ini4);
}


window.addEventListener( "load", start, false );
