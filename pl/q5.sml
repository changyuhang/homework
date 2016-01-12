fun factorial n:IntInf.int =
    if n = 0 then 1 else n * factorial(n - 1)

    (*tail-recursive*)
fun fact x:IntInf.int =
    let
      fun factt 0 ans = ans
        | factt x ans = factt (x-1) (x*ans)
    in
      factt x 1
    end

fun countDigit(n:IntInf.int)=
    let
        fun countn (x:IntInf.int,n:IntInf.int) =
            if x = 0 then 0 else
                if x mod 10 = n then 1 + countn(x div 10,n) else countn(x div 10,n)
    in
        [countn(n,0),countn(n,1),countn(n,2),countn(n,3),countn(n,4),countn(n,5),countn(n,6),countn(n,7),countn(n,8),countn(n,9)]
    end
