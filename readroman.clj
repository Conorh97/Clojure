;;converts roman numerals to integers

(fn [n]
  (loop [rnum n
         pointer 0
         total 0
         values {\M 1000,
         "CM" 900,
         \D 500,
         "CD" 400,
         \C 100,
         "XC" 90,
         \L 50,
         "XL" 40,
         \X 10,
         "IX" 9,
         \V 5,
         "IV" 4,
         \I 1}]
    (if (>= pointer (count rnum))
      total
      (if (= pointer (- (count rnum) 1))
        (recur rnum (+ pointer 1) (+ total (get values (get rnum pointer))) values)
        (if (contains? values (subs rnum pointer (+ pointer 2)))
          (recur rnum (+ pointer 2) (+ total (get values (subs rnum pointer (+ pointer 2)))) values)
          (recur rnum (+ pointer 1) (+ total (get values (get rnum pointer))) values))))))
