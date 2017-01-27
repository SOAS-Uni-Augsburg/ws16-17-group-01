% Aufgabe 1b, Gruppe 1

include "alldifferent.mzn";
int: a = 1;
int: b = 2;
int: c = 3;
int: d = 4;
int: e = 5;
int: f = 6;
int: g = 7;
int: h = 8;

set of int: knots = {a,b,c,d,e,f,g,h};
set of int: values = 1..8;
array[knots] of var values: value;
array[knots, knots] of int: neighboors;

neighboors = [|1, 1, 1, 1, 0, 0, 0, 0,
              |1, 1, 1, 0, 1, 1, 0, 0,
              |1, 1, 1, 1, 1, 1, 1, 0,
              |1, 0, 1, 1, 0, 1, 1, 0,
              |0, 1, 1, 0, 1, 1, 0, 1,
              |0, 1, 1, 1, 1, 1, 1, 1,
              |0, 0, 1, 1, 0, 1, 1, 1,
              |0, 0, 0, 0, 1, 1, 1, 1|];

constraint alldifferent(value);
constraint forall(i,j in knots where neighboors[i,j] == 1)(
               if i != j then
                 abs(value[i]-value[j]) > 1
               else
                 value[i] = value[j]
               endif           
           );
solve satisfy;