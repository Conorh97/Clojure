;; returns the largest increasing sub-sequence in a vector of integers

(ns practice.core
 (:gen-class))

(defn -main

  [& args]
  
  (defn getSubseq [x]
    (loop [vecto x pointer 0 highest [] current [(get x 0)]]
      (if (= pointer (- (count vecto) 1))
       (cond
        (and (< (count highest) 2) (< (count current) 2)) []
        (> (count current) (count highest)) current
        :else highest)
       (if (> (get vecto (+ pointer 1)) (get vecto pointer))
        (recur vecto (+ 1 pointer) highest (conj current (get vecto (+ pointer 1))))
          (if (> (count current) (count highest))
           (recur vecto (+ pointer 1) current [(get vecto (+ pointer 1))])
           (recur vecto (+ pointer 1) highest [(get vecto (+ pointer 1))])))))) 

  (println (getSubseq [0 1 0 2 3]))
 
)

