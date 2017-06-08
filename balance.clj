;;checks if the sum of the digits in the top and bottom halfs of an integer are the same

(fn [n]
  (loop [vecto (map #(Character/digit % 10) (str n)) ;;converts a number into a vector of digits 
         spoint 0 
         epoint (- (count (seq (str n))) 1) 
         bottom [] 
         top []]
    (if (>= spoint epoint)
      (= (reduce + bottom) (reduce + top))
      (recur vecto 
             (+ spoint 1) 
             (- epoint 1) 
             (conj bottom (nth vecto spoint)) 
             (conj top (nth vecto epoint))))))
