;;given n, returns the function (f x) which gives x^^n

(fn [n]
  (fn [x]
   (reduce * (repeat n x))))
