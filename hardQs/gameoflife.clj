;;description in link http://www.4clojure.com/problem/94

(ns practice.core
 (:gen-class))

(defn -main

  [& args]

  (defn getval [board square] (nth (get board (nth square 0)) (nth square 1)))
 
  (defn neighval [board square]
    (if (or (or (< (nth square 0) 0) (>= (nth square 0) (count board))) (or (< (nth square 1) 0) (>= (nth square 1) (count (get board 0)))))
     0
     (if (= (getval board square) \#)
      1
      0)))

  (defn top [board square] (neighval board [(+ (get square 0) 1) (get square 1)]))
  (defn bottom [board square] (neighval board [(- (get square 0) 1) (get square 1)]))
  (defn right [board square] (neighval board [(get square 0) (+ (get square 1) 1)]))
  (defn left [board square] (neighval board [(get square 0) (- (get square 1) 1)]))
  (defn topright [board square] (neighval board [(+ (get square 0) 1) (+ (get square 1) 1)]))
  (defn topleft [board square] (neighval board [(+ (get square 0) 1) (- (get square 1) 1)]))
  (defn bottomright [board square] (neighval board [(- (get square 0) 1) (+ (get square 1) 1)]))
  (defn bottomleft [board square] (neighval board [(- (get square 0) 1) (- (get square 1) 1)]))

  (defn sumvals [b s] (reduce + [(top b s) (bottom b s) (right b s) (left b s) (topright b s) (topleft b s) (bottomright b s) (bottomleft b s)]))

  (defn stayinAlive [board rpoint cpoint] (and (or (= (sumvals board [rpoint cpoint]) 2) (= (sumvals board [rpoint cpoint]) 3)) 
                                               (= (getval board [rpoint cpoint]) \#)))

  (defn newLife [board rpoint cpoint] (and (= (sumvals board [rpoint cpoint]) 3)        
                                            (not= (getval board [rpoint cpoint]) \#)))

  (defn gameOfLife [b]
    (loop [board b 
           rpoint 0 
           cpoint 0 
           base [] 
           nstring ""]
      (if (= rpoint (count board))
       base
       (if (= cpoint (count (get board 0)))
        (recur board (+ rpoint 1) 0 (conj base nstring) "")
        (cond
         (or (stayinAlive board rpoint cpoint) (newLife board rpoint cpoint)) (recur board rpoint (+ cpoint 1) base (str nstring "#"))
         :else (recur board rpoint (+ cpoint 1) base (str nstring " ")))))))

  (println (gameOfLife ["##  " "##  " "  ##" "  ##"]))   

)
