;;gives the length of the shortest path between two numbers by doubling, halving or adding two

(fn [x y]
  (loop [start x 
         end y 
         len 1]
    (if (= start end)
      len
      (cond
       (and (odd? start) (> start end)) (recur (+ (* start 2) 2) end (+ len 2))
       (and (and (even? end) (< start end)) (or (<= start (/ end 2)) (= (- end start) 1))) (recur (* start 2) end (+ len 1)) 
       (and (even? start) (= (mod start (* end 2)) 0)) (recur (/ start 2) end (+ len 1))
       :else (recur (+ start 2) end (+ len 1))))))
