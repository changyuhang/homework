datatype 'a btree = Empty | Node of 'a btree * 'a * 'a btree;

val t = Node(Node(Empty,"1",Node(Empty,"1",Empty)),"Test",Node(Node(Node(Empty,"Hand",Empty),"Right",Node(Empty,"Foot",Empty)),"Kick",Empty));

fun prefix Empty = [] | prefix (Node(l, v, r)) = v:: prefix l @ prefix r;

fun innfix Empty = [] | innfix (Node(l, v, r)) = innfix l @v:: innfix r;

fun postfix Empty = [] | postfix (Node(l, v, r)) = postfix l @ postfix r @ [v];

fun countNode Empty = 0 | countNode (Node(l, v, r)) = 1 + countNode l + countNode r

fun countLeaf (Empty) = 0 | countLeaf (Node(l, v, r))=
    if l = Empty andalso r = Empty then 1
    else countLeaf l + countLeaf r

fun findNode (f, Empty) = false | findNode (f, Node(l, v, r)) =
    if(v = f) then true
    else findNode (f, l) orelse findNode (f, r)
