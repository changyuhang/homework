fun oddEvenSort x =
    let
        val odd=(List.filter (fn x=>x mod 2 = 1) x)
        val even=(List.filter (fn x=>x mod 2 = 0) x)
    in
        ListMergeSort.sort (fn(x,y)=> x<y) odd@
        ListMergeSort.sort (fn(x,y)=> x>y) even
    end
