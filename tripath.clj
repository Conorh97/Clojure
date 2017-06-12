;;returns the minimum value of a path from top to bottom of a triangle of vectors

(ns practice.core
 (:gen-class))

(defn -main

  [& args]

  (defn valAt [tree row indx] (get (get tree row) indx))

  (defn recSum [tree row indx]
   (if (= row (- (count tree) 1))
    (valAt tree row indx)
    (if (> (recSum tree (+ row 1) indx) (recSum tree (+ row 1) (+ indx 1)))
     (+ (valAt tree row indx) (recSum tree (+ row 1) (+ indx 1)))
     (+ (valAt tree row indx) (recSum tree (+ row 1) indx)))))

  (defn minPath [tree] (recSum tree 0 0))

  (println (minPath [[3] [2 4] [1 9 3] [9 9 2 4] [4 6 6 7 8] [5 7 3 5 1 4]]))

)
