;;takes a string of numbers and returns a string of the perfect squares

(fn [s]
  (loop [nums (map #(Integer/parseInt %) (re-seq #"[^,]+" s)) base [] pointer 0]
    (if (= (count nums) pointer)
      (apply str (interpose "," base))
      (if (= ((fn ispsquare [n]
       (loop [sqnum 1 checknum n incby 3]
         (if (> sqnum checknum)
           false
           (if (= sqnum checknum)
             true
             (recur (+ sqnum incby) checknum (+ incby 2)))))) (nth nums pointer)) true)
        (recur nums (conj base (str (nth nums pointer))) (+ pointer 1))
        (recur nums base (+ pointer 1))))))
