(fn [o x y]
  (cond
   (o x y) :lt
   (o y x) :gt
   :else :eq))
