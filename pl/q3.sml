fun f(x: real) = (x*x*x) - (2.0*x*x) - 3.0;

fun bs(f, l: real, h: real) =
    let
        fun horl(f, l: real, h: real) =
        if(f(l) * f(h) < 0.00) then true else false
    in
        if(Real.==(l,h)) then l
        else
            if(horl(f, (l + h) / 2.00, h)) then bs(f, (l + h) / 2.00, h)
            else                                bs(f, l, (l + h) / 2.00)
    end
