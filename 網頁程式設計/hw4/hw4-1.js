var inp;
var text;
inp=window.prompt("2016 MLB總冠軍您支持哪一隊\n(1)波士頓紅襪隊(BOS) \n(2)聖路易紅雀隊(STL)。\n請輸入選項(1或2)","0");
switch(inp){
    case '1':
    document.writeln( "<h1><a href = http://mlb.mlb.com/home >2016 MLB 世界大賽</a></h1>");
    document.writeln( "<h2><a href = http://boston.redsox.mlb.com >波士頓紅襪隊(BOS)</a></h2>");
    document.writeln( "<p><span>波士頓紅襪</span>隸屬於美國職棒大聯盟的美國聯盟東區。其主場自1912年後即位於麻薩諸塞州波士頓的芬威球場。「紅襪」這個名字是在1908年左右由球隊當時的老闆泰勒所取，隊徽也是應此名字而設計。該球隊創建於1901年紐約州的布法羅市，是美國聯盟最早的八支球隊之一。自從布法羅搬遷到波士頓後，他們即變成了一支舉足輕重的球隊——首先在1903年的世界大賽中擊敗了匹茲堡海盜隊，而後到1918年之間，他們又共奪得了4次世界冠軍，但是在這之後卻進入了美國職業棒球史上最長的一段冠軍乾旱期。很多人認為這是因為「貝比魯斯魔咒」，這個魔咒來源於1920年紅襪將貝比魯斯賣給了紐約洋基隊。這段時間是紅襪隊史上最困難的一段時期，包括了1946年的「瘋狂衝刺」，1968年的「不可能的夢想」，以及1974年和1986年兩次和世界大賽冠軍擦肩而過。這個詛咒終於在2004年結束，紅襪奪得了隊史上的第六個世界大賽冠軍。自從2003年後，紅襪6次進入季後賽，並且奪得了兩次世界冠軍，被認為是近幾年來最成功的球隊之一。紅襪隊近幾年的特徵為大鬍子，與需要剃鬍子的洋基隊成為強烈的對比。</p>");
    break;
    case '2':
    document.writeln( "<h1><a href = http://mlb.mlb.com/home >2016 MLB 世界大賽</a></h1>");
    document.writeln( "<h2><a href = http://stlouis.cardinals.mlb.com >聖路易紅雀隊(STL)</a></h2>");
    document.writeln( "<p><span>聖路易紅雀</span>是美國職棒大聯盟中隸屬於國家聯盟的棒球隊伍之一。主場位於密蘇里州的聖路易斯。在國家聯盟的分區中，屬於國家聯盟中區。他們總計共獲得11次世界大賽冠軍，是國家聯盟是獲得最多冠軍的球隊。在大聯盟所有球隊中，僅次於紐約洋基（獲得27次世界大賽冠軍）。紅雀最早是創立於1882年，當時的聯盟為美國協會，球隊取名為聖路易棕長襪（St. Louis Brown Stockings），之後在1892年加入國家聯盟，並在1900年改名為現在大家所熟悉的隊名聖路易紅雀。紅雀現所使用的主場為布希體育場（Busch Stadium），於2006年開始啟用，在啟用的第1年，紅雀便奪下該年的世界大賽冠軍，上一次在主場啟用第1年便奪下世界大賽冠軍的是1923年的洋基（最近一次是2009年的洋基體育場）。紅雀隊在近幾年有憤怒鳥的稱號。</p>");
    break;
    default:
    alert("您的選項錯誤，請按[F5]重新輸入!");
    break;
}
